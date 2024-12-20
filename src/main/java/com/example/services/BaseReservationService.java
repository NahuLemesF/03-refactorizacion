package com.example.services;

import com.example.models.Accommodation;
import com.example.services.interfaces.IValidatorService;

import java.util.List;
import java.util.Scanner;
import java.util.function.Function;

public class BaseReservationService {
    protected final Scanner scanner;
    protected final IValidatorService validatorService;

    public BaseReservationService(Scanner scanner, IValidatorService validatorService) {
        this.scanner = scanner;
        this.validatorService = validatorService;
    }

    protected String selectCity(List<? extends Accommodation> accommodations) {
        System.out.println("Ciudades disponibles:");
        List<String> cities = accommodations.stream()
                .map(Accommodation::getCity)
                .distinct()
                .toList();
        printOptions("Seleccione una ciudad:", cities, Function.identity());
        Integer cityIndex = readOption(cities.size());
        return cities.get(cityIndex - 1);
    }

    protected Integer readOption(Integer maxOption) {
        return validatorService.readInt(String.format("Seleccione una opción válida (1 - %d):", maxOption));
    }

    protected <T> void printOptions(String header, List<T> items, Function<T, String> formatter) {
        System.out.println(header);
        for (Integer i = 0; i < items.size(); i++) {
            System.out.printf("%d. %s%n", i + 1, formatter.apply(items.get(i)));
        }
    }
}
