package Assignment4;

import io.restassured.response.Response;
import org.example.utils.ExcelReader;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.example.pojo.JsonFromPojoVehicle.createJsonAuth;
import static org.example.utils.DataPath.*;
import static org.example.utils.Generic.*;

public class PostAuth {
    /**
     * dataProvider to fetch data from excel sheet for positive test cases
     * @return
     * @throws IOException
     */    @DataProvider(name = "PositiveDataProvider")
    public Object[][] dataProviderPositivePostAuth() throws IOException {
        return ExcelReader.getData(DATAPATH_FOR_ASSIGNMENT4_EXCEL_FILE,SHEETNAME_FOR_POST_POSITIVE_AUTH_SHEET);
    }
    /**
     * Post api call. method to run positive test cases for post auth
     * @param testCase
     * @param username
     * @param password
     * @param expectedStatus
     */
    @Test(dataProvider = "PositiveDataProvider")
    public void positivePostAuth(Object testCase,Object username,Object password,Object expectedStatus){
        String payload = createJsonAuth(username,password);
        Response response= postApiCall(AUTH_URL_DUMMY_JSON,payload,expectedStatus);
        genericAssertionWithResponse( response,  username,"username");
    }
    /**
     * dataProvider to fetch data from excel sheet for negative test cases
     * @return
     * @throws IOException
     */    @DataProvider(name = "NegativeDataProvider")
    public Object[][] dataProviderNegativePostAuth() throws IOException {
        return ExcelReader.getData(DATAPATH_FOR_ASSIGNMENT4_EXCEL_FILE,SHEETNAME_FOR_POST_NEGATIVE_AUTH_SHEET);
    }
    /**
     * Post api call. method to run negative test cases for post auth
     * @param testCase
     * @param url
     * @param username
     * @param password
     * @param expectedStatus
     */
    @Test(dataProvider = "NegativeDataProvider")
    public void negativePostAuth(Object testCase,String url,Object username,Object password,Object expectedStatus,Object errorMessages){
        String payload = createJsonAuth(username,password);
        System.out.println(url);
        Response response=postApiCall(url,payload,expectedStatus);
        assertionErrorMessage(response,errorMessages);
    }
}
