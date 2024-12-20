package com.example.services;

import com.example.services.interfaces.IValidatorService;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.function.Function;

public class InputService {
    private final Scanner scanner;
    private IValidatorService validatorService;

    public InputService(Scanner scanner, IValidatorService validatorService) {
        this.scanner = scanner;
        this.validatorService = validatorService;
    }

    public LocalDate promptDate(String message) {
        return prompt(message, input -> LocalDate.parse(input, DateTimeFormatter.ofPattern("dd/MM/yyyy")));
    }

    public LocalTime promptTime(String message) {
        return prompt(message, input -> LocalTime.parse(input, DateTimeFormatter.ofPattern("HH:mm")));
    }

    public int promptInt(String message) {
        return prompt(message, Integer::parseInt);
    }

    public String promptString(String message) {
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
