package com.utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import junit.framework.Assert;

import java.util.HashMap;
import java.util.Map;

public class Generic {

    public static Response postApiCall(Object URL,Object expectedStatus){
        Response response= RestAssured.given()
                .when()
                .post((String) URL);
        Assert.assertEquals(expectedStatus,response.getStatusCode());
        response.then().log().all();
        return response;
    }
    public static Response postApiCall(Map headersList,String url,Object payload,Object expectedStatus){
        Response response= RestAssured.given()
                .headers(headersList)
                .headers("Content-Type","application/json")
                .body((String) payload)
                .when()
                .post(url);
        Assert.assertEquals(expectedStatus,response.getStatusCode());
        response.then().log().all();
        return response;
    }
    public static Response getApiCall(Map headersList,String url,Object expectedStatus){
        Response response= RestAssured.given()
                .headers(headersList)
                .when()
                .get( url);
        Assert.assertEquals(expectedStatus,response.getStatusCode());
        response.then().log().all();
        return response;
    }
    public static Response getApiCall(Object URL,Object expectedStatus){
        Response response= RestAssured.given()
                .when()
                .get((String) URL);
        Assert.assertEquals(expectedStatus,response.getStatusCode());
        response.then().log().all();
        return response;
    }
    public static Response deleteApiCall(Object url,Object expectedStatus){
        Response response = RestAssured.given()
                .when()
                .delete((String) url);
        Assert.assertEquals(expectedStatus,response.getStatusCode());
        response.then().log().all();
        return response;
    }
    public static Response deleteApiCall(Map headersList,String url,Object expectedStatus){
        Response response = RestAssured.given()
                .headers(headersList)
                .when()
                .delete( url);
        Assert.assertEquals(expectedStatus,response.getStatusCode());
        response.then().log().all();
        return response;
    }
    public static Response putApiCall(Map headersList,String url,Object payload,Object expectedStatus){
        Response response= RestAssured.given()
                .headers(headersList)
                .headers("Content-Type","application/json")
                .body((String) payload)
                .when()
                .put(url);
        Assert.assertEquals(expectedStatus,response.getStatusCode());
        response.then().log().all();
        return response;
    }
    public static Map tokenMap(){
        Map<String, String> token = new HashMap();
        token.put("Authorization","Bearer " + DataPath.TOKEN_FOR_USER);
        return token;
    }

}
