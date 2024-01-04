package com.car.helper;

import java.io.*;

public class HeaderReader {
    public static String getHeader(String path){
        File file = new File(path);
        try(BufferedReader reader = new BufferedReader(new FileReader(file))){
            return reader.readLine();
        }catch (IOException ex){
            throw new RuntimeException("File not Found!");
        }
    }
}
