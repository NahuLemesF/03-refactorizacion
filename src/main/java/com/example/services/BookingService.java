package com.example.services;

import com.example.data.Database;
import com.example.services.interfaces.IBookingService;
import com.example.services.interfaces.IMenuService;

import java.util.Scanner;

public class BookingService implements IBookingService {
    private final IMenuService menuService;
    private final StayService stayService = new StayService(new Scanner(System.in));
    private final DayPassService dayPassService = new DayPassService(new Scanner(System.in));

    public BookingService(Database database, IMenuService menuService) {
        this.menuService = menuService;
    }

    @Override
    public void start() {
        Integer option = menuService.showMenu();

        while (option != 5) {
            switch (option) {
                case 1 -> stayService.createStay();
                case 2 -> dayPassService.createDayPass();
//                case 3: bookingDeleter.cancelStay( database.);
//                    break;
            }
            option = menuService.showMenu();
        }
    }
}