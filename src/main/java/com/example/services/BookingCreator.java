package com.example.services;

import com.example.models.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public  class BookingCreator {
    private final Scanner scanner;

    public BookingCreator(Scanner scanner) {
        this.scanner = scanner;
    }

    public void createBooking(Stay stay, Room room) {
        DetailsStay detailsStay = collectDetailsStay(stay);

        System.out.println(
                "Resumen de la reserva:" +
                        "\nCiudad: " + detailsStay.getCity() +
                        "\nAlojamiento: " + stay.getName() +
                        "\nTipo de Alojamiento: " + detailsStay.getAccommodationType() +
                        "\nHabitación: " + room.getType() +
                        "\nCantidad de Habitaciones: " + detailsStay.getRoomsQuantity() +
                        "\nNiños: " + detailsStay.getChildrenQuantity() + ", Adultos: " + detailsStay.getAdultsQuantity() +
                        "\nFechas: Desde " + detailsStay.getStartDate() + " hasta " + detailsStay.getEndDate() +
                        "\nPrecio por noche: " + room.getPrice() + " USD");

        float basePrice = room.getPrice();
        float totalPrice = calculateTotalPrice(basePrice, detailsStay.getAdultsQuantity() + detailsStay.getChildrenQuantity(), detailsStay);
        System.out.println("Precio total: " + totalPrice + " USD" + "\n¿Desea confirmar su reserva? (S/N)");
        String confirmation = scanner.nextLine();

        if (confirmation.equalsIgnoreCase("S")) {
            Client client = createClient();

            System.out.println(
                    "¡Gracias! Su reserva ha sido confirmada." +
                            "\nDetalle de la reserva:" +
                            "\nCliente: " + client.getFirstName() + " " + client.getLastName() +
                            "\nFecha de nacimiento: " + client.getBirthDate() +
                            "\nTeléfono: " + client.getPhoneNumber() +
                            "\nNacionalidad: " + client.getNationality() +
                            "\nCorreo: " + client.getEmail() +
                            "\nHora de llegada: " + client.getArrivalTime());
        } else {
            System.out.println("Reserva cancelada.");
        }
    }

    private DetailsStay collectDetailsStay(Stay staySelected) {
        System.out.println("Ingrese la fecha de inicio (DD/MM/YYYY):");
        LocalDate startDate = formatDate();

        System.out.println("Ingrese la fecha de fin (DD/MM/YYYY):");
        LocalDate endDate = formatDate();

        System.out.println("Ingrese la cantidad de adultos:");
        int adultsQuantity = Integer.parseInt(scanner.nextLine());

        System.out.println("Ingrese la cantidad de niños:");
        int childrenQuantity = Integer.parseInt(scanner.nextLine());

        System.out.println("Ingrese la cantidad de habitaciones:");
        int roomsQuantity = Integer.parseInt(scanner.nextLine());


        return new DetailsStay(startDate, childrenQuantity, adultsQuantity, endDate, roomsQuantity, staySelected.getCity(), staySelected.getType());
    }

    private Client createClient() {
        System.out.println("Ingrese su nombre:");
        String firstName = scanner.nextLine();

        System.out.println("Ingrese su apellido:");
        String lastName = scanner.nextLine();

        System.out.println("Ingrese su fecha de nacimiento (DD/MM/YYYY):");
        LocalDate birthDate = formatDate();

        System.out.println("Ingrese su número de teléfono:");
        String phoneNumber = scanner.nextLine();

        System.out.println("Ingrese su nacionalidad:");
        String nationality = scanner.nextLine();

        System.out.println("Ingrese su hora de llegada (HH:MM):");
        LocalTime arrivalTime = LocalTime.parse(scanner.nextLine());

        System.out.println("Ingrese su correo electrónico:");
        String email = scanner.nextLine();

        return new Client(firstName, lastName, birthDate, phoneNumber, nationality, arrivalTime, email);
    }

    public float calculateTotalPrice(float pricePerNight, int numberOfPeople, DetailsStay detailsStay) {
        double adjustment = 0;

        int startDay = detailsStay.getStartDate().getDayOfMonth();
        int endDay = detailsStay.getEndDate().getDayOfMonth();

        adjustment = getAdjustment(startDay, endDay, adjustment);

        double totalPrice = pricePerNight * (1 + adjustment) * numberOfPeople * (endDay - startDay + 1);
        return (float) totalPrice;
    }

    private double getAdjustment(int startDay, int endDay, double adjustment) {
        if (validateDate(startDay, endDay, 10, 5)) adjustment = 0.08;
        if (validateDate(startDay, endDay, 15, 10)) adjustment = 0.10;
        if (validateDate(startDay, endDay, 31, 26)) adjustment = 0.15;
        return adjustment;
    }

    public Boolean validateDate(Integer startDate, Integer endDate, Integer min, Integer max) {
        return startDate <= min && endDate >= max;
    }
    

    public LocalDate formatDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        while (true) {
            String inputDate = scanner.nextLine();
            try {
                return LocalDate.parse(inputDate, formatter);
            } catch (DateTimeParseException e) {
                System.out.println("Error: la fecha no tiene el formato correcto. Inténtelo nuevamente.");
            }
        }
    }
}
