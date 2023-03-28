package VehicleAutomation;

import io.restassured.response.Response;
import org.example.utils.ExcelReader;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Map;

import static org.example.helper.HelperVehicle.*;
import static org.example.utils.DataPath.*;
import static org.example.utils.DataPath.BASE_URL_VEHICLE;
import static org.example.utils.Generic.*;

public class PutVehicle {
    @DataProvider(name = "PositiveDataProvider")
    public Object[][] DataProviderPositivePostVehicle() throws IOException {
        return ExcelReader.getData(DATAPATH_FOR_VEHICLE_EXCEL_FILE,SHEETNAME_FOR_PUT_POSITIVE_VEHICLE_EXCEL_SHEET);
    }
    @Test(dataProvider = "PositiveDataProvider")
    public void PutVehiclePositiveTestCases(Object testCase,Object vehicleNumber,Object type,Object vendorId,Object storeId,Object expectedStatusCode){
        String postPayload=payloadVehicle(vehicleNumber, type , vendorId, storeId);
        String putPayload=payloadVehicle(vehicleNumber, type , vendorId, storeId);
        Map token =tokenMap();
        String id=getIdPost(token,postPayload,expectedStatusCode);
        String PutURL=BASE_URL_VEHICLE+"/"+id;
        Response response =putApiCall(token,PutURL,putPayload,expectedStatusCode);
        VehicleAssertions(response,vehicleNumber, type , vendorId, storeId,putPayload);
    }
    @DataProvider(name = "negativeDataProvider")
    public Object[][] DataProviderNegativePostVehicle() throws IOException {
        return ExcelReader.getData(DATAPATH_FOR_VEHICLE_EXCEL_FILE,SHEETNAME_FOR_PUT_NEGATIVE_VEHICLE_EXCEL_SHEET);
    }
    @Test(dataProvider = "negativeDataProvider")
    public void PutVehicleNegativeTestCases(Object testCase,Object vehicleNumber,Object type,Object vendorId,Object storeId,Object expectedStatusCode,Object errorMessages){
        String putPayload=payloadVehicle(vehicleNumber, type , vendorId, storeId);
        Map token =tokenMap();
        Response response =putApiCall(token,PUT_URL_VEHICLE,putPayload,expectedStatusCode);
        assertionErrorMessage(response,errorMessages);
    }
}
