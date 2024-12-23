package com.example.config;

import com.example.repositories.AccommodationRepository;
import com.example.services.booking.BookingService;
import com.example.services.accommodation.DayPassService;
import com.example.services.MenuService;
import com.example.services.accommodation.StayService;
import com.example.services.accommodation.SearchAccommodationService;
import com.example.services.interfaces.IValidatorService;
import com.example.utils.MainMenu;
import com.example.utils.SearchMenu;
import com.example.utils.Validator;
import com.example.utils.interfaces.IMainMenu;

import java.util.Scanner;

public class ServiceFactory {
    public static MenuService createBookingService() {
        Scanner scanner = new Scanner(System.in);
        IValidatorService validatorService = new Validator(scanner);

        SearchAccommodationService searchAccommodationService = new SearchAccommodationService(AccommodationRepository.getInstance());
        SearchMenu searchMenu = new SearchMenu(searchAccommodationService, validatorService);

        IMainMenu menuService = new MainMenu(validatorService);
        StayService stayService = new StayService(validatorService, searchAccommodationService);
        DayPassService dayPassService = new DayPassService(validatorService);
        BookingService bookingService = new BookingService(scanner);

        return new MenuService(menuService, stayService, dayPassService, searchMenu, bookingService);
    }
}
