package com.car.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Car {
    private String model;
    private int year;
    private double price;
    private String transmission;
    private int mileage;
    private String fuelType;
    private double tax;
    private double mpg;
    private double engineSize;
}
