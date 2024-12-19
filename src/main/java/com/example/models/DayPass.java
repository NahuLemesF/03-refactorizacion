package com.example.models;

import java.util.List;

public class DayPass extends Accommodation {
    private Float personPrice;

    public DayPass(
        String name,
        Float rate,
        String city,
        String description,
        List<Service> services,
        Float personPrice
    ) {
        super(name, rate, city, description, services);
        this.personPrice = personPrice;
    }

    public Float getPersonPrice() {
        return personPrice;
    }

    public void setPersonPrice(Float personPrice) {
        this.personPrice = personPrice;
    }
}
