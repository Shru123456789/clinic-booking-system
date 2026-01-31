// package com.example.clinicbooking.dto;

// import com.example.clinicbooking.model.UserDetails;
// import com.example.clinicbooking.model.ServiceItem;

// import java.time.LocalDate;
// import java.util.List;

// public class BookingRequest {

//     private UserDetails userDetails;
//     private List<ServiceItem> selectedServices;

//     public UserDetails getUserDetails() { return userDetails; }
//     public void setUserDetails(UserDetails userDetails) { this.userDetails = userDetails; }

//     public List<ServiceItem> getSelectedServices() { return selectedServices; }
//     public void setSelectedServices(List<ServiceItem> selectedServices) { this.selectedServices = selectedServices; }

//     // Convenience methods
//     public String getGender() { return userDetails.getGender(); }
//     public LocalDate getDateOfBirth() { return userDetails.getDob(); }
// }

package com.example.clinicbooking.dto;

import com.example.clinicbooking.model.UserDetails;
import com.example.clinicbooking.model.ServiceItem;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class BookingRequest {

    private UserDetails userDetails;
    private List<ServiceItem> selectedServices;
    private String bookingDate;

    public UserDetails getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(UserDetails userDetails) {
        this.userDetails = userDetails;
    }

    public List<ServiceItem> getSelectedServices() {
        return selectedServices;
    }

    public void setSelectedServices(List<ServiceItem> selectedServices) {
        this.selectedServices = selectedServices;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getGender() {
        return userDetails != null ? userDetails.getGender() : null;
    }

    public LocalDate getDateOfBirth() {
        if (userDetails != null && userDetails.getDob() != null) {
            return LocalDate.parse(userDetails.getDob(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        }
        return null;
    }

    public LocalDate getBookingLocalDate() {
        if (bookingDate != null) {
            return LocalDate.parse(bookingDate, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        }
        return null;
    }
}
