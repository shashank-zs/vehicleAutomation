package VehicleAutomation;

import io.restassured.response.Response;
import org.example.utils.ExcelReader;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Map;

import static org.example.helper.HelperVehicle.*;
import static org.example.utils.DataPath.*;
import static org.example.utils.Generic.*;

public class PostVehicle {
    @DataProvider(name = "PositiveDataProvider")
    public Object[][] DataProviderPositivePostVehicle() throws IOException {
        return ExcelReader.getData(DATAPATH_FOR_VEHICLE_EXCEL_FILE,SHEETNAME_FOR_POST_POSITIVE_VEHICLE_EXCEL_SHEET);
    }
    @Test(dataProvider = "PositiveDataProvider")
    public void PostVehiclePositiveTestCases(Object testCase,Object vehicleNumber,Object type,Object vendorId,Object storeId,Object expectedStatusCode){
        String payload=payloadVehicle(vehicleNumber, type , vendorId, storeId);
        Map token =tokenMap();
        Response response =postApiCall(token,BASE_URL_VEHICLE,payload,expectedStatusCode);
        VehicleAssertions(response,vehicleNumber, type , vendorId, storeId,payload);
    }
    @DataProvider(name = "negativeDataProvider")
    public Object[][] DataProviderNegativePostVehicle() throws IOException {
        return ExcelReader.getData(DATAPATH_FOR_VEHICLE_EXCEL_FILE,SHEETNAME_FOR_POST_NEGATIVE_VEHICLE_EXCEL_SHEET);
    }
    @Test(dataProvider = "negativeDataProvider")
    public void PostVehicleNegativeTestCases(Object testCase,Object vehicleNumber,Object type,Object vendorId,Object storeId,Object expectedStatusCode,Object errorMessages){
        String payload=payloadVehicle(vehicleNumber, type , vendorId, storeId);
        Map token =tokenMap();
        Response response =postApiCall(token,BASE_URL_VEHICLE,payload,expectedStatusCode);
        assertionErrorMessage(response,errorMessages);
    }
}
