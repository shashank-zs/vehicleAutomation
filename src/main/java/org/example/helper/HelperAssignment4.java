package org.example.helper;

import io.restassured.response.Response;
import java.util.HashMap;
import java.util.Map;

import static org.example.utils.Generic.*;

public class HelperAssignment4 {

    /**
     * creating hasmap to pass multiple query params
     * @param limit
     * @param skip
     * @param select
     * @param select2
     * @return
     */
    public static Map queriesIntoMap(String limit, String skip, String select, String select2) {
        HashMap<String, String> queryData = new HashMap<>();
        String combinedSelect = select + "," + select2;
        queryData.put("limit", limit);
        queryData.put("skip", skip);
        queryData.put("select", combinedSelect);
        return queryData;
    }

    /**
     * compare limit and skip for assertion of limit in response
     * @param response
     * @param limit1
     * @param skip1
     */
    public static void limitAssertion(Response response,String limit1,String skip1){
        int limit = Integer.valueOf(limit1);
        int skip=Integer.valueOf(skip1);
        String actualLimit = getSingleActualResponseData(response, "limit");
        if(limit >100 && skip<=100) {
            genericAssertion(100 -skip , actualLimit);
        }
        else if(skip>100){
            genericAssertion(0 , actualLimit);
        }
        else if (limit  + skip <100){
            genericAssertion(limit , actualLimit);
        }
        else if (limit  + skip >100){
            genericAssertion(100 -skip , actualLimit);
        }
    }

    /**
     * assertion for limit and skip api
     * @param response
     * @param limit
     * @param skip
     */
    public static void limitAndSkipAssertion(Response response,String limit,String skip) {
        limitAssertion(response,limit,skip);
        genericAssertionWithResponse( response,  skip,"skip");

    }
}



