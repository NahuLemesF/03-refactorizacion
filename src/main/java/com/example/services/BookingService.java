package com.example.services;

import com.example.services.interfaces.IBookingService;
import com.example.services.interfaces.IMenuService;

import java.util.Map;
import java.util.function.Consumer;

public class BookingService implements IBookingService {
    private final IMenuService menuService;
    private final Map<Integer, Consumer<Void>> actionMap;
    private static final Integer EXIT_OPTION = 5;

    public BookingService(IMenuService menuService, StayService stayService, DayPassService dayPassService, BookingDeleterService bookingDeleterService) {
        this.menuService = menuService;
        this.actionMap = Map.of(
                1, unused -> stayService.createStay(),
                2, unused -> dayPassService.createDayPass(),
                3, unused -> System.out.println("Actualizar una reserva"),
                4, unused -> bookingDeleterService.cancelBooking()
        );
    }

    @Override
    public void start() {
        Integer option = menuService.showMenu();

        while (option != EXIT_OPTION) {
            actionMap.getOrDefault(option, unused -> System.out.println("Opción inválida. Por favor, intente nuevamente."))
                    .accept(null);
            option = menuService.showMenu();
        }

        System.out.println("Gracias por usar nuestro sistema de reservas.");
    }
}
