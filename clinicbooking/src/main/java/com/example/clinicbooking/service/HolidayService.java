// package com.example.clinicbooking.service;

// import org.springframework.stereotype.Service;
// import java.time.LocalDate;
// import java.util.HashSet;
// import java.util.Set;

// @Service
// public class HolidayService {

//     // Static holiday list (can be replaced with DB later)
//     private static final Set<LocalDate> HOLIDAYS = new HashSet<>();

//     static {
//         // India holidays (example)
//         HOLIDAYS.add(LocalDate.of(2026, 1, 26)); // Republic Day
//         HOLIDAYS.add(LocalDate.of(2026, 8, 15)); // Independence Day
//         HOLIDAYS.add(LocalDate.of(2026, 10, 2)); // Gandhi Jayanti
//         HOLIDAYS.add(LocalDate.of(2026, 1, 29));
//     }

//     /**
//      * Check if a given date is a holiday
//      */
//     public boolean isHoliday(LocalDate date) {
//         return HOLIDAYS.contains(date);
//     }

package com.example.clinicbooking.service;

import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Service
public class HolidayService {

    private static final Set<LocalDate> HOLIDAYS = new HashSet<>();

    static {
        HOLIDAYS.add(LocalDate.of(2026, 1, 26)); // Republic Day
        HOLIDAYS.add(LocalDate.of(2026, 8, 15)); // Independence Day
        HOLIDAYS.add(LocalDate.of(2026, 10, 2)); // Gandhi Jayanti
        HOLIDAYS.add(LocalDate.of(2026, 1, 29)); // Example holiday
    }

    public boolean isHoliday(LocalDate date) {
        return HOLIDAYS.contains(date);
    }
}
