package com.example.services;

import com.example.data.Database;
import com.example.models.*;
import com.example.services.interfaces.IValidatorService;

import java.util.*;

public class StayService {
    private final IValidatorService validatorService;
    private final Scanner scanner = new Scanner(System.in);

    public StayService(Scanner scanner,IValidatorService validatorService) {
        this.validatorService = validatorService;
    }

    public void createStay() {
        String cityName = selectCity();
        List<Stay> stays = filterStayByCity(cityName);
        String typeOfStay = selectType(stays);
        Stay selectedStay = filterStayByType(typeOfStay, stays);
        Room selectedRoom = selectRoom(selectedStay);
        BookingCreatorService bookingCreatorService = new BookingCreatorService(scanner);
        bookingCreatorService.createBooking(selectedStay, selectedRoom);
    }

    private String selectCity() {
        System.out.println("Ciudades disponibles:");
        List<String> cities = Database.getStays().stream()
                .map(Stay::getCity)
                .distinct()
                .toList();
        return validatorService.readString("Seleccione una ciudad:");
    }

    private List<Stay> filterStayByCity(String city) {
        return Database.getStays().stream()
                .filter(stay -> stay.getCity().equalsIgnoreCase(city))
                .toList();
    }

    private String selectType(List<Stay> stays) {
        Set<AccommodationType> uniqueTypes = new LinkedHashSet<>();
        for (Stay stay : stays) {
            uniqueTypes.add(stay.getType());
        }
        return validatorService.readString("Seleccione un tipo de Alojamiento:");
    }

    private Stay filterStayByType(String type, List<Stay> stays) {
        return stays.stream()
                .filter(stay -> stay.getType().name().equals(type))
                .findFirst()
                .orElse(null);
    }

    private Room selectRoom(Stay selectedStay) {
        return selectedStay.getServices().stream()
                .filter(service -> service instanceof Room)
                .map(service -> (Room) service)
                .findFirst()
                .orElse(null);
    }
}

