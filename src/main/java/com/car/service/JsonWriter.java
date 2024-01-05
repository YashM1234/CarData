package com.car.service;

import com.car.model.Car;
import com.car.model.TransmissionCount;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class JsonWriter implements WriteOperation{
    ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void write(List<Car> cars, String destination) {
        File file = new File(destination);
        String json = null;
        try {
            json = objectMapper.writeValueAsString(cars);
        } catch (JsonProcessingException ex) {
            throw new RuntimeException("Json not processed!");
        }

        try(FileWriter writer = new FileWriter(file)) {
           writer.write(json);
            writer.flush();
        }catch (IOException ex){
            throw new RuntimeException("File " + destination + " could not found!");
        }
    }

    public static void write(TransmissionCount metricsResult, String destination) {
        ObjectMapper objectMapper1 = new ObjectMapper();
        File file = new File(destination);
        String json = null;
        try {
            json = objectMapper1.writeValueAsString(metricsResult);
        } catch (JsonProcessingException ex) {
            throw new RuntimeException("Json not processed!");
        }

        try(FileWriter writer = new FileWriter(file)) {
            writer.write(json);
            writer.flush();
        }catch (IOException ex){
            throw new RuntimeException("File " + destination + " could not found!");
        }
    }

}
