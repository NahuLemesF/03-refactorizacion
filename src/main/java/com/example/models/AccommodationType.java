package com.example.models;

public enum AccommodationType {
    HOTEL("Hotel"),
    FARM("Finca"),
    APARTMENT("Apartamento"),;

    private final String description;

    AccommodationType(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }
}