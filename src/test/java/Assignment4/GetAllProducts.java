package Assignment4;

import org.example.utils.ExcelReader;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.example.utils.DataPath.*;
import static org.example.utils.Generic.getApiCall;

public class GetAllProducts {
    /**
     * dataProvider to fetch data from excel sheet for positive test cases
     * @return
     * @throws IOException
     */    @DataProvider(name = "PositiveDataProvider")
    public static Object[][] dataProviderPositiveGetAllProducts() throws IOException {
        return ExcelReader.getData(DATAPATH_FOR_ASSIGNMENT4_EXCEL_FILE,SHEETNAME_FOR_GET_ALL_POSITIVE_PRODUCTS_SHEET);
    }
    /**
     * get api call. method to run Positive test cases getAll Products
     * @param testCase
     * @param url
     * @param expectedStatus
     */
    @Test(dataProvider = "PositiveDataProvider")
    public void getAllProductsPositive(String testCase,String url,Object expectedStatus){
        System.out.println(url);
        getApiCall(url,expectedStatus);
    }
    /**
     * dataProvider to fetch data from excel sheet for negative test cases
     * @return
     * @throws IOException
     */    @DataProvider(name = "NegativeDataProvider")
    public static Object[][] dataProviderNegativeGetAllProducts() throws IOException {
        return ExcelReader.getData(DATAPATH_FOR_ASSIGNMENT4_EXCEL_FILE,SHEETNAME_FOR_GET_ALL_NEGATIVE_PRODUCTS_SHEET);
    }
    /**
     * get api call. method to run Negative test cases getAll Products
     * @param testCase
     * @param url
     * @param expectedStatus
     */
    @Test(dataProvider = "NegativeDataProvider")
    public void getAllProductsNegative(String testCase,String url,Object expectedStatus){
        System.out.println(url);
        getApiCall(url,expectedStatus);
    }
}
