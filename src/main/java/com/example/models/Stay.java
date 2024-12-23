package com.example.models;

import com.example.constants.AccommodationType;

import java.util.List;

public class Stay extends Accommodation {
    private Float basePrice;

    public Stay(String name, Float rate, String city, String description, List<Service> services, Float basePrice, AccommodationType type) {
        super(name, rate, city, description, services, type);
        this.basePrice = basePrice;
    }

    @Override
    public String toString() {
        return String.format(
                "Nombre: %s | Precio base: %.2f | Ciudad: %s | Tipo: %s | Descripción: %s",
                getName(), getBasePrice(), getCity(), getType(), getDescription()
        );
    }


    public Float getBasePrice() {
        return basePrice;
    }
}
