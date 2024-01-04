package com.car.helper;

import com.car.model.Car;

public class CarBuilder {
    public static Car build(String line){
        String[] fields = line.split(",");
        return Car.builder()
                .model(fields[0])
                .year(Integer.parseInt(fields[1]))
                .price(Double.parseDouble(fields[2]))
                .transmission(fields[3])
                .mileage(Integer.parseInt(fields[4]))
                .fuelType(fields[5])
                .tax(Integer.parseInt(fields[6]))
                .mpg(Double.parseDouble(fields[7]))
                .engineSize(Double.parseDouble(fields[8]))
                .build();
    }
}
