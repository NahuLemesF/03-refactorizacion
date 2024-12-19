package com.example.services;

import com.example.data.Database;
import com.example.services.interfaces.IBookingService;
import com.example.services.interfaces.IMenuService;

import java.util.Scanner;

public class BookingService implements IBookingService {
    private final Database database;
    private final IMenuService menuService;

    public BookingService(Database database, IMenuService menuService, BookingCreation bookingCreation) {
        this.database = database;
        this.menuService = menuService;
    }

    @Override
    public void start() {
        Integer option = menuService.showMenu();

        while (option != 4) {
            switch (option) {
                case 1 -> ;
                case 2 -> updateBooking();
                case 3: cancelBooking();
                    break;
            }
            option = menuService.showMenu();
        }
    }
}