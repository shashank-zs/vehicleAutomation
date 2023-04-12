package Assignment4;

import io.restassured.response.Response;
import org.example.utils.ExcelReader;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.example.utils.DataPath.*;
import static org.example.utils.Generic.*;

public class GetSingleProduct {
    /**
     * dataProvider to fetch data from excel sheet for positive test cases
     * @return
     * @throws IOException
     */
    @DataProvider(name = "PositiveDataProvider")
    public static Object[][] dataProviderPositiveGetSingleProduct() throws IOException {
        return ExcelReader.getData(DATAPATH_FOR_ASSIGNMENT4_EXCEL_FILE,SHEETNAME_FOR_GET_POSITIVE_SINGLE_PRODUCT_SHEET);
    }
    /**
     * get api call. method to run Positive test cases Single Products
     * @param testCase
     * @param url
     * @param expectedStatus
     */
    @Test(dataProvider = "PositiveDataProvider")
    public void getSingleProductPositive(String testCase,String url ,Object id,Object expectedStatus){
        System.out.println(url+id);
        Response response=getApiCall(url+id,expectedStatus);
        genericAssertionWithResponse( response,  id,"id");

    }
    /**
     * dataProvider to fetch data from excel sheet for negative test cases
     * @return
     * @throws IOException
     */
    @DataProvider(name = "NegativeDataProvider")
    public static Object[][] dataProviderNegativeGetSingleProduct() throws IOException {
        return ExcelReader.getData(DATAPATH_FOR_ASSIGNMENT4_EXCEL_FILE,SHEETNAME_FOR_GET_NEGATIVE_SINGLE_PRODUCT_SHEET);
    }
    /**
     * get api call. method to run Negative test cases Single Products
     * @param testCase
     * @param url
     * @param expectedStatus
     */
    @Test(dataProvider = "NegativeDataProvider")
    public void getSingleProductNegative(String testCase,String url,Object id,Object expectedStatus,Object errorMessages){
        System.out.println(url+id);
        Response response =getApiCall(url+id,expectedStatus);
        assertionErrorMessage(response,errorMessages);
    }
}
