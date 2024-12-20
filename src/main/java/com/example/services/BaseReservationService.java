package com.example.services;

import com.example.data.Database;
import com.example.models.Booking;
import com.example.models.Stay;

import java.util.List;
import java.util.Scanner;

abstract class BaseReservationService {
    protected final Scanner scanner;

    public BaseReservationService(Scanner scanner) {
        this.scanner = scanner;
    }

    protected String selectCity() {
        System.out.println("Ciudades disponibles:");
        List <String> cities = Database.getStays().stream()
                .map(Stay::getCity)
                .distinct()
                .toList();
        for (int i = 0; i < cities.size(); i++) {
            System.out.println((i + 1) + ". " + cities.get(i));
        }
        int cityIndex = readOption(cities.size());
        return cities.get(cityIndex - 1);
    }

    protected int readOption(int maxOption) {
        int option = -1;
        while (option < 1 || option > maxOption) {
            System.out.println("Seleccione una opción válida (1 - " + maxOption + "):");
            if (scanner.hasNextInt()) {
                option = scanner.nextInt();
            }
            scanner.next();
        }
        return option;
}
}