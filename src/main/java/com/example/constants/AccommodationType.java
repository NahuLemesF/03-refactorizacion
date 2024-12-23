package com.example.constants;

public enum AccommodationType {
    HOTEL("Hotel"),
    FARM("Finca"),
    APARTMENT("Apartamento"),
    DAY_PASS("Día de Sol");

    private final String description;

    AccommodationType(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }
}