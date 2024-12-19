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

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public Integer getChildrenQuantity() {
        return childrenQuantity;
    }

    public void setChildrenQuantity(Integer childrenQuantity) {
        this.childrenQuantity = childrenQuantity;
    }

    public Integer getAdultsQuantity() {
        return adultsQuantity;
    }

    public void setAdultsQuantity(Integer adultsQuantity) {
        this.adultsQuantity = adultsQuantity;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}