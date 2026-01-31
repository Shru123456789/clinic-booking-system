
package com.example.clinicbooking.dto;

public class ServiceRequest {

    private String serviceName;
    private double price;

    public ServiceRequest() {
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

