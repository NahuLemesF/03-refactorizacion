package com.example.utils;

import com.example.constants.AccommodationType;
import com.example.models.Room;
import com.example.models.Stay;
import com.example.services.accommodation.SearchAccommodationService;
import com.example.services.interfaces.IValidatorService;

import java.util.List;

public class SearchMenu {
    private final SearchAccommodationService searchService;
    private final IValidatorService validatorService;

    public SearchMenu(SearchAccommodationService searchService, IValidatorService validatorService) {
        this.searchService = searchService;
        this.validatorService = validatorService;
    }

    public String selectCity() {
        List<String> cities = searchService.getCities();
        cities.forEach(city -> System.out.printf("%d. %s%n", cities.indexOf(city) + 1, city));
        int index = validatorService.readInt("Seleccione una ciudad por número:");
        return cities.get(index - 1);
    }

    public AccommodationType selectAccommodationType() {
        AccommodationType[] types = AccommodationType.values();
        for (int i = 0; i < types.length; i++) {
            System.out.printf("%d. %s%n", i + 1, types[i]);
        }
        int index = validatorService.readInt("Seleccione un tipo de alojamiento por número:");
        return types[index - 1];
    }

    public Stay selectStay(List<Stay> stays) {
        stays.forEach(stay -> System.out.printf("%d. %s%n", stays.indexOf(stay) + 1, stay));
        int index = validatorService.readInt("Seleccione un alojamiento por número:");
        return stays.get(index - 1);
    }

    public Room selectRoom(Stay stay) {
        List<Room> rooms = stay.getServices().stream()
                .filter(service -> service instanceof Room)
                .map(service -> (Room) service)
                .toList();
        rooms.forEach(room -> System.out.printf("%d. %s - $%.2f%n", rooms.indexOf(room) + 1, room.getType(), room.getPrice()));
        int index = validatorService.readInt("Seleccione una habitación por número:");
        return rooms.get(index - 1);
    }
}
