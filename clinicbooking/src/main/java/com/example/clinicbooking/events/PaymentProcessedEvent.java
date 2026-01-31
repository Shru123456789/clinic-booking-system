package com.example.clinicbooking.events;

import com.example.clinicbooking.model.UserDetails;

public class PaymentProcessedEvent {
    private UserDetails userDetails;
    private double amount;

    public PaymentProcessedEvent(UserDetails userDetails, double amount) {
        this.userDetails = userDetails;
        this.amount = amount;
    }

    public UserDetails getUserDetails() {
        return userDetails;
    }

    public double getAmount() {
        return amount;
    }
}
