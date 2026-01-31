// package com.example.clinicbooking.controller;

// import com.example.clinicbooking.dto.BookingRequest;
// import com.example.clinicbooking.dto.BookingResponse;
// import com.example.clinicbooking.service.BookingService;
// import org.springframework.web.bind.annotation.*;

// @RestController
// @RequestMapping("/api/bookings")
// public class BookingController {

//     private final BookingService bookingService;

//     public BookingController(BookingService bookingService) {
//         this.bookingService = bookingService;
//     }

//     @PostMapping
//     public BookingResponse createBooking(@RequestBody BookingRequest request) {
//         return bookingService.createBooking(request);
//     }
// }

package com.example.clinicbooking.controller;

import com.example.clinicbooking.dto.BookingRequest;
import com.example.clinicbooking.dto.BookingResponse;
import com.example.clinicbooking.service.BookingService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping
    public BookingResponse createBooking(@RequestBody BookingRequest request) {
        return bookingService.createBooking(request);
    }
}
