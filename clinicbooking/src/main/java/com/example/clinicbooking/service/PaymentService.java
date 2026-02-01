
package com.example.clinicbooking.service;

import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    public boolean processPayment(double amount) {
        // Simulate payment processing logic
        System.out.println("Processing payment: " + amount);
        return true; // payment success
    }
}

