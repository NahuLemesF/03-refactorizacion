package com.example.config;

import com.example.data.Database;
import com.example.services.*;
import com.example.services.interfaces.IMenuService;
import com.example.services.interfaces.IValidatorService;

import java.util.Scanner;

public class ServiceFactory {
    public static BookingService createBookingService() {
        Database database = Database.getInstance();
        Scanner scanner = new Scanner(System.in);

        IValidatorService validatorService = new ValidatorService(scanner);
        IMenuService menuService = new MenuService(validatorService);
        StayService stayService = new StayService(scanner, validatorService);
        DayPassService dayPassService = new DayPassService(scanner, validatorService);
        BookingDeleterService bookingDeleterService = new BookingDeleterService(scanner, validatorService);

        return new BookingService(menuService, stayService, dayPassService, bookingDeleterService);
    }
}
