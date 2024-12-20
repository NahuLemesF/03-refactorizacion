package com.example;

import com.example.data.Database;
import com.example.services.*;
import com.example.services.interfaces.IMenuService;
import com.example.services.interfaces.IValidatorService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Database database = Database.getInstance();
        Scanner scanner = new Scanner(System.in);
        IValidatorService validatorService = new ValidatorService(scanner);
        IMenuService menuService = new MenuService(validatorService);
        BookingService bookingService = new BookingService(database, menuService, new StayService(scanner), new DayPassService(scanner), new BookingDeleterService(scanner));
        bookingService.start();
    }
}