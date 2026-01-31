package com.example.clinicbooking.events;

import com.example.clinicbooking.model.UserDetails;

public class DiscountAppliedEvent {
    private UserDetails userDetails;
    private double finalPrice;

    public DiscountAppliedEvent(UserDetails userDetails, double finalPrice) {
        this.userDetails = userDetails;
        this.finalPrice = finalPrice;
    }

    public UserDetails getUserDetails() {
        return userDetails;
    }

    public double getFinalPrice() {
        return finalPrice;
    }
}
