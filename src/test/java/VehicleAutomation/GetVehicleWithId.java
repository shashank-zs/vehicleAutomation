package VehicleAutomation;

import io.restassured.response.Response;
import org.example.utils.ExcelReader;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Map;

import static org.example.helper.HelperVehicle.AssertionGetVehicle;
import static org.example.utils.DataPath.*;
import static org.example.utils.Generic.*;

public class GetVehicleWithId {
    @DataProvider(name = "PositiveDataProvider")
    public Object[][] DataProviderPositiveGetVehicle() throws IOException {
        return ExcelReader.getData(DATAPATH_FOR_VEHICLE_EXCEL_FILE, SHEETNAME_FOR_GET_POSITIVE_VEHICLE_EXCEL_SHEET);
    }

    @Test(dataProvider = "PositiveDataProvider")
    public void GetVehiclePositiveTestCases(Object testCase, String url,Object id, Object storeId,Object expectedStatus) {
        Map token = tokenMap();
        url=url+id;
        Response response = getApiCall(token, url,"storeId",storeId,expectedStatus);
        AssertionGetVehicle(response, (Integer) storeId);

    }
    @DataProvider(name = "NegativeDataProvider")
    public Object[][] DataProviderNegativeGetVehicle() throws IOException {
        return ExcelReader.getData(DATAPATH_FOR_VEHICLE_EXCEL_FILE, SHEETNAME_FOR_GET_NEGATIVE_VEHICLE_EXCEL_SHEET);
    }

    @Test(dataProvider = "NegativeDataProvider")
    public void GetVehicleNegativeTestCases(Object testCase, String url, Object id,Object storeId,Object expectedStatus,Object errorMessages) {
        Map token = tokenMap();
        url=url+id;
        Response response = getApiCall(token,  url,"storeId",storeId,expectedStatus);
        assertionErrorMessage(response,errorMessages);

    }
}
