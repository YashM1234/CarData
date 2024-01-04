package com.car;

import com.car.inmemory.InMemoryStorage;
import com.car.service.*;

public class CarApp {
    public static void main(String[] args) {
        //Csv file merger
        MergeOperation fileMerger = new DataMerger();
        fileMerger.merger(InMemoryStorage.cars, "src/main/resources/Car");

        WriteOperation jsonWriter = new JsonWriter();
        //Json
        jsonWriter.write(InMemoryStorage.cars, "src/main/resources/Car/carMerge.json");

        //Matrix
        MatrixCollector collector = new TransmissionFuelTypeMatrix();
        collector.collect(InMemoryStorage.cars, "src/main/resources/Car/transmissionFuelTypeCarDetail.json");
    }
}
