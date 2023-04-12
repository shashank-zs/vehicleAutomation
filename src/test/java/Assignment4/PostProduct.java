package Assignment4;

import io.restassured.response.Response;
import org.example.utils.ExcelReader;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.example.pojo.JsonFromPojoPostProduct.createJsonPostProduct;
import static org.example.pojo.JsonFromPojoVehicle.createJsonAuth;
import static org.example.utils.DataPath.*;
import static org.example.utils.Generic.*;

public class PostProduct {
    /**
     * dataProvider to fetch data from excel sheet for positive test cases
     * @return
     * @throws IOException
     */    @DataProvider(name = "PositiveDataProvider")
    public Object[][] dataProviderPositivePostProduct() throws IOException {
        return ExcelReader.getData(DATAPATH_FOR_ASSIGNMENT4_EXCEL_FILE,SHEETNAME_FOR_POST_POSITIVE__SHEET);
    }
    /**
     * Post api call. method to run positive test cases for post Product
     * @param testCase
     * @param title
     * @param price
     * @param expectedStatus
     */
    @Test(dataProvider = "PositiveDataProvider")
    public void positivePostProduct(Object testCase,Object title,Object price,Object expectedStatus){
        String payload = createJsonPostProduct(title,price);
        Response response= postApiCall(ADD_PRODUCT_URL,payload,expectedStatus);
        genericAssertionWithResponse( response,title,"title");
        genericAssertionWithResponse( response,price,"price");

    }
    /**
     * dataProvider to fetch data from excel sheet for negative test cases
     * @return
     * @throws IOException
     */    @DataProvider(name = "NegativeDataProvider")
    public Object[][] dataProviderNegativePostProduct() throws IOException {
        return ExcelReader.getData(DATAPATH_FOR_ASSIGNMENT4_EXCEL_FILE,SHEETNAME_FOR_POST_NEGATIVE__SHEET);
    }
    /**
     * Post api call. method to run negative test cases for post product
     * @param testCase
     * @param title
     * @param price
     * @param expectedStatus
     */
    @Test(dataProvider = "NegativeDataProvider")
    public void negativePostProduct(Object testCase,Object title,Object price,Object expectedStatus){
        String payload = createJsonPostProduct(title,price);

        Response response=postApiCall(ADD_PRODUCT_URL,payload,expectedStatus);
    }

}
