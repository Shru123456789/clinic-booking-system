package com.example.clinicbooking.service;

import com.example.clinicbooking.model.UserDetails;

import java.util.concurrent.atomic.AtomicInteger;

public class BookingStatusStore {

    private static BookingStatusStore instance = null;
    private AtomicInteger r1QuotaUsed = new AtomicInteger(0);
    private final int R1_DAILY_QUOTA = 100; // configurable

    private BookingStatusStore() {
    }

    public static BookingStatusStore getInstance() {
        if (instance == null) {
            instance = new BookingStatusStore();
        }
        return instance;
    }

    public boolean checkAndUseR1Quota() {
        if (r1QuotaUsed.get() < R1_DAILY_QUOTA) {
            r1QuotaUsed.incrementAndGet();
            return true;
        }
        return false;
    }

    // Rollback quota if booking fails
    public void rollbackDiscount(UserDetails user) {
        System.out.println("[ROLLBACK] Rolling back R1 discount for " + user.getName());
        r1QuotaUsed.decrementAndGet();
    }
}
