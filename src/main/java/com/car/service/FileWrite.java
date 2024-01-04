package com.car.service;

import com.car.helper.CsvConverter;
import com.car.model.Car;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FileWrite implements WriteOperation{
    @Override
    public void write(List<Car> cars, String destination) {
        StringBuffer buffer = new StringBuffer();
        for(Car car : cars){
            String line = CsvConverter.toCsv(car);
            buffer.append(line);
            buffer.append("\n");
        }
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(destination))){
            writer.write(buffer.toString());
            writer.flush();
        }catch (IOException ex){
            throw new RuntimeException("File not created!");        }
    }
}
