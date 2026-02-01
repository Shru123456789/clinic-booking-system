package com.example.clinicbooking.service;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class DiscountQuotaService {

    private static final int DAILY_LIMIT = 100;

    private final AtomicInteger todayCount = new AtomicInteger(0);
    private LocalDate lastResetDate = LocalDate.now();

    /**
     * R1 Discount quota validation
     * If quota is exceeded, BookingService performs compensation
     */
    public synchronized boolean canApplyR1Discount() {
        resetIfNewDay();

        // 🔴 COMPENSATION TRIGGER POINT
        if (todayCount.get() >= DAILY_LIMIT) {
            return false;
        }

        todayCount.incrementAndGet();
        return true;
    }

    private void resetIfNewDay() {
        LocalDate today = LocalDate.now();
        if (!today.equals(lastResetDate)) {
            todayCount.set(0);
            lastResetDate = today;
        }
    }
}

