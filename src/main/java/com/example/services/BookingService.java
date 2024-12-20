package com.example.services;

import com.example.data.Database;
import com.example.services.interfaces.IBookingService;
import com.example.services.interfaces.IMenuService;

public class BookingService implements IBookingService {
    private final IMenuService menuService;
    private StayService stayService;
    private DayPassService dayPassService;
    private BookingDeleterService bookingDeleterService;
    private static final int BOOK_STAY_OPTION = 1;
    private static final int BOOK_DAYPASS_OPTION = 2;
    private static final int UPDATE_BOOKING_OPTION = 3;
    private static final int CANCEL_BOOKING_OPTION = 4;
    private static final int EXIT_OPTION = 5;

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
                case UPDATE_BOOKING_OPTION -> System.out.println("Actualizar una reserva");
                case CANCEL_BOOKING_OPTION -> bookingDeleterService.cancelStay();
                default -> System.out.println("Opción inválida. Por favor, intente nuevamente.");
            }
            option = menuService.showMenu();
        }

        System.out.println("Gracias por usar nuestro sistema de reservas.");
    }
}