package com.example.services;

import com.example.models.Client;

import java.time.LocalDate;
import java.time.LocalTime;

public class ClientService {
    private final InputService inputService;

    public ClientService(InputService inputService) {
        this.inputService = inputService;
    }

    public Client createClient() {
        String firstName = inputService.promptString("Ingrese su nombre:");
        String lastName = inputService.promptString("Ingrese su apellido:");
        LocalDate birthDate = inputService.promptDate("Ingrese su fecha de nacimiento (DD/MM/YYYY):");
        String phone = inputService.promptString("Ingrese su número de teléfono:");
        String nationality = inputService.promptString("Ingrese su nacionalidad:");
        LocalTime arrivalTime = inputService.promptTime("Ingrese su hora de llegada (HH:MM):");
        String email = inputService.promptString("Ingrese su correo electrónico:");

        return new Client(firstName, lastName, birthDate, phone, nationality, arrivalTime, email);
    }
}
