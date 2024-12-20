package com.example.services;

import com.example.models.Booking;
import com.example.models.Client;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

public class BookingDeleterService {
    private final Scanner scanner;

    public BookingDeleterService(Scanner scanner) {
        this.scanner = scanner;
    }

    public void cancelStay(List<Booking> bookings) {
        String email = promptEmail();
        LocalDate birthDate = promptBirthDate();

        Booking bookingToCancel = bookings.stream()
                .filter(booking -> bookingMatchesClient(booking, email, birthDate))
                .findFirst()
                .orElse(null);

        if (bookingToCancel != null) {
            bookings.remove(bookingToCancel);
            System.out.println("Reserva cancelada exitosamente.");
        } else {
            System.out.println("Reserva no encontrada. Por favor, revise los datos ingresados.");
        }
    }

    private boolean bookingMatchesClient(Booking booking, String email, LocalDate birthDate) {
        Client client = booking.getClient();
        return client.getEmail().equalsIgnoreCase(email) && client.getBirthDate().equals(birthDate);
    }

    private String promptEmail() {
        System.out.println("Ingrese su correo electrónico:");
        return scanner.nextLine().trim();
    }

    private LocalDate promptBirthDate() {
        System.out.println("Ingrese su fecha de nacimiento (DD/MM/YYYY):");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        while (true) {
            try {
                return LocalDate.parse(scanner.nextLine().trim(), formatter);
            } catch (DateTimeParseException e) {
                System.out.println("Error: La fecha ingresada no tiene el formato correcto. Inténtelo nuevamente.");
            }
        }
    }
}
