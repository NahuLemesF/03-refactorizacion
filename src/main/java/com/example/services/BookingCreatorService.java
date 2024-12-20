package com.example.services;

import com.example.models.*;
import com.example.data.Database;

import java.time.LocalDate;

public class BookingCreatorService {
    private InputService inputService;
    private ClientService clientService;
    private SummaryPrinter summaryPrinter;
    private PriceCalculator priceCalculator;

    public BookingCreatorService(
            InputService inputService,
            ClientService clientService,
            SummaryPrinter summaryPrinter,
            PriceCalculator priceCalculator
    ) {
        this.inputService = inputService;
        this.clientService = clientService;
        this.summaryPrinter = summaryPrinter;
        this.priceCalculator = priceCalculator;
    }

    public void createBooking(Accommodation accommodation, Object selection) {
        if (isStayBooking(accommodation, selection)) {
            processStayBooking((Stay) accommodation, (Room) selection);
            return;
        }
        processDayPassOrThrow(accommodation, selection);
    }

    private boolean isStayBooking(Accommodation accommodation, Object selection) {
        return accommodation instanceof Stay && selection instanceof Room;
    }

    private boolean isDayPassBooking(Accommodation accommodation, Object selection) {
        return accommodation instanceof DayPass && selection instanceof Service;
    }

    private void processDayPassOrThrow(Accommodation accommodation, Object selection) {
        if (isDayPassBooking(accommodation, selection)) {
            processDayPassBooking((DayPass) accommodation, (Service) selection);
            return;
        }
        throwInvalidBooking();
    }

    private void throwInvalidBooking() {
        throw new IllegalArgumentException("Tipo de alojamiento o selección no soportados");
    }

    private void processStayBooking(Stay stay, Room room) {
        DetailsStay details = collectStayDetails(stay);
        summaryPrinter.printSummary("Resumen de la reserva:", details, stay.getName(), room.getType());

        float totalPrice = priceCalculator.calculateStayPrice(
                room.getPrice(),
                details.getRoomsQuantity(),
                details.getAdultsQuantity() + details.getChildrenQuantity()
        );

        confirmAndCreate(
                stay,
                details,
                totalPrice,
                details.getAdultsQuantity() + details.getChildrenQuantity(),
                room.getType()
        );
    }

    private void processDayPassBooking(DayPass dayPass, Service service) {
        Details details = collectDayPassDetails(dayPass);
        summaryPrinter.printSummary("Resumen de la reserva:", details, dayPass.getName(), service.getName());

        Float totalPrice = priceCalculator.calculateDayPassPrice(
                dayPass.getPersonPrice(),
                details.getAdultsQuantity() + details.getChildrenQuantity()
        );

        confirmAndCreate(
                dayPass,
                details,
                totalPrice,
                details.getAdultsQuantity() + details.getChildrenQuantity(),
                service.getName()
        );
    }

    private DetailsStay collectStayDetails(Stay stay) {
        LocalDate startDate = inputService.promptDate("Ingrese la fecha de inicio (DD/MM/YYYY):");
        LocalDate endDate = inputService.promptDate("Ingrese la fecha de fin (DD/MM/YYYY):");
        Integer adults = inputService.promptInt("Ingrese la cantidad de adultos:");
        Integer children = inputService.promptInt("Ingrese la cantidad de niños:");
        Integer rooms = inputService.promptInt("Ingrese la cantidad de habitaciones:");

        return new DetailsStay(startDate, children, adults, endDate, rooms, stay.getCity(), stay.getType());
    }

    private Details collectDayPassDetails(DayPass dayPass) {
        LocalDate date = inputService.promptDate("Ingrese la fecha del día de sol (DD/MM/YYYY):");
        Integer adults = inputService.promptInt("Ingrese la cantidad de adultos:");
        Integer children = inputService.promptInt("Ingrese la cantidad de niños:");

        return new Details(date, children, adults, dayPass.getCity());
    }

    private void confirmAndCreate(
            Accommodation accommodation,
            Details details,
            Float totalPrice,
            Integer totalPeople,
            String selectionName
    ) {
        summaryPrinter.printTotalPrice(totalPrice);
        summaryPrinter.printConfirmationPrompt();

        if (inputService.promptString("").equalsIgnoreCase("S")) {
            Client client = clientService.createClient();
            summaryPrinter.printClientDetails(client);

            Booking booking = new Booking(accommodation, client, details);
            Database.getBookings().add(booking);

            System.out.println("¡Reserva creada exitosamente!");
            return;
        }
        System.out.println("Reserva cancelada.");
    }
}