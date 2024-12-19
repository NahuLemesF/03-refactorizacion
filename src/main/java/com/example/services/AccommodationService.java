package com.example.services;

import com.example.data.Database;

import java.util.Scanner;

public class AccommodationService {
    private final Database database;
    private final Scanner scanner;

    public AccommodationService(Database database, Scanner scanner) {
        this.database = database;
        this.scanner = scanner;
    }

    public void showAviableAccommodations() {
        System.out.println("Accommodations:");
        database.getAccommodations().forEach(accommodation -> {
            System.out.println(accommodation);
        });
    }
}
