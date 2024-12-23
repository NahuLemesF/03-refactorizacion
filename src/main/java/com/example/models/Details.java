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

    public Integer getAdultsQuantity() {
        return adultsQuantity;
    }

    public Integer getChildrenQuantity() {
        return childrenQuantity;
    }

    public String getCity() {
        return city;
    }
}