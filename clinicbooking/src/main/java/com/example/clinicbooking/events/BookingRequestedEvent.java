package com.example.clinicbooking.events;

import com.example.clinicbooking.model.UserDetails;

public class BookingRequestedEvent {
    private UserDetails userDetails;

    public BookingRequestedEvent(UserDetails userDetails) {
        this.userDetails = userDetails;
    }

    public UserDetails getUserDetails() {
        return userDetails;
    }
}
