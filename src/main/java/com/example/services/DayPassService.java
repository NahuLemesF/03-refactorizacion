package com.example.services;

import com.example.data.Database;
import com.example.models.Accommodation;
import com.example.models.DayPass;
import com.example.models.Room;

import java.util.List;
import java.util.Scanner;

class DayPassService extends BaseReservationService {
    public DayPassService(Scanner scanner) {
        super(scanner);
    }

    public void createDayPass() {
        String cityName = selectCity();
        List<DayPass> dayPassesByCity = filterDayPassesByCity(cityName);
        DayPass selectedDayPass = selectDayPass(dayPassesByCity);
        Room selectedRoom = selectRoom(selectedDayPass);

        BookingCreator bookingCreator = new BookingCreator(scanner);
        bookingCreator.createBooking(selectedDayPass, selectedRoom);
    }

    private List<DayPass> filterDayPassesByCity(String city) {
        Database.getInstance();
        return Database.getDaypass().stream()
                .filter(dayPass -> dayPass.getCity().equalsIgnoreCase(city))
                .toList();
    }

    private DayPass selectDayPass(List<DayPass> dayPasses) {
        System.out.println("Días de Sol disponibles:");
        for (int i = 0; i < dayPasses.size(); i++) {
            System.out.println((i + 1) + ". " + dayPasses.get(i).getName());
        }
        int dayPassIndex = readOption(dayPasses.size());
        return dayPasses.get(dayPassIndex - 1);
    }

    private Room selectRoom(Accommodation accommodation) {
        System.out.println("Habitaciones disponibles:");
        List<Room> rooms = accommodation.getRooms();
        for (int i = 0; i < rooms.size(); i++) {
            System.out.println((i + 1) + ". " + rooms.get(i).getType());
        }
        int roomIndex = readOption(rooms.size());
        return rooms.get(roomIndex - 1);
    }
}