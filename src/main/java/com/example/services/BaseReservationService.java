package com.example.services;

import com.example.data.Database;
import com.example.models.Stay;
import com.example.services.interfaces.IValidatorService;

import java.util.List;

public abstract class BaseReservationService {
    protected final IValidatorService validatorService;

    public BaseReservationService(IValidatorService validatorService) {
        this.validatorService = validatorService;
    }

    protected String selectCity() {
        System.out.println("Ciudades disponibles:");
        List<String> cities = Database.getStays().stream().map(Stay::getCity).distinct().toList();
        for (Integer i = 0; i < cities.size(); i++) {
            System.out.println((i + 1) + ". " + cities.get(i));
        }
        Integer cityIndex = validatorService.readInt("Seleccione una ciudad:");
        return cities.get(cityIndex - 1);
    }

    protected Integer readOption(Integer maxOption) {
        return validatorService.readInt(String.format("Seleccione una opción válida (1 - %d):", maxOption));
    }
}