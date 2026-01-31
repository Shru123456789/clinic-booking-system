package com.example.clinicbooking.events;

import com.example.clinicbooking.model.UserDetails;

public class PaymentFailedEvent {
    private UserDetails userDetails;
    private String reason;

    public PaymentFailedEvent(UserDetails userDetails, String reason) {
        this.userDetails = userDetails;
        this.reason = reason;
    }

    public UserDetails getUserDetails() {
        return userDetails;
    }

    public String getReason() {
        return reason;
    }
}
