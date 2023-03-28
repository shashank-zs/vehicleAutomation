package com.qa.api.zopping.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author shikha rani
 */
public class TestUtil {
    /**
     * This is a method for serialization of POJO Object
     * @param object
     * @return String
     */
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

