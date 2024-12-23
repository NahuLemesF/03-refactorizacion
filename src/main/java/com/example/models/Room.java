package com.example.models;

public class Room extends Service {
    private Integer stock;
    private String type;

    public Room(String name, String description, Integer stock, String type, Float price) {
        super(name, description, price);
        this.stock = stock;
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public Integer getStock() {
        return stock;
    }

    @Override
    public String toString() {
        return String.format(
                "Habitación: %s | Precio: %.2f | Descripción: %s | Tipo: %s | Stock: %d",
                getName(), getPrice(), getDescription(), getType(), getStock()
        );
    }

}
