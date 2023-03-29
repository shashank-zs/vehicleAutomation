package org.example.utils;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import junit.framework.Assert;

import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

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
    public static Response postPutApiCall(Map headersList,String url,Object payload,Object expectedStatus){
        Response response= RestAssured.given()
                .headers(headersList)
                .headers("Content-Type","application/json")
                .body((String) payload)
                .when()
                .post(url);
        response.then().log().all();
        return response;
    }
    public static Response getApiCall(Map headersList,String url,String key,Object value,Object expectedStatus){
        Response response= RestAssured.given()
                .headers(headersList)
                .queryParam(key,value)
                .when()
                .get( url);
        Assert.assertEquals(expectedStatus,response.getStatusCode());
        response.then().log().all();
        return response;
    }
    //create random AlphaNumeric String
    public static String generateRandomString() {
        String ALPHABET_CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String IntRandom="0123456789";
        int STRING_LENGTH = 5;
        StringBuilder sb = new StringBuilder(STRING_LENGTH);
        Random random = new Random();
        for (int i = 0; i < STRING_LENGTH; i++) {
            sb.append(ALPHABET_CHARS.charAt(random.nextInt(ALPHABET_CHARS.length())));
            sb.append(IntRandom.charAt(random.nextInt(IntRandom.length())));
        }
        return sb.toString();
    }
    //create random only string
    public static String generateRandomOnlyString() {
        String ALPHANUMERIC_CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int STRING_LENGTH = 10;
        StringBuilder sb = new StringBuilder(STRING_LENGTH);
        Random random = new Random();
        for (int i = 0; i < STRING_LENGTH; i++) {
            sb.append(ALPHANUMERIC_CHARS.charAt(random.nextInt(ALPHANUMERIC_CHARS.length())));
        }
        return sb.toString();
    }
    //assertion for error messages
    public static void assertionErrorMessage(Response response, Object errorMessages) {
        JsonPath jsonPath = response.jsonPath();
        Assert.assertEquals(jsonPath.get("message"), errorMessages);

    }

    public static Response getApiCall(String URL,Object expectedStatus){
        Response response= RestAssured.given()
                .when()
                .get( URL);
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
        token.put("Authorization","Bearer " + DataPath.TOKEN_FOR_ZOPPING);
        return token;
    }

}
