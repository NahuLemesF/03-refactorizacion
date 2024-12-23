package com.example.models;

import com.example.constants.AccommodationType;

import java.time.LocalDate;

public class DetailsStay extends Details {
    private LocalDate endDate;
    private Integer roomsQuantity;

    public DetailsStay(
        LocalDate startDate,
        Integer childrenQuantity,
        Integer adultsQuantity,
        LocalDate endDate,
        Integer roomsQuantity,
        String city,
        AccommodationType accommodationType
    ) {
        super(startDate, childrenQuantity, adultsQuantity, city, accommodationType);
        this.endDate = endDate;
        this.roomsQuantity = roomsQuantity;
    }
}