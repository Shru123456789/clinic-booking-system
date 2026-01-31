package com.example.clinicbooking.events;

import com.example.clinicbooking.model.UserDetails;
import java.util.UUID;

public class BookingConfirmedEvent {
    private UserDetails userDetails;
    private double amount;
    private String referenceId;

    public BookingConfirmedEvent(UserDetails userDetails, double amount) {
        this.userDetails = userDetails;
        this.amount = amount;
        this.referenceId = UUID.randomUUID().toString(); // generate unique ID
    }

    public UserDetails getUserDetails() {
        return userDetails;
    }

    public double getAmount() {
        return amount;
    }

    public String getReferenceId() {
        return referenceId;
    }
}

