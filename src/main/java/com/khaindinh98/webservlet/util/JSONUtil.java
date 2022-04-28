package com.khaindinh98.webservlet.util;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;

public class JSONUtil {
    private StringBuilder value;

    private static JSONUtil instance;

    private JSONUtil(){
        //do nothing
    }

    public static JSONUtil getInstance(BufferedReader inputStream){
        if(instance==null){
            instance = new JSONUtil();
        }
        instance.setValue(inputStream);
        return instance;
    }

    private void setValue(BufferedReader inputStream){
        this.value = new StringBuilder();
        String line;
        try {
            while (true){
                if (!((line = inputStream.readLine())!=null)) break;
                    this.value.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
            this.value = new StringBuilder();
        }
    }

    public <T> T toModel(Class<T> tClass){
        ObjectMapper mapper = new ObjectMapper();
        T model = null;
        try {
            model = mapper.readValue(this.value.toString(), tClass);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return model;
    }

    public static void toOutputStream(OutputStream outputStream, Object model){
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(outputStream, model);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
