package com.example.models;

import java.util.List;

public class Stay extends Accommodation {
    private Float basePrice;
    private AccommodationType type;

    public Stay(
        String name,
        Float rate,
        String city,
        String description,
        List<Service> services,
        Float basePrice,
        AccommodationType type
    ) {
        super(name, rate, city, description, services);
        this.basePrice = basePrice;
        this.type = type;
    }

    public Float getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(Float basePrice) {
        this.basePrice = basePrice;
    }

    public AccommodationType getType() {
        return type;
    }

    public void setType(AccommodationType type) {
        this.type = type;
    }
}
