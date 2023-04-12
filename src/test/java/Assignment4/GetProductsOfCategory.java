package Assignment4;

import io.restassured.response.Response;
import org.example.utils.ExcelReader;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.example.utils.DataPath.*;
import static org.example.utils.Generic.genericAssertionWithResponse;
import static org.example.utils.Generic.getApiCall;

public class GetProductsOfCategory {
    /**
     * dataProvider to fetch data from excel sheet for positive test cases
     * @return
     * @throws IOException
     */    @DataProvider(name = "PositiveDataProvider")
    public static Object[][] dataProviderPositiveGetProductOfCategory() throws IOException {
        return ExcelReader.getData(DATAPATH_FOR_ASSIGNMENT4_EXCEL_FILE,SHEETNAME_FOR_GET_POSITIVE_PRODUCTS_OF_CATEGORY_SHEET);
    }
    /**
     * get api call. method to run Positive test cases get Product OF CATEGORY
     * @param testCase
     * @param url
     * @param expectedStatus
     */
    @Test(dataProvider = "PositiveDataProvider")
    public void getProductOfCategoryPositiveScenarios(String testCase,String url,String category,Object expectedStatus){
        System.out.println(url+category);
        Response response =getApiCall(url+category,expectedStatus);
        genericAssertionWithResponse( response,category,"products[0].category");

    }
    /**
     * dataProvider to fetch data from excel sheet for negative test cases
     * @return
     * @throws IOException
     */    @DataProvider(name = "NegativeDataProvider")
    public static Object[][] dataProviderNegativeGetProductOfCategory() throws IOException {
        return ExcelReader.getData(DATAPATH_FOR_ASSIGNMENT4_EXCEL_FILE,SHEETNAME_FOR_GET_NEGATIVE_PRODUCTS_OF_CATEGORY_SHEET);
    }
    /**
     * get api call. method to run Negative test cases get Product OF CATEGORY
     * @param testCase
     * @param url
     * @param expectedStatus
     */
    @Test(dataProvider = "NegativeDataProvider")
    public void getProductOfCategoryNegative(String testCase,String url,Object expectedStatus){
        System.out.println(url);
        getApiCall(url,expectedStatus);
    }
}
