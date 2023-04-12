package Assignment4;

import io.restassured.response.Response;
import org.example.utils.ExcelReader;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.example.utils.DataPath.*;
import static org.example.utils.Generic.assertionErrorMessage;
import static org.example.utils.Generic.getApiCall;

public class SearchProduct {
    /**
     * dataProvider to fetch data from excel sheet for positive test cases
     * @return
     * @throws IOException
     */
    @DataProvider(name = "PositiveDataProvider")
    public static Object[][] dataProviderPositiveSearchProduct() throws IOException {
        return ExcelReader.getData(DATAPATH_FOR_ASSIGNMENT4_EXCEL_FILE,SHEETNAME_FOR_GET_POSITIVE_SEARCH_SHEET);
    }
    /**
     * get api call. method to run Positive test cases search Products
     * @param testCase
     * @param url
     * @param expectedStatus
     */
    @Test(dataProvider = "PositiveDataProvider")
    public void SearchProductPositive(String testCase,String url ,Object q,Object expectedStatus){
        System.out.println(url+"/q="+q);
        getApiCall(url,"q",q,expectedStatus);
    }
    /**
     * dataProvider to fetch data from excel sheet for negative test cases
     * @return
     * @throws IOException
     */
    @DataProvider(name = "NegativeDataProvider")
    public static Object[][] dataProviderNegativeSearchProduct() throws IOException {
        return ExcelReader.getData(DATAPATH_FOR_ASSIGNMENT4_EXCEL_FILE,SHEETNAME_FOR_GET_NEGATIVE_SEARCH_EXCEL_SHEET);
    }
    /**
     * get api call. method to run Negative test cases search Products
     * @param testCase
     * @param url
     * @param expectedStatus
     */
    @Test(dataProvider = "NegativeDataProvider")
    public void SearchProductNegative(String testCase,String url ,Object q,Object expectedStatus){
        System.out.println(url+"/q="+q);
        getApiCall(url,"q",q,expectedStatus);
    }
}
