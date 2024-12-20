package com.example.models;

import com.example.data.DetailsData;

import java.time.LocalDate;

public class DetailsStay extends Details {
    private LocalDate endDate;
    private Integer roomsQuantity;
    private AccommodationType accommodationType;

    public DetailsStay(DetailsData data, LocalDate endDate, Integer roomsQuantity, AccommodationType accommodationType) {
        super(data);
        this.endDate = endDate;
        this.roomsQuantity = roomsQuantity;
        this.accommodationType = accommodationType;
    }

    public Integer getRoomsQuantity() {
        return roomsQuantity;
    }

}
