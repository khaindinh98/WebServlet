package com.khaindinh98.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.khaindinh98.model.NewsModel;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Scanner;

public class JSONUtil {
    private StringBuilder value;

    private static JSONUtil instance;

    private JSONUtil(){
        //do nothing
    }

    public static JSONUtil getInstance(InputStream inputStream){
        if(instance==null){
            instance = new JSONUtil();
        }
        instance.setValue(inputStream);
        return instance;
    }

    private void setValue(InputStream inputStream){
        this.value = new StringBuilder();
        Scanner scanner = new Scanner(inputStream);
        String line;
        while ((line = scanner.nextLine())!=null){
            this.value.append(line);
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
