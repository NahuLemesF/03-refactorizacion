package com.example.services;

public class PriceCalculator {

    public float calculateStayPrice(float roomPrice, int roomsQuantity, int totalPeople) {
        return roomPrice * roomsQuantity * totalPeople;
    }

    public float calculateDayPassPrice(float personPrice, int totalPeople) {
        return personPrice * totalPeople;
    }
}
