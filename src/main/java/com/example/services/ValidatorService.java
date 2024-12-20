package com.example.services;

import com.example.services.interfaces.IValidatorService;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class ValidatorService implements IValidatorService {
    private final Scanner scanner;

    public ValidatorService(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public String readString(String prompt) {
        System.out.println(prompt);
        return scanner.nextLine();
    }

    @Override
    public Integer readInt(String prompt) {
        int input;
        while (true) {
            try {
                System.out.println(prompt);
                input = Integer.parseInt(scanner.nextLine());
                return input;
            } catch (NumberFormatException e) {
                System.err.println("Entrada inválida. Por favor ingrese un número entero.");
            }
        }
    }

    @Override
    public LocalDate readLocalDate(String prompt) {
        LocalDate date;
        while (true) {
            try {
                System.out.println(prompt);
                date = LocalDate.parse(scanner.nextLine());
                return date;
            } catch (Exception e) {
                System.err.println("Fecha inválida. El formato debe ser: yyyy-MM-dd");
            }
        }
    }

}