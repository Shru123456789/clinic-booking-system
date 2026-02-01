package com.example.clinicbooking.service;

import com.example.clinicbooking.dto.BookingRequest;
import com.example.clinicbooking.dto.BookingResponse;
import com.example.clinicbooking.model.ServiceItem;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class BookingService {

    private final HolidayService holidayService;
    private final DiscountQuotaService discountQuotaService;

    public BookingService(HolidayService holidayService,
                          DiscountQuotaService discountQuotaService) {
        this.holidayService = holidayService;
        this.discountQuotaService = discountQuotaService;
    }

    public BookingResponse createBooking(BookingRequest request) {

        //  STEP 1: VALIDATION CHECKS
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
                    0.0
            );
        }

        //  STEP 2: CALCULATE BASE PRICE
        double total = 0.0;

        for (ServiceItem s : request.getSelectedServices()) {
            if (s == null || s.getPrice() <= 0) {
                return new BookingResponse(
                        "FAILED",
                        0.0,
                        "Invalid service price",
                        0.0,
                        0.0,
                        0.0
                );
            }
            total += s.getPrice();
        }

        double holidayDiscount = 0.0;
        double femaleDiscount = 0.0;
        double birthdayDiscount = 0.0;

        LocalDate bookingDate = request.getBookingLocalDate();
        LocalDate dob = request.getDateOfBirth();
        String gender = request.getGender();

        // STEP 3: DISCOUNT QUOTA CHECK (COMPENSATION POINT)
        if (!discountQuotaService.canApplyR1Discount()) {

            // 👉 COMPENSATION: rollback all discounts
            return new BookingResponse(
                    "FAILED",
                    total,
                    "Daily discount quota reached. Please try again tomorrow.",
                    0.0,
                    0.0,
                    0.0
            );
        }

        //  STEP 4: HOLIDAY DISCOUNT (3%)
        try {
            if (holidayService.isHoliday(bookingDate)) {
                holidayDiscount = total * 0.03;
            }
        } catch (Exception e) {
            // graceful handling (R2 API failure)
            holidayDiscount = 0.0;
        }

        //  STEP 5: FEMALE DISCOUNT (5%)
        if ("female".equalsIgnoreCase(gender)) {
            femaleDiscount = total * 0.05;
        }

        //  STEP 6: BIRTHDAY DISCOUNT (10%)
        if (dob.getMonth() == bookingDate.getMonth()
                && dob.getDayOfMonth() == bookingDate.getDayOfMonth()) {
            birthdayDiscount = total * 0.10;
        }

        double totalDiscount = holidayDiscount + femaleDiscount + birthdayDiscount;
        double finalPrice = total - totalDiscount;

        return new BookingResponse(
                "SUCCESS",
                finalPrice,
                "Booking confirmed with discounts applied",
                holidayDiscount,
                femaleDiscount,
                birthdayDiscount
        );
    }
}

