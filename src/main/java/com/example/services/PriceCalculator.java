package com.example.services;

public class PriceCalculator {

    public Float calculateStayPrice(Float roomPrice, Integer roomsQuantity, Integer totalPeople) {
        return roomPrice * roomsQuantity * totalPeople;
    }

    public Float calculateDayPassPrice(Float personPrice, Integer totalPeople) {
        return personPrice * totalPeople;
    }
}
