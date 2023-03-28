package org.example.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TestUtil {

    public static String getSerialization(Object object){
        ObjectMapper objectMapper=new ObjectMapper();
        String jsonString=null;
        try {
            jsonString=objectMapper.writeValueAsString(object);
            System.out.println("JSON Body Payload==========> "+jsonString);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return jsonString;
    }
}

