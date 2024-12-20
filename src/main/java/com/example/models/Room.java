package com.example.models;

public class Room extends Service {
    private Integer stock;
    private String type;
    private Float price;

    public Room(String name, String description, Integer stock, String type, Float price) {
        super(name, description);
        this.stock = stock;
        this.type = type;
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public Float getPrice() {
        return price;
    }

}