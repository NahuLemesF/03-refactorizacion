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

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
}