package org.duongnhieu.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;

public class HttpUtil {

    private String value;

    public HttpUtil(String value){
        this.value = value;
    }

    public <T> T toModel(Class<T> tClass) {
        try {
            return new ObjectMapper().readValue(value, tClass);
        } catch (IOException e) {
            System.out.println("To model error " + e.getMessage());
            return null;
        }
    }

    public static HttpUtil of(BufferedReader bufferedReader) {
        StringBuilder sb = new StringBuilder();
        String line ;
        try {
            while ((line = bufferedReader.readLine()) != null) {
                sb.append(line);
            }
            return new HttpUtil(sb.toString());
        }catch (IOException e){
            System.out.println("Http error " + e.getMessage());
            return null;
        }
    }
}
