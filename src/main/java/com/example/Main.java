package com.example;

import com.example.config.ServiceFactory;
import com.example.services.MenuService;

public class Main {
    public static void main(String[] args) {
        MenuService menuService = ServiceFactory.createBookingService();
        menuService.start();
    }

}
