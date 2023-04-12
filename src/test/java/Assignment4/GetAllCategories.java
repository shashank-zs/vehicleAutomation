package Assignment4;

import org.example.utils.ExcelReader;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.example.utils.DataPath.*;
import static org.example.utils.Generic.getApiCall;

public class GetAllCategories {
    /**
     * dataProvider to fetch data from excel sheet for positive test cases
     * @return
     * @throws IOException
     */    @DataProvider(name = "PositiveDataProvider")
    public static Object[][] dataProviderPositiveGetAllCategories() throws IOException {
        return ExcelReader.getData(DATAPATH_FOR_ASSIGNMENT4_EXCEL_FILE,SHEETNAME_FOR_GET_POSITIVE_GET_ALL_CATEGORIES_SHEET);
    }
    /**
     * get api call. method to run Positive test cases getAll CATEGORIES
     * @param testCase
     * @param url
     * @param expectedStatus
     */
    @Test(dataProvider = "PositiveDataProvider")
    public void getAllCategoriesPositiveScenarios(String testCase,String url,Object expectedStatus){
        System.out.println(url);
        getApiCall(url,expectedStatus);
    }
    /**
     * dataProvider to fetch data from excel sheet for negative test cases
     * @return
     * @throws IOException
     */    @DataProvider(name = "NegativeDataProvider")
    public static Object[][] dataProviderNegativeGetAllCategories() throws IOException {
        return ExcelReader.getData(DATAPATH_FOR_ASSIGNMENT4_EXCEL_FILE,SHEETNAME_FOR_GET_NEGATIVE_GET_ALL_CATEGORIES_SHEET);
    }
    /**
     * get api call. method to run Negative test cases getAll CATEGORIES
     * @param testCase
     * @param url
     * @param expectedStatus
     */
    @Test(dataProvider = "NegativeDataProvider")
    public void getAllCategoriesNegativeScenarios(String testCase,String url,Object expectedStatus){
        System.out.println(url);
        getApiCall(url,expectedStatus);
    }
}
