package com.example.models;

import java.util.List;

public class Accommodation {
    private String name;
    private Float rate;
    private String city;
    private String description;
    private List<Service> services;

    public Accommodation(String name, Float rate, String city, String description, List<Service> services) {
        this.name = name;
        this.rate = rate;
        this.city = city;
        this.description = description;
        this.services = services;
    }


    public String getName() {
        return name;
    }

    public Float getRate() {
        return rate;
    }

    public String getCity() {
        return city;
    }

    public String getDescription() {
        return description;
    }

    public List<Service> getServices() {
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }
}