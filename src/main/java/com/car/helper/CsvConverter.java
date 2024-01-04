package com.car.helper;

import com.car.model.Car;

public class CsvConverter {
    public static String toCsv(Car car) {
        return car.getModel()
                + "," + car.getYear()
                + "," + car.getPrice()
                + "," + car.getTransmission()
                + "," + car.getMileage()
                + "," + car.getFuelType()
                + "," + car.getTax()
                + "," + car.getMpg()
                + "," + car.getEngineSize();
    }
}
