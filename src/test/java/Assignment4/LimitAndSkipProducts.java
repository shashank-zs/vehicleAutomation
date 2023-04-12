package Assignment4;

import io.restassured.response.Response;
import org.example.utils.ExcelReader;
import org.json.simple.parser.ParseException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.example.helper.HelperAssignment4.limitAndSkipAssertion;
import static org.example.helper.HelperAssignment4.queriesIntoMap;
import static org.example.utils.DataPath.*;
import static org.example.utils.Generic.assertionErrorMessage;
import static org.example.utils.Generic.getApiCall;

public class LimitAndSkipProducts {
    /**
     * dataProvider to fetch data from excel sheet for positive test cases
     * @return
     * @throws IOException
     */
    @DataProvider(name = "PositiveDataProvider")
    public static Object[][] dataProviderPositiveLimitAndSkipProduct() throws IOException {
        return ExcelReader.getData(DATAPATH_FOR_ASSIGNMENT4_EXCEL_FILE,SHEETNAME_FOR_GET_POSITIVE_LIMIT_AND_SKIP_SHEET);
    }
    /**
     * get api call. method to run Positive test cases search Products
     * @param testCase
     * @param url
     * @param expectedStatus
     */
    @Test(dataProvider = "PositiveDataProvider")
    public void LimitAndSkipProductPositive(String testCase,String url ,String limit,String skip,String select,String select2,Object expectedStatus) {
        Map queryData =queriesIntoMap(limit,skip,select,select2);
        Response response=getApiCall(url,queryData,expectedStatus);
        limitAndSkipAssertion(response, limit,skip);
    }
    /**
     * dataProvider to fetch data from excel sheet for negative test cases
     * @return
     * @throws IOException
     */
    @DataProvider(name = "NegativeDataProvider")
    public static Object[][] dataProviderNegativeLimitAndSkipProduct() throws IOException {
        return ExcelReader.getData(DATAPATH_FOR_ASSIGNMENT4_EXCEL_FILE,SHEETNAME_FOR_GET_NEGATIVE_LIMIT_AND_SKIP_SHEET);
    }
    /**
     * get api call. method to run Negative test cases search Products
     * @param testCase
     * @param url
     * @param expectedStatus
     */
    @Test(dataProvider = "NegativeDataProvider")
    public void LimitAndSkipProductNegative(String testCase,String url ,String limit,String skip,String select,String select2,Object expectedStatus,Object errorMessages){
        Map queryData =queriesIntoMap(limit,skip,select,select2);
        Response response=getApiCall(url,queryData,expectedStatus);
        assertionErrorMessage(response,errorMessages);
    }
}
