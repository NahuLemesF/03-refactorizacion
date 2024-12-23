package com.example.utils;

import com.example.services.interfaces.IValidatorService;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class Validator implements IValidatorService {
    private final Scanner scanner;

    public Validator(Scanner scanner) {
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
    public Float readFloat(String prompt) {
        float input;
        while (true) {
            try {
                System.out.println(prompt);
                input = Float.parseFloat(scanner.nextLine());
                return input;
            } catch (NumberFormatException e) {
                System.err.println("Entrada inválida. Por favor ingrese un número decimal.");
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

    @Override
    public LocalTime readLocalTime(String prompt) {
        LocalTime time;
        while (true) {
            try {
                System.out.println(prompt);
                time = LocalTime.parse(scanner.nextLine());
                return time;
            } catch (Exception e) {
                System.err.println("Hora inválida. El formato debe ser: HH:mm");
            }
        }
    }

    @Override
    public void clearBuffer() {
        if (scanner.hasNextLine()) {
            scanner.nextLine();
        }
    }
}