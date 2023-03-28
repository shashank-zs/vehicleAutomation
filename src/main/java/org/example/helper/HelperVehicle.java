package org.example.helper;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import junit.framework.Assert;
import org.json.JSONObject;
import org.json.simple.JSONValue;

import java.util.Map;

import static org.example.pojo.JsonFromPojoVehicle.createJsonVehicle;
import static org.example.utils.DataPath.BASE_URL_VEHICLE;
import static org.example.utils.Generic.*;

public class HelperVehicle {
    public static String payloadVehicle(Object vehicleNumber, Object type, Object vendorId, Object storeId){
        String number= generateRandomString();
        String payload=null;
        if (vehicleNumber !=null && vehicleNumber.equals("random") ){
            payload =createJsonVehicle( number, type , vendorId, storeId);
        }
        else if (vehicleNumber !=null && vehicleNumber.equals("specialChar") ){
            String specialCh = number +"@";
            payload =createJsonVehicle( specialCh, type , vendorId, storeId);
        }
        else if (vehicleNumber !=null && vehicleNumber.equals("onlyString") ){
            String onlyString=generateRandomOnlyString();
            payload =createJsonVehicle( onlyString, type , vendorId, storeId);
        }
        else{
            payload =createJsonVehicle( vehicleNumber, type , vendorId, storeId);
        }

        return payload;
    }


    public static void VehicleAssertions(Response response,Object vehicleNumber,Object type,Object vendorId,Object storeId,String payload)
    {
        JsonPath jsonPath=response.jsonPath();
        String responseNumber=jsonPath.getString("data.vehicle.number");
        String responseVendor=jsonPath.getString("data.vehicle.vendorId");
        String responseStoreId=jsonPath.getString("data.vehicle.storeId");
        String responseType=jsonPath.getString("data.vehicle.type");
        JSONObject jsonObject = new JSONObject(payload);

            if (jsonObject.get("number") != null && responseNumber != null ) {
                Assert.assertEquals(responseNumber,jsonObject.get("number"));
            }
            if (vendorId != null && responseVendor != null ) {
                Assert.assertEquals(responseVendor,String.valueOf(vendorId));
            }
            if (storeId != null && responseStoreId != null ) {
                Assert.assertEquals(responseStoreId,String.valueOf(storeId));
            }
            if (type != null && responseType!=null) {
                Assert.assertEquals(responseType,type);
            }
    }
    public static  String getIdPost(Map token, String payload,Object expectedStatusCode){
        Response responsePost =postPutApiCall(token,BASE_URL_VEHICLE,payload,expectedStatusCode);
        JsonPath jsonPath=responsePost.jsonPath();
        int responseId=jsonPath.getInt("data.vehicle.id");
        return String.valueOf(responseId);
    }

    public static void AssertionGetAllVehicle(Response response,Integer storeId){
        JsonPath jsonPath=response.jsonPath();
        Integer responseStoreId=jsonPath.getInt("data.vehicle[0].storeId");
        Assert.assertEquals( storeId,responseStoreId);
    }

    public static void AssertionGetVehicle(Response response,Integer storeId){
        JsonPath jsonPath=response.jsonPath();
        Integer responseStoreId=jsonPath.getInt("data.vehicle.storeId");
        Assert.assertEquals( storeId,responseStoreId);
    }
}

