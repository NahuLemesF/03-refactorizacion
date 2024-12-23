package com.example.models;

import java.time.LocalDate;
import java.time.LocalTime;

public class Client {
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private String phoneNumber;
    private String nationality;
    private LocalTime arrivalTime;
    private String email;

    public Client(
        String firstName,
        String lastName,
        LocalDate birthDate,
        String phoneNumber,
        String nationality,
        LocalTime arrivalTime,
        String email
    ) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
        this.nationality = nationality;
        this.arrivalTime = arrivalTime;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Nombre: " + firstName + "\n" +
                "Apellido: " + lastName + "\n" +
                "Fecha de Nacimiento: " + birthDate + "\n" +
                "Telefono: " + phoneNumber + "\n" +
                "Nacionalidad: " + nationality + "\n";
    };

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getNationality() {
        return nationality;
    }

    public LocalTime getArrivalTime() {
        return arrivalTime;
    }

    public String getEmail() {
        return email;
    }
}