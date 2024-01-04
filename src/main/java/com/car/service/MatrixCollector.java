package com.car.service;

import com.car.model.Car;

import java.util.List;

public interface MatrixCollector {

    void collect(List<Car> cars, String destination);
}
