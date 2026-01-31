// package com.example.clinicbooking.service;

// import com.example.clinicbooking.model.UserDetails;
// import org.springframework.stereotype.Service;
// import java.util.Random;

// @Service
// public class PaymentService {

//     public void processPayment(UserDetails user, double amount) throws Exception {
//         System.out.println("[PAYMENT] Processing payment for " + user.getName() + ", Amount: " + amount);

//         // Simulate random payment failure
//         Random rand = new Random();
//         if (rand.nextInt(10) < 2) {
//             throw new Exception("Payment gateway error");
//         }

//         System.out.println("[PAYMENT] Payment successful");
//     }
// }

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
