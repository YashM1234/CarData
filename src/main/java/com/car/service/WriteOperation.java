package com.car.service;

import com.car.model.Car;

import java.util.List;

public interface WriteOperation {
    void write(List<Car> cars, String destination);

}
