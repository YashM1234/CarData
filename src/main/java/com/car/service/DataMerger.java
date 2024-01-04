package com.car.service;

import com.car.model.Car;
import java.io.*;
import java.util.List;

public class DataMerger implements MergeOperation{
    ReadOperation readOperation = new FileRead();
    WriteOperation writeOperation = new FileWrite();
    @Override
    public void merger(List<Car> cars, String path) {
        File file = new File(path);
        if(file.isDirectory()){
            File[] files = file.listFiles();
            for(File f : files){
                if(f.isDirectory()){
                merger(cars, f.getPath());
                }else{
                    readOperation.read(f);
                }
            }
        }else{
            readOperation.read(file);
        }
        writeOperation.write(cars, "src/main/resources/merge/carMerge.csv");
    }
}
