package com.example.data;

import java.time.LocalDate;

public class DetailsData {
    private LocalDate startDate;
    private Integer childrenQuantity;
    private Integer adultsQuantity;
    private String city;

    public DetailsData(LocalDate startDate, Integer childrenQuantity, Integer adultsQuantity, String city) {
        this.startDate = startDate;
        this.childrenQuantity = childrenQuantity;
        this.adultsQuantity = adultsQuantity;
        this.city = city;
    }

    // Getters
    public LocalDate getStartDate() {
        return startDate;
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
