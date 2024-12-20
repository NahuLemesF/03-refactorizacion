package com.example.services;

import com.example.data.Database;
import com.example.models.*;
import com.example.services.interfaces.IBookingService;
import com.example.services.interfaces.IMenuService;

import java.util.List;
import java.util.Scanner;

public class BookingService implements IBookingService {
    private final IMenuService menuService;
    private final StayService stayService;
    private final DayPassService dayPassService;
    private static final int EXIT_OPTION = 5;
    private static final int BOOK_STAY_OPTION = 1;
    private static final int BOOK_DAYPASS_OPTION = 2;

    public BookingService(Database database, IMenuService menuService, StayService stayService, DayPassService dayPassService) {
        this.menuService = menuService;
        this.stayService = stayService;
        this.dayPassService = dayPassService;
    }

    @Override
    public void start() {
        Integer option = menuService.showMenu();

        while (option != EXIT_OPTION) {
            switch (option) {
                case BOOK_STAY_OPTION -> stayService.createStay();
                case BOOK_DAYPASS_OPTION -> dayPassService.createDayPass();
                default -> System.out.println("Opción inválida. Por favor, intente nuevamente.");
            }
            option = menuService.showMenu();
        }

        System.out.println("Gracias por usar nuestro sistema de reservas.");
    }
}