package com.example.services;

import com.example.data.Database;
import com.example.services.interfaces.IBookingService;
import com.example.services.interfaces.IMenuService;

import java.util.Scanner;

public class BookingService implements IBookingService {
    private final Database database;
    private final IMenuService menuService;

    public BookingService(Database database, IMenuService menuService) {
        this.database = database;
        this.menuService = menuService;
    }

    @Override
    public void start() {
        Integer option = menuService.showMenu();

        while (option != 5) {
            switch (option) {
                case 1:
                    // TODO: Ver listado de alojamientos
                    break;
                case 2:
                    // TODO: Reservar alojamiento
                    break;
                case 3:
                    // TODO: Ver reservas
                    break;
                case 4:
                    // TODO: Ver listado de servicios
                    break;
            }
            option = menuService.showMenu();
        }
    }
}