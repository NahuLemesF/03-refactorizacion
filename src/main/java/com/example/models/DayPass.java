package com.example.models;

import com.example.constants.AccommodationType;

import java.util.List;

public class DayPass extends Accommodation {
    private Float personPrice;

    public DayPass(String name, Float rate, String city, String description, List<Service> services, Float personPrice, AccommodationType type) {
        super(name, rate, city, description, services, type);
        this.personPrice = personPrice;
    }

    @Override
    public String toString() {
        return String.format(
                "Nombre: %s | Precio base: %.2f | Ciudad: %s | Descripción: %s",
                getName(), getPersonPrice(), getCity(), getDescription()
        );
    }

    public Float getPersonPrice() {
        return personPrice;
    }
}