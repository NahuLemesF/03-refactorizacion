package com.example.services;

import com.example.models.Booking;
import com.example.models.Client;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class BookingDeleter {
    private final Scanner scanner;
    private final BookingCreator bookingCreator;

    public BookingDeleter(Scanner scanner,  BookingCreator bookingCreator) {
        this.scanner = scanner;
        this.bookingCreator = new BookingCreator(scanner);
    }

    public void cancelStay(List<Booking> bookings) {
        System.out.println("Ingrese su correo electrónico:");
        String email = scanner.nextLine();

        System.out.println("Ingrese su fecha de nacimiento (DD/MM/YYYY):");
        LocalDate birthDate = bookingCreator.formatDate();

        Booking bookingToCancel = null;

        // Buscar la reserva en la lista de reservas
        for (Booking booking : bookings) {
            Client client = booking.getClient();
            if (client.getEmail().equalsIgnoreCase(email) && client.getBirthDate().equals(birthDate)) {
                bookingToCancel = booking;
                break;
            }
        }

        if (bookingToCancel != null) {
            bookings.remove(bookingToCancel);
            System.out.println("Reserva cancelada exitosamente.");
        } else {
            System.out.println("Reserva no encontrada. Por favor, revise los datos ingresados.");
        }
    }

}
