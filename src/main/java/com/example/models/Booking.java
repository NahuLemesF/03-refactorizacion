package com.example.models;

public class Booking {
    private Accommodation accommodation;
    private Client client;
    private Details details;

    public Booking(Accommodation accommodation, Client client, Details details) {
        this.accommodation = accommodation;
        this.client = client;
        this.details = details;
    }

    public Accommodation getAccommodation() {
        return accommodation;
    }

    public void setAccommodation(Accommodation accommodation) {
        this.accommodation = accommodation;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Details getDetails() {
        return details;
    }

    public void setDetails(Details details) {
        this.details = details;
    }
}