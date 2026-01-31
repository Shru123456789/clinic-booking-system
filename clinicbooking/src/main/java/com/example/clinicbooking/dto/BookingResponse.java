// package com.example.clinicbooking.dto;

// public class BookingResponse {

//     private String status;
//     private double finalPrice;
//     private String message;

//     public BookingResponse(String status, double finalPrice, String message) {
//         this.status = status;
//         this.finalPrice = finalPrice;
//         this.message = message;
//     }

//     public String getStatus() {
//         return status;
//     }

//     public double getFinalPrice() {
//         return finalPrice;
//     }

//     public String getMessage() {
//         return message;
//     }
// }

package com.example.clinicbooking.dto;

public class BookingResponse {

    private String status;
    private double finalPrice;
    private String message;
    private double holidayDiscount;
    private double femaleDiscount;
    private double birthdayDiscount;

    public BookingResponse(String status, double finalPrice, String message,
            double holidayDiscount, double femaleDiscount, double birthdayDiscount) {
        this.status = status;
        this.finalPrice = finalPrice;
        this.message = message;
        this.holidayDiscount = holidayDiscount;
        this.femaleDiscount = femaleDiscount;
        this.birthdayDiscount = birthdayDiscount;
    }

    public String getStatus() {
        return status;
    }

    public double getFinalPrice() {
        return finalPrice;
    }

    public String getMessage() {
        return message;
    }

    public double getHolidayDiscount() {
        return holidayDiscount;
    }

    public double getFemaleDiscount() {
        return femaleDiscount;
    }

    public double getBirthdayDiscount() {
        return birthdayDiscount;
    }
}
