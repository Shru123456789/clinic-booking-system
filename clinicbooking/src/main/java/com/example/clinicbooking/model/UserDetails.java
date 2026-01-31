// package com.example.clinicbooking.model;

// import java.time.LocalDate;

// public class UserDetails {

//     private String name;
//     private String gender;
//     private LocalDate dob;

//     public String getName() {
//         return name;
//     }

//     public void setName(String name) {
//         this.name = name;
//     }

//     public String getGender() {
//         return gender;
//     }

//     public void setGender(String gender) {
//         this.gender = gender;
//     }

//     public LocalDate getDob() {
//         return dob;
//     }

//     public void setDob(LocalDate dob) {
//         this.dob = dob;
//     }

//     public int getAge() {
//         return LocalDate.now().getYear() - dob.getYear();
//     }

// }

package com.example.clinicbooking.model;

public class UserDetails {

    private String name;
    private String gender;
    private String dob; // yyyy-MM-dd

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }
}
