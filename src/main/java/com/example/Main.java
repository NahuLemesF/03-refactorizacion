package com.example;

import com.example.config.ServiceFactory;
import com.example.services.*;

public class Main {
    public static void main(String[] args) {

        BookingService bookingService = ServiceFactory.createBookingService();
        bookingService.start();
    }

}
