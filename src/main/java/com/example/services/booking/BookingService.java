package com.example.services.booking;

import com.example.models.*;
import com.example.repositories.BookingRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.function.Function;

public class BookingService {
    private final Scanner scanner;
    private final BookingRepository bookingRepository;

    public BookingService(Scanner scanner) {
        this.scanner = scanner;
        this.bookingRepository = BookingRepository.getInstance();
    }

    public void createBooking(Accommodation accommodation, Object selection) {
        if (accommodation instanceof Stay stay && selection instanceof Room room) {
            processStayBooking(stay, room);
        } else if (accommodation instanceof DayPass dayPass && selection instanceof Service service) {
            processDayPassBooking(dayPass, service);
        } else {
            throw new IllegalArgumentException("Tipo de alojamiento o selección no soportados");
        }
    }

    private void processStayBooking(Stay stay, Room room) {
        DetailsStay details = collectStayDetails(stay);
        printSummary("Resumen de la reserva:", details, stay.getName(), room.getType());
        confirmAndCreate(stay, details, room.getPrice());
    }

    private void processDayPassBooking(DayPass dayPass, Service service) {
        Details details = collectDayPassDetails(dayPass);
        printSummary("Resumen de la reserva:", details, dayPass.getName(), service.getName());
        confirmAndCreate(dayPass, details, dayPass.getPersonPrice());
    }

    private DetailsStay collectStayDetails(Stay stay) {
        LocalDate startDate = promptDate("Ingrese la fecha de inicio (DD/MM/YYYY):");
        LocalDate endDate = promptDate("Ingrese la fecha de fin (DD/MM/YYYY):");
        Integer adults = promptInt("Ingrese la cantidad de adultos:");
        Integer children = promptInt("Ingrese la cantidad de niños:");
        Integer rooms = promptInt("Ingrese la cantidad de habitaciones:");

        return new DetailsStay(startDate, children, adults, endDate, rooms, stay.getCity(), stay.getType());
    }

    private Details collectDayPassDetails(DayPass dayPass) {
        LocalDate date = promptDate("Ingrese la fecha del día de sol (DD/MM/YYYY):");
        int adults = promptInt("Ingrese la cantidad de adultos:");
        int children = promptInt("Ingrese la cantidad de niños:");

        return new Details(date, children, adults, dayPass.getCity(), dayPass.getType());
    }

    private void printSummary(String header, Details details, String accommodationName, String selectionName) {
        System.out.printf("%s%nCiudad: %s%nAlojamiento: %s%nSelección: %s%nNiños: %d, Adultos: %d%n",
                header, details.getCity(), accommodationName, selectionName, details.getChildrenQuantity(), details.getAdultsQuantity());
    }

    private void confirmAndCreate(Accommodation accommodation, Details details, Float unitPrice) {
        Float totalPrice = unitPrice * (details.getAdultsQuantity() + details.getChildrenQuantity());
        System.out.printf("Precio total: $%.2f %n¿Desea confirmar su reserva? (S/N)%n", totalPrice);

        if (scanner.nextLine().equalsIgnoreCase("S")) {
            Client client = createClient();
            Booking booking = new Booking(accommodation, client, details);
            bookingRepository.addOrReplaceBooking(booking);
            showBooking();
            System.out.println("¡Reserva creada exitosamente!");
        } else {
            System.out.println("Reserva cancelada.");
        }
    }

    private void showBooking() {
        Booking booking = bookingRepository.getBooking();
        if (booking == null) {
            System.out.println("No hay reservas creadas.");
            return;
        }
        System.out.println("Reserva actual:" + "\n" + booking.toString());
    }

private Client createClient() {
    String firstName = promptString("Ingrese su nombre:");
    String lastName = promptString("Ingrese su apellido:");
    LocalDate birthDate = promptDate("Ingrese su fecha de nacimiento (DD/MM/YYYY):");
    String phone = promptString("Ingrese su número de teléfono:");
    String nationality = promptString("Ingrese su nacionalidad:");
    LocalTime arrivalTime = promptTime("Ingrese su hora de llegada (HH:MM):");
    String email = promptString("Ingrese su correo electrónico:");

    return new Client(firstName, lastName, birthDate, phone, nationality, arrivalTime, email);
}

private LocalDate promptDate(String message) {
    return prompt(message, input -> LocalDate.parse(input, DateTimeFormatter.ofPattern("dd/MM/yyyy")));
}

private LocalTime promptTime(String message) {
    return prompt(message, input -> LocalTime.parse(input, DateTimeFormatter.ofPattern("HH:mm")));
}

private Integer promptInt(String message) {
    return prompt(message, Integer::parseInt);
}

private String promptString(String message) {
    System.out.println(message);
    return scanner.nextLine();
}

private <T> T prompt(String message, Function<String, T> parser) {
    while (true) {
        try {
            System.out.println(message);
            return parser.apply(scanner.nextLine());
        } catch (Exception e) {
            System.out.println("Entrada no válida, inténtelo nuevamente.");
        }
    }
}
}
