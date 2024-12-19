package com.example.services;

import com.example.data.Database;
import com.example.models.DayPass;
import com.example.models.Stay;

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
        ArrayList<DayPass> listDayPassByCity = filterDayPassByCity(cityName);
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

    public ArrayList<DayPass> filterDayPassByCity(String city) {
        ArrayList<DayPass> filteredDayPass = new ArrayList<>();
        for (DayPass dayPass : Database.getDaypass()) {
            if (dayPass.getCity().equals(city)) {
                filteredDayPass.add(dayPass);
            }
        }
        int index = selectOptionFromList(filteredDayPass, scanner, "Seleccione un tipo de Alojamiento:", DayPass::getName);
        return filteredDayPass;
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
