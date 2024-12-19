package com.example.services;

import com.example.data.Database;
import com.example.models.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;

public class StayService {
    private final Scanner scanner;

    public StayService(Scanner scanner) {
        this.scanner = scanner;
    }

    public void createStay() {
        String cityName = selectCity();
        ArrayList<Stay> listStayByCity = filterStayByCity(cityName);
        String typeOfStay = selectType(listStayByCity);
        Stay selectedStay = filterStayByType(typeOfStay, listStayByCity);
        Room selectedRoom = selectRoom(selectedStay);
        BookingCreator bookingCreator = new BookingCreator(scanner);
        bookingCreator.createBooking(selectedStay, selectedRoom);
    }

    public String selectCity() {
        System.out.println("Ciudades disponibles:");
        ArrayList<String> cities = new ArrayList<>();
        for (Stay stay : Database.getStays()) {
            if (!cities.contains(stay.getCity())) {
                cities.add(stay.getCity());
            }
        }
        int index = selectOptionFromList(cities, scanner, "Seleccione una ciudad:", Function.identity());
        return cities.get(index);
    }

    public ArrayList<Stay> filterStayByCity(String city) {
        ArrayList<Stay> filteredStays = new ArrayList<>();
        for (Stay stay : Database.getStays()) {
            if (stay.getCity().equals(city)) {
                filteredStays.add(stay);
            }
        }
        return filteredStays;
    }

    public String selectType(ArrayList<Stay> filterStayByCity) {
        ArrayList<String> typeOfStay = new ArrayList<>();
        for (Stay stay : filterStayByCity) {
            if (!typeOfStay.contains(stay.getType().name())) {
                typeOfStay.add(stay.getType().name());
            }
        }
        int index = selectOptionFromList(typeOfStay, scanner, "Seleccione un tipo de Alojamiento:", Function.identity());
        return typeOfStay.get(index);
    }

    public Stay filterStayByType(String type, ArrayList<Stay> listStayFilteredByCity) {
        ArrayList<Stay> filteredStays = new ArrayList<>();
        for (Stay stay : listStayFilteredByCity) {
            if (stay.getType().name().equals(type)) {
                filteredStays.add(stay);
            }
        }
        int index = selectOptionFromList(filteredStays, scanner, "Seleccione un alojamiento:", Stay::getName);
        return filteredStays.get(index);
    }

    public Room selectRoom(Stay selectedStay) {
        ArrayList<Room> listRoom = new ArrayList<>();
        for (Service service : selectedStay.getServices()) {
            if (service instanceof Room) {
                listRoom.add((Room) service);
            }
        }
        int index = selectOptionFromList(listRoom, scanner, "Seleccione una habitación:", Room::getName);
        return listRoom.get(index);
    }

    public static <T> int selectOptionFromList(List<T> options, Scanner scanner, String prompt, Function<T, String> displayFunction) {
        AtomicInteger index = new AtomicInteger(1);
        options.forEach(option -> System.out.println(index.getAndIncrement() + ". " + displayFunction.apply(option)));

        System.out.println(prompt);
        int selectedIndex = scanner.nextInt() - 1;
        scanner.nextLine();
        return selectedIndex;
    }

}

