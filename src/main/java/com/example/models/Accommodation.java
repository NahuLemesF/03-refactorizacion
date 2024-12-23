package com.example.models;

import com.example.constants.AccommodationType;

import java.util.List;

public abstract class Accommodation {
    private String name;
    private Float rate;
    private String city;
    private String description;
    private AccommodationType type;
    private List<Service> services;

    public Accommodation(String name, Float rate, String city, String description, List<Service> services, AccommodationType type) {
        this.city = city;
        this.description = description;
        this.name = name;
        this.rate = rate;
        this.services = services;
        this.type = type;
    }

    @Override
    public String toString() {
        return String.format(
                "Nombre: %s \nCalificación: %.1f \nCiudad: %s \nTipo: %s \nDescripción: %s",
                name, rate, city, type, description
        );
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public String getDescription() {
        return description;
    }

    public AccommodationType getType() {
        return type;
    }

    public List<Service> getServices() {
        return services;
    }
}
