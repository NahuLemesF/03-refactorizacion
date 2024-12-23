package com.example.models;

public class Service {
    private String name;
    private String description;
    private Float price;

    public Service(String name, String description, Float price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Float getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return String.format(
                "Servicio: %s | Precio: %.2f | Descripción: %s",
                getName(), getPrice(), getDescription()
        );
    }


}
