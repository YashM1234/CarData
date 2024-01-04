package com.car.service;

import com.car.helper.CarBuilder;
import com.car.inmemory.InMemoryStorage;
import com.car.model.Car;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileRead implements ReadOperation{
    @Override
    public void read(File file) {
        try(BufferedReader reader = new BufferedReader(new FileReader(file))){
            String line = reader.readLine();
            while((line = reader.readLine()) != null){
                Car car = CarBuilder.build(line);
                InMemoryStorage.cars.add(car);
            }

        }catch(IOException ex){
            throw new RuntimeException("File not found: " + file);
        }
    }
}
