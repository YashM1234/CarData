package com.car.service;

import com.car.model.Car;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TransmissionFuelTypeMatrix implements MatrixCollector{
    @Override
    public void collect(List<Car> cars, String destination) {
        Map<String, List<Car>> transmissionType = cars.stream()
                .collect(Collectors.groupingBy(Car::getTransmission));


    }
}
