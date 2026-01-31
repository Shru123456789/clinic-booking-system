// package com.example.clinicbooking.service;

// import com.example.clinicbooking.dto.BookingRequest;
// import com.example.clinicbooking.dto.BookingResponse;
// import com.example.clinicbooking.model.ServiceItem;
// import org.springframework.stereotype.Service;

// import java.time.LocalDate;

// @Service
// public class BookingService {

//     private final HolidayService holidayService;

//     public BookingService(HolidayService holidayService) {
//         this.holidayService = holidayService;
//     }

//     public BookingResponse createBooking(BookingRequest request) {
//         double total = 0;

//         // Calculate total price of selected services
//         for (ServiceItem s : request.getSelectedServices()) {
//             total += s.getPrice();
//         }

//         double holidayDiscount = 0;
//         double femaleDiscount = 0;
//         double birthdayDiscount = 0;

//         LocalDate bookingDate = request.getBookingLocalDate();
//         LocalDate dob = request.getDateOfBirth();
//         String gender = request.getGender();

//         // Holiday discount: 3%
//         if (bookingDate != null && holidayService.isHoliday(bookingDate)) {
//             holidayDiscount = total * 0.03;
//         }

//         // Female discount: 5%
//         if (gender != null && gender.equalsIgnoreCase("female")) {
//             femaleDiscount = total * 0.05;
//         }

//         // Birthday discount: 10%
//         if (dob != null && bookingDate != null) {
//             // Compare only month and day, ignore year
//             if (dob.getMonth() == bookingDate.getMonth() &&
//                     dob.getDayOfMonth() == bookingDate.getDayOfMonth()) {
//                 birthdayDiscount = total * 0.10;
//             }
//         }

//         double totalDiscount = holidayDiscount + femaleDiscount + birthdayDiscount;
//         double finalPrice = total - totalDiscount;

//         // Message with applied discounts
//         String message = "Booking confirmed";
//         if (totalDiscount > 0) {
//             message += " with discounts applied";
//         }

//         // Return response with discount breakdown
//         return new BookingResponse(
//                 "SUCCESS",
//                 finalPrice,
//                 message,
//                 holidayDiscount,
//                 femaleDiscount,
//                 birthdayDiscount);
//     }
// }

// package com.example.clinicbooking.service;

// import com.example.clinicbooking.dto.BookingRequest;
// import com.example.clinicbooking.dto.BookingResponse;
// import com.example.clinicbooking.model.ServiceItem;
// import org.springframework.stereotype.Service;

// import java.time.LocalDate;

// @Service
// public class BookingService {

//     private final HolidayService holidayService;

//     public BookingService(HolidayService holidayService) {
//         this.holidayService = holidayService;
//     }

//     public BookingResponse createBooking(BookingRequest request) {
//         double total = 0;

//         for (ServiceItem s : request.getSelectedServices()) {
//             total += s.getPrice();
//         }

//         double holidayDiscount = 0;
//         double femaleDiscount = 0;
//         double birthdayDiscount = 0;

//         LocalDate bookingDate = request.getBookingLocalDate();
//         LocalDate dob = request.getDateOfBirth();
//         String gender = request.getGender();

//         // Holiday discount: 3%
//         if (bookingDate != null && holidayService.isHoliday(bookingDate)) {
//             holidayDiscount = total * 0.03;
//         }

//         // Female discount: 5%
//         if (gender != null && gender.equalsIgnoreCase("female")) {
//             femaleDiscount = total * 0.05;
//         }

//         // Birthday discount: 10%
//         if (dob != null && bookingDate != null) {
//             if (dob.getMonth() == bookingDate.getMonth() &&
//                     dob.getDayOfMonth() == bookingDate.getDayOfMonth()) {
//                 birthdayDiscount = total * 0.10;
//             }
//         }

//         double totalDiscount = holidayDiscount + femaleDiscount + birthdayDiscount;
//         double finalPrice = total - totalDiscount;

//         String message = "Booking confirmed";
//         if (totalDiscount > 0) {
//             message += " with discounts applied";
//         }

//         return new BookingResponse(
//                 "SUCCESS",
//                 finalPrice,
//                 message,
//                 holidayDiscount,
//                 femaleDiscount,
//                 birthdayDiscount);
//     }
// }

package com.example.clinicbooking.service;

import com.example.clinicbooking.dto.BookingRequest;
import com.example.clinicbooking.dto.BookingResponse;
import com.example.clinicbooking.model.ServiceItem;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class BookingService {

    private final HolidayService holidayService;

    public BookingService(HolidayService holidayService) {
        this.holidayService = holidayService;
    }

    public BookingResponse createBooking(BookingRequest request) {

        // 🔴 STEP 1: VALIDATION CHECKS
        if (request == null
                || request.getUserDetails() == null
                || request.getSelectedServices() == null
                || request.getSelectedServices().isEmpty()
                || request.getBookingLocalDate() == null
                || request.getDateOfBirth() == null
                || request.getGender() == null) {

            return new BookingResponse(
                    "FAILED",
                    0.0,
                    "Invalid booking request",
                    0.0,
                    0.0,
                    0.0);
        }

        // 🔵 STEP 2: CALCULATE BASE PRICE
        double total = 0;

        for (ServiceItem s : request.getSelectedServices()) {
            if (s == null || s.getPrice() <= 0) {
                return new BookingResponse(
                        "FAILED",
                        0.0,
                        "Invalid service price",
                        0.0,
                        0.0,
                        0.0);
            }
            total += s.getPrice();
        }

        double holidayDiscount = 0;
        double femaleDiscount = 0;
        double birthdayDiscount = 0;

        LocalDate bookingDate = request.getBookingLocalDate();
        LocalDate dob = request.getDateOfBirth();
        String gender = request.getGender();

        // 🟡 STEP 3: HOLIDAY DISCOUNT (3%)
        try {
            if (holidayService.isHoliday(bookingDate)) {
                holidayDiscount = total * 0.03;
            }
        } catch (Exception e) {
            // graceful handling (R2 API failure)
            holidayDiscount = 0;
        }

        // 🟣 STEP 4: FEMALE DISCOUNT (5%)
        if ("female".equalsIgnoreCase(gender)) {
            femaleDiscount = total * 0.05;
        }

        // 🟢 STEP 5: BIRTHDAY DISCOUNT (10%)
        if (dob.getMonth() == bookingDate.getMonth()
                && dob.getDayOfMonth() == bookingDate.getDayOfMonth()) {
            birthdayDiscount = total * 0.10;
        }

        double totalDiscount = holidayDiscount + femaleDiscount + birthdayDiscount;
        double finalPrice = total - totalDiscount;

        String message = "Booking confirmed";
        if (totalDiscount > 0) {
            message += " with discounts applied";
        }

        return new BookingResponse(
                "SUCCESS",
                finalPrice,
                message,
                holidayDiscount,
                femaleDiscount,
                birthdayDiscount);
    }
}
