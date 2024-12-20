package com.example.services;

import com.example.data.Database;
import com.example.models.Room;
import com.example.models.Stay;
import com.example.services.interfaces.IValidatorService;

import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StayService extends BaseReservationService {

    public StayService(Scanner scanner, IValidatorService validatorService) {
        super(scanner, validatorService);
    }

    public void createStay() {
        String cityName = selectCity(Database.getStays());
        List<Stay> stays = filterStayByCity(cityName);
        String typeOfStay = selectType(stays);
        Stay selectedStay = filterStayByType(typeOfStay, stays);
        Room selectedRoom = selectRoom(selectedStay);

        createBooking(selectedStay, selectedRoom);
    }

    private List<Stay> filterStayByCity(String city) {
        return Database.getStays().stream()
                .filter(stay -> stay.getCity().equalsIgnoreCase(city))
                .toList();
    }

    private String selectType(List<Stay> stays) {
        Set<String> uniqueTypes = stays.stream()
                .map(stay -> stay.getType().name())
                .collect(Collectors.toSet());
        printOptions("Tipos de alojamiento disponibles:", List.copyOf(uniqueTypes), Function.identity());
        return validatorService.readString("Seleccione un tipo de Alojamiento:");
    }

    private Stay filterStayByType(String type, List<Stay> stays) {
        return stays.stream()
                .filter(stay -> stay.getType().name().equalsIgnoreCase(type))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No se encontró un alojamiento válido."));
    }

    private Room selectRoom(Stay selectedStay) {
        List<Room> rooms = selectedStay.getServices().stream()
                .filter(service -> service instanceof Room)
                .map(service -> (Room) service)
                .toList();
        printOptions("Habitaciones disponibles:", rooms, room -> String.format(
                "Tipo: %s\nPrecio: %.2f",
                room.getType(), room.getPrice()));
        Integer roomIndex = readOption(rooms.size());
        return rooms.get(roomIndex - 1);
    }

    private void createBooking(Stay stay, Room room) {
        InputService inputService = new InputService(scanner, validatorService);
        BookingCreatorService bookingCreatorService = new BookingCreatorService(
                inputService,
                new ClientService(inputService),
                new SummaryPrinter(),
                new PriceCalculator()
        );
        bookingCreatorService.createBooking(stay, room);
    }
}
