package com.example.models;

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
        String city
    ) {
        this.startDate = startDate;
        this.childrenQuantity = childrenQuantity;
        this.adultsQuantity = adultsQuantity;
        this.city = city;
    }


    public Integer getChildrenQuantity() {
        return childrenQuantity;
    }

    public Integer getAdultsQuantity() {
        return adultsQuantity;
    }

    public String getCity() {
        return city;
    }

}