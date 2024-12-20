package com.example.models;

import com.example.data.DetailsData;

import java.time.LocalDate;

public class Details {
    private LocalDate startDate;
    private Integer childrenQuantity;
    private Integer adultsQuantity;
    private String city;

    public Details(DetailsData data) {
        this.startDate = data.getStartDate();
        this.childrenQuantity = data.getChildrenQuantity();
        this.adultsQuantity = data.getAdultsQuantity();
        this.city = data.getCity();
    }

    public Details() {
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

    public LocalDate getStartDate() {
        return startDate;
    }
}
