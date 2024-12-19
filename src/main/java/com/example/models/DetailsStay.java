package com.example.models;

import java.time.LocalDate;

public class DetailsStay extends Details {
    private LocalDate endDate;
    private Integer roomsQuantity;
    private AccommodationType accommodationType;

    public DetailsStay(
        LocalDate startDate,
        Integer childrenQuantity,
        Integer adultsQuantity,
        LocalDate endDate,
        Integer roomsQuantity,
        String city,
        AccommodationType accommodationType
    ) {
        super(startDate, childrenQuantity, adultsQuantity, city);
        this.endDate = endDate;
        this.roomsQuantity = roomsQuantity;
        this.accommodationType = accommodationType;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Integer getRoomsQuantity() {
        return roomsQuantity;
    }

    public void setRoomsQuantity(Integer roomsQuantity) {
        this.roomsQuantity = roomsQuantity;
    }

    public AccommodationType getAccommodationType() {
        return accommodationType;
    }


}