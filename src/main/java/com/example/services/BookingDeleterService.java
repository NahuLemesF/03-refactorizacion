package com.example.services;

import com.example.data.Database;
import com.example.models.Booking;
import com.example.models.Client;
import com.example.services.interfaces.IValidatorService;

import java.time.LocalDate;
import java.util.Scanner;

public class BookingDeleterService {
    private IValidatorService validatorService;

    public BookingDeleterService(Scanner scanner, IValidatorService validatorService) {
        this.validatorService = validatorService;
    }

    public void cancelBooking() {
        String email = validatorService.readString("Ingrese su correo electrónico:");
        LocalDate birthDate = validatorService.readLocalDate("Ingrese su fecha de nacimiento (yyyy-MM-dd):");

        Booking bookingToCancel = Database.getBookings().stream()
                .filter(booking -> bookingMatchesClient(booking, email, birthDate))
                .findFirst()
                .orElse(null);

        checkBooking(bookingToCancel);
    }

    public void checkBooking(Booking bookingToCancel) {
        if (bookingToCancel == null) {
            System.out.println("Reserva no encontrada. Por favor, revise los datos ingresados.");
            return;
        }
        Database.getBookings().remove(bookingToCancel);
        System.out.println("Reserva cancelada exitosamente.");
    }


    private Boolean bookingMatchesClient(Booking booking, String email, LocalDate birthDate) {
        Client client = booking.getClient();
        return client.getEmail().equalsIgnoreCase(email) && client.getBirthDate().equals(birthDate);
    }
}