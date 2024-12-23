package com.example.repositories;

import com.example.models.Booking;

public class BookingRepository {
    private static BookingRepository instance;
    private Booking booking;

    private BookingRepository() {
    }

    public static BookingRepository getInstance() {
        if (instance == null) {
            instance = new BookingRepository();
        }
        return instance;
    }

    public Booking getBooking() {
        return booking;
    }

    public void addOrReplaceBooking(Booking booking) {
        this.booking = booking;
    }

    public void removeBooking() {
        this.booking = null;
    }

}
