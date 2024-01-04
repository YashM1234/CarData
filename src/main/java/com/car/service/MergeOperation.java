package com.car.service;

import com.car.model.Car;

import java.util.List;

public interface MergeOperation {
    void merger(List<Car> cars, String path);

}
