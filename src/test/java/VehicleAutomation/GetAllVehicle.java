package VehicleAutomation;

import io.restassured.response.Response;
import org.example.utils.ExcelReader;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Map;

import static org.example.helper.HelperVehicle.AssertionGetAllVehicle;
import static org.example.utils.DataPath.*;
import static org.example.utils.Generic.*;

public class GetAllVehicle {
    @DataProvider(name = "PositiveDataProvider")
    public Object[][] DataProviderPositivegetAllVehicle() throws IOException {
        return ExcelReader.getData(DATAPATH_FOR_VEHICLE_EXCEL_FILE, SHEETNAME_FOR_GET_ALL_POSITIVE_VEHICLE_EXCEL_SHEET);
    }

    @Test(dataProvider = "PositiveDataProvider")
    public void GetVehiclePositiveTestCases(Object testCase, String url, Object storeId,Object expectedStatus) {
        Map token = tokenMap();
        Response response = getApiCall(token,  url,"storeId",storeId,expectedStatus);
        AssertionGetAllVehicle(response, (Integer) storeId);

    }
    @DataProvider(name = "NegativeDataProvider")
    public Object[][] DataProviderNegativegetAllVehicle() throws IOException {
        return ExcelReader.getData(DATAPATH_FOR_VEHICLE_EXCEL_FILE, SHEETNAME_FOR_GET_ALL_NEGATIVE_VEHICLE_EXCEL_SHEET);
    }

    @Test(dataProvider = "NegativeDataProvider")
    public void GetVehicleNegativeTestCases(Object testCase, String url, Object storeId,Object expectedStatus,Object errorMessages) {
        Map token = tokenMap();
        Response response = getApiCall(token,  url,"storeId",storeId,expectedStatus);
        assertionErrorMessage(response,errorMessages);

    }
}

