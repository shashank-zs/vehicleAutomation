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
    /**
     * does generic assertion for all methods
     * @param actual
     * @param expected
     */
    public static void genericAssertion(Object expected,String actual){
        Assert.assertEquals(String.valueOf(expected),actual);
    }
    /**
     * fetch actual single data from response
     * @param response
     * @param jsonPath
     * @return
     */
    public static String getSingleActualResponseData(Response response,String jsonPath){
        JsonPath jsonPathParam=response.jsonPath();
        String responseData=jsonPathParam.getString(jsonPath);
        return responseData;
    }

    /**
     * Post api call. pass expected Status & post url.
     * @param URL
     * @param expectedStatus
     * @return
     */

    public static Response postApiCall(Object URL,Object expectedStatus){
        Response response= RestAssured.given()
                .when()
                .post((String) URL);

        Assert.assertEquals(expectedStatus,response.getStatusCode());
        response.then().log().all();
        return response;
    }
    /**
     * Post api call. pass payload as string and post url.
     * @param payload
     * @param url
     * @param expectedStatus
     * @return
     */
    public static Response postApiCall(String url,String payload,Object expectedStatus){
        Response response= RestAssured.given()
                .headers("content-type","application/json")
                .body( payload)
                .when()
                .post(url);
         Assert.assertEquals(expectedStatus,response.getStatusCode());
        response.then().log().all();
        return response;
    }

    /**
     * put api which requires
     * @param url
     * @param payload
     * @param expectedStatus
     * @return
     */
    public static Response putApiCall(String url,String payload,Object expectedStatus){
        Response response= RestAssured.given()
                .headers("content-type","application/json")
                .body( payload)
                .when()
                .put(url);
        Assert.assertEquals(expectedStatus,response.getStatusCode());
        response.then().log().all();
        return response;
    }

    /**
     * we can do fetch response data and do assertion for single data using
     * @param response
     * @param data
     * @param path
     */
    public static void genericAssertionWithResponse(Response response, Object data,String path) {
        String actualData = getSingleActualResponseData(response, path);
        if (actualData !=null) {
            genericAssertion(data, actualData);
        }
    }
    /**
     * Post api call. Pass headerList along with auth token, payload as string and post url.
     * @param payload
     * @param url
     * @param expectedStatus
     * @return
     */
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

    /**
     * get api
     * @param url
     * @param key
     * @param value
     * @param expectedStatus
     * @return
     */
    public static Response getApiCall(String url,String key,Object value,Object expectedStatus){
        Response response= RestAssured.given()
                .queryParam(key,value)
                .when()
                .get( url);
        Assert.assertEquals(expectedStatus,response.getStatusCode());
        response.then().log().all();
        return response;
    }

    /**
     * @param url
     * @param queryData
     * @param expectedStatus
     * @return
     */
    public static Response getApiCall(String url,Map queryData,Object expectedStatus){
        Response response= RestAssured.given()
                .queryParams(queryData)
                .when()
                .get( url);
        Assert.assertEquals(expectedStatus,response.getStatusCode());
        response.then().log().all();
        return response;
    }

    /**
     * crate alphaNumeric String
     * @return
     */
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

    /**
     * create random string
     * @return
     */
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

    /**
     *Assertion for error message
     * @param response
     * @param errorMessages
     */
    public static void assertionErrorMessage(Response response, Object errorMessages) {
            if (response.statusCode() != 404) {
                JsonPath jsonPath = response.jsonPath();
                Assert.assertEquals(jsonPath.get("message"), errorMessages);
            }
            else{
                Assert.assertEquals(" ", errorMessages);
            }
    }
    /**
     * get api call.pass url and expectedStatus.
     * @param URL
     * @param expectedStatus
     * @return
     */
    public static Response getApiCall(String URL,Object expectedStatus){
        Response response= RestAssured.given()
                .when()
                .get( URL);
        Assert.assertEquals(expectedStatus,response.getStatusCode());
        response.then().log().all();
        return response;
    }

    /**
     * delete api call using
     * @param url
     * @param expectedStatus
     * @return
     */
    public static Response deleteApiCall(Object url,Object expectedStatus){
        Response response = RestAssured.given()
                .when()
                .delete((String) url);
        Assert.assertEquals(expectedStatus,response.getStatusCode());
        response.then().log().all();
        return response;
    }

    /**
     * @param headersList
     * @param url
     * @param expectedStatus
     * @return
     */
    public static Response deleteApiCall(Map headersList,String url,Object expectedStatus){
        Response response = RestAssured.given()
                .headers(headersList)
                .when()
                .delete( url);
        Assert.assertEquals(expectedStatus,response.getStatusCode());
        response.then().log().all();
        return response;
    }

    /**
     * put api call
     * @param headersList
     * @param url
     * @param payload
     * @param expectedStatus
     * @return
     */
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

    /**
     * generate token with hashmap
     * @return
     */
    public static Map tokenMap(){
        Map<String, String> token = new HashMap();
        token.put("Authorization","Bearer " + DataPath.TOKEN_FOR_ZOPPING);
        return token;
    }

    /**
     * @param response
     * @param errorMessages
     */
    public static void assertionErrorMessages(Response response, Object errorMessages) {
            JsonPath jsonPath = response.jsonPath();
            Assert.assertEquals(jsonPath.get("message"), errorMessages);
        }

}
