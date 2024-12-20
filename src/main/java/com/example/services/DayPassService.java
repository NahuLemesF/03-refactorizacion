package com.example.services;

import com.example.data.Database;
import com.example.models.DayPass;
import com.example.models.Room;
import com.example.models.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;

public class DayPassService {
    private final Scanner scanner;

    public DayPassService(Scanner scanner) {
        this.scanner = scanner;
    }


    public void createDayPass() {
        String cityName = selectCity();
        DayPass listDayPassByCity = filterDayPassByCity(cityName);
        Service selectedService = selectService(listDayPassByCity);
        BookingCreator bookingCreator = new BookingCreator(scanner);
        bookingCreator.createBooking(listDayPassByCity, selectedService);
    }

    public String selectCity() {
        System.out.println("Ciudades disponibles:");
        ArrayList<String> cities = new ArrayList<>();
        for (DayPass dayPass : Database.getDaypass()) {
            if (!cities.contains(dayPass.getCity())) {
                cities.add(dayPass.getCity());
            }
        }
        int index = selectOptionFromList(cities, scanner, "Seleccione una ciudad:", Function.identity());
        return cities.get(index);
    }

    public DayPass filterDayPassByCity(String city) {
        System.out.println("Alojamientos disponibles en " + city + ":");
        ArrayList<DayPass> filteredDayPass = new ArrayList<>();
        for (DayPass dayPass : Database.getDaypass()) {
            if (dayPass.getCity().equals(city)) {
                filteredDayPass.add(dayPass);
            }
        }
        int index = selectOptionFromList(filteredDayPass, scanner, "Seleccione un tipo de Alojamiento:", DayPass::getName);
        return filteredDayPass.get(index);
    }

    public Service selectService(DayPass selectedDayPass) {
        ArrayList<Service> listServices = new ArrayList<>();
        for (Service service : selectedDayPass.getServices()) {
            if (service instanceof Service) {
                listServices.add((Service) service);
            }
        }
        int index = selectOptionFromList(listServices, scanner, "Seleccione un servicio:", Service::getName);
        return listServices.get(index);
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
