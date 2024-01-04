package com.car;

import com.car.inmemory.InMemoryStorage;
import com.car.service.*;

public class CarApp {
    public static void main(String[] args) {
        //Csv file merger
        MergeOperation fileMerger = new DataMerger();
        fileMerger.merger(InMemoryStorage.cars, "src/main/resources/Car");

        //Json
        WriteOperation jsonWriter = new JsonWriter();
        jsonWriter.write(InMemoryStorage.cars, "src/main/resources/merge/carMerge.json");

        //Metrics
        MetricsCollector collector = new TransmissionFuelTypeMetrics();
        collector.collect(InMemoryStorage.cars, "src/main/resources/metrics/transmissionFuelTypeCarDetail.json");
    }
}
