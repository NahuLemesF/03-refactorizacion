package com.example.services;

import com.example.constants.AccommodationType;
import com.example.models.Room;
import com.example.models.Stay;
import com.example.repositories.BookingRepository;
import com.example.services.accommodation.DayPassService;
import com.example.services.accommodation.StayService;
import com.example.services.booking.BookingService;
import com.example.utils.SearchMenu;
import com.example.utils.interfaces.IMainMenu;

import java.util.Map;
import java.util.Scanner;
import java.util.function.Consumer;

public class MenuService {
    private final IMainMenu menuService;
    private final Map<Integer, Consumer<Void>> actionMap;
    private static final Integer EXIT_OPTION = 4;
    private final Consumer<Void> handleCreateReservation;
    private BookingRepository bookingRepository;
    private final Scanner scanner = new Scanner(System.in);

    public MenuService(IMainMenu menuService, StayService stayService, DayPassService dayPassService, SearchMenu searchMenu, BookingService bookingService) {
        this.menuService = menuService;
        this.handleCreateReservation = unused -> handleCreateReservation(searchMenu, stayService, dayPassService, bookingService);
        this.actionMap = Map.of(
                1, handleCreateReservation,
                2, unused -> handleUpdateReservation(),
                3, unused -> handleCancelReservation()
        );
        this.bookingRepository = BookingRepository.getInstance();
    }

    public void start() {
        Integer option = menuService.showMenu();

        while (option != EXIT_OPTION) {
            actionMap.getOrDefault(option, unused -> System.out.println("Opción inválida. Por favor, intente nuevamente."))
                    .accept(null);
            option = menuService.showMenu();
        }
        System.out.println("Gracias por usar nuestro sistema de reservas.");
    }

    private void handleCreateReservation(SearchMenu searchMenu, StayService stayService, DayPassService dayPassService, BookingService bookingService) {
        String city = searchMenu.selectCity();
        AccommodationType type = searchMenu.selectAccommodationType();

        if (type == AccommodationType.DAY_PASS) {
            dayPassService.createDayPass(city, bookingService);
            return;
        }
        stayService.createStay(city, type, bookingService);
    }


    private void handleUpdateReservation() {
        Map<Integer, Consumer<Void>> actions;

        System.out.println("¿Qué desea actualizar?"
                + "\n1. Alojamiento"
                + "\n2. Habitaciones");

        actions = Map.of(
                1, handleCreateReservation,
                2, unused -> handleUpdateRooms()
        );

        Integer option = scanner.nextInt();
        actions.get(option).accept(null);
    }

    private void handleUpdateRooms() {
        if (bookingRepository.getBooking().getAccommodation() instanceof Stay stay) {
            updateRooms(stay);
        }
    }

    private void updateRooms(Stay stay) {
        if (stay.getType() == AccommodationType.HOTEL) {
            bookingRepository.getBooking().getAccommodation().getServices().stream().map(service -> (Room) service).forEach(System.out::println);
        }
    }

    private void handleCancelReservation() {
        if (bookingRepository.getBooking() != null) {
            bookingRepository.removeBooking();
            System.out.println("Reserva cancelada con éxito.");
            return;
        }
        System.out.println("No hay ninguna reserva activa.");
    }
}

