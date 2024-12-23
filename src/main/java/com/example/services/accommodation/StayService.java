package com.example.services.accommodation;

import com.example.constants.AccommodationType;
import com.example.models.Room;
import com.example.models.Stay;
import com.example.services.booking.BookingService;
import com.example.services.interfaces.IValidatorService;

import java.util.ArrayList;
import java.util.List;

public class StayService extends BaseReservationService {
    private final SearchAccommodationService searchService;
    public static List<Stay> listStaysFiltered = new ArrayList<>();

    public StayService(IValidatorService validatorService, SearchAccommodationService searchService) {
        super(validatorService);
        this.searchService = searchService;
    }

    public void createStay(String city, AccommodationType type, BookingService bookingService) {
        listStaysFiltered = getFilteredStays(city, type);

        if (listStaysFiltered.isEmpty()) {
            System.out.println("No hay estadías disponibles para el tipo seleccionado en esta ciudad.");
            return;
        }
        Stay selectedStay = selectStay(listStaysFiltered);
        Room selectedRoom = getRoomForStay(selectedStay);

        if (selectedRoom == null) return;

        bookingService.createBooking(selectedStay, selectedRoom);
    }

    private Room getRoomForStay(Stay selectedStay) {
        List<Room> rooms = getRoomsFromStay(selectedStay);

        if (rooms.isEmpty()) {
            System.out.println("No hay habitaciones disponibles para la estadía seleccionada.");
            return null;
        }
        return selectRoom(rooms);
    }

    private List<Stay> getFilteredStays(String city, AccommodationType type) {
        return searchService.getStaysByCity(city).stream()
                .filter(stay -> stay.getType().equals(type))
                .toList();
    }

    private Stay selectStay(List<Stay> stays) {
        return selectFromList("Seleccione una estadía:", stays, "Seleccione una estadía:");
    }

    private List<Room> getRoomsFromStay(Stay stay) {
        return stay.getServices().stream()
                .filter(service -> service instanceof Room)
                .map(service -> (Room) service)
                .toList();
    }

    private Room selectRoom(List<Room> rooms) {
        return selectFromList("Seleccione una habitación:", rooms, "Seleccione una habitación:");
    }

    public static List<Stay> getListStaysFiltered() {
        return listStaysFiltered;
    }

    public static void setListStaysFiltered(List<Stay> listStaysFiltered) {
        StayService.listStaysFiltered = listStaysFiltered;
    }

    public SearchAccommodationService getSearchService() {
        return searchService;
    }
}
