package com.example.clinicbooking.service;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class DiscountQuotaService {

    private int dailyLimit = 100;

    private AtomicInteger todayCount = new AtomicInteger(0);
    private LocalDate lastResetDate = LocalDate.now();

    public synchronized boolean canApplyR1Discount() {
        resetIfNewDay();

        if (todayCount.get() >= dailyLimit) {
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
