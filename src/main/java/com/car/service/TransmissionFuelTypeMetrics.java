package com.car.service;

import com.car.model.Car;
import com.car.model.FuelTypeCount;
import com.car.model.TransmissionCount;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TransmissionFuelTypeMetrics implements MetricsCollector {
    @Override
    public void collect(List<Car> cars, String destination) {
        Map<String, List<Car>> transmissionType = cars.stream()
                .collect(Collectors.groupingBy(Car::getTransmission));

        Map<String, FuelTypeCount> countCar = new HashMap<>();
        transmissionType.forEach((transType, records) -> {
            Map<String, List<Car>> countFuelType = records.stream()
                    .collect(Collectors.groupingBy(Car::getFuelType));

            FuelTypeCount count = FuelTypeCount.builder().total(records.size()).build();
            countFuelType.entrySet().forEach((entry) -> {
                setValue(entry, count);
            });
            countCar.put(transType, count);
        });
        TransmissionCount count = TransmissionCount.builder().transmissionType(countCar).build();
        JsonWriter.write(count, destination);
    }

    private static void setValue(Map.Entry<String, List<Car>> entry, FuelTypeCount count) {
        if("Petrol".equals(entry.getKey())) {
            count.setPetrol(entry.getValue().size());
        }else if("Diesel".equals(entry.getKey())) {
            count.setDiesel(entry.getValue().size());
        }
    }
}
