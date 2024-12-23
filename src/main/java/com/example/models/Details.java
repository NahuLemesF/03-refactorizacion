package com.example.models;

import com.example.constants.AccommodationType;

import java.time.LocalDate;

public class Details {
    private LocalDate startDate;
    private AccommodationType accommodationType;
    private Integer childrenQuantity;
    private Integer adultsQuantity;
    private String city;

    public Details(
        LocalDate startDate,
        Integer childrenQuantity,
        Integer adultsQuantity,
        String city,
        AccommodationType accommodationType
    ) {
        this.startDate = startDate;
        this.childrenQuantity = childrenQuantity;
        this.adultsQuantity = adultsQuantity;
        this.city = city;
        this.accommodationType = accommodationType;
    }


    public String toString() {
        return "{" +
                "Fecha de Alojamiento: " + startDate + "\n" +
                "Tipo de Alojamiento: " + accommodationType + "\n" +
                "Cantidad de niños: " + childrenQuantity + "\n" +
                "Cantidad de Adultos: " + adultsQuantity + "\n" +
                "Ciudad: " + city + "\n" +
                '}';
    }

    public AccommodationType getAccommodationType() {
        return accommodationType;
    }

    public void setAccommodationType(AccommodationType accommodationType) {
        this.accommodationType = accommodationType;
    }

    public Integer getAdultsQuantity() {
        return adultsQuantity;
    }

    public void setAdultsQuantity(Integer adultsQuantity) {
        this.adultsQuantity = adultsQuantity;
    }

    public Integer getChildrenQuantity() {
        return childrenQuantity;
    }

    public void setChildrenQuantity(Integer childrenQuantity) {
        this.childrenQuantity = childrenQuantity;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }
}