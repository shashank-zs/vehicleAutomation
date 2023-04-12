package Assignment4;

import io.restassured.response.Response;
import org.example.utils.ExcelReader;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.example.pojo.JsonFromPojoPostProduct.createJsonPostProduct;
import static org.example.utils.DataPath.*;
import static org.example.utils.DataPath.ADD_PRODUCT_URL;
import static org.example.utils.Generic.*;

public class UpdateProduct {
    /**
     * dataProvider to fetch data from excel sheet for positive test cases
     * @return
     * @throws IOException
     */    @DataProvider(name = "PositiveDataProvider")
    public Object[][] dataProviderPositiveUpdateProduct() throws IOException {
        return ExcelReader.getData(DATAPATH_FOR_ASSIGNMENT4_EXCEL_FILE,SHEETNAME_FOR_PUT_POSITIVE_SHEET);
    }
    /**
     * Post api call. method to run positive test cases for Update Product
     * @param testCase
     * @param title
     * @param price
     * @param expectedStatus
     */
    @Test(dataProvider = "PositiveDataProvider")
    public void positiveUpdateProduct(Object testCase,Object id,Object title,Object price,Object expectedStatus){
        String payload = createJsonPostProduct(title,price);
        Response response= putApiCall(BASE_URL_PRODUCTS+id,payload,expectedStatus);
        genericAssertionWithResponse( response,title,"title");
        genericAssertionWithResponse( response,price,"price");

    }
    /**
     * dataProvider to fetch data from excel sheet for negative test cases
     * @return
     * @throws IOException
     */    @DataProvider(name = "NegativeDataProvider")
    public Object[][] dataProviderNegativeUpdateProduct() throws IOException {
        return ExcelReader.getData(DATAPATH_FOR_ASSIGNMENT4_EXCEL_FILE,SHEETNAME_FOR_PUT_NEGATIVE_SHEET);
    }
    /**
     * Post api call. method to run negative test cases for  Update product
     * @param testCase
     * @param title
     * @param price
     * @param expectedStatus
     */
    @Test(dataProvider = "NegativeDataProvider")
    public void negativeUpdateProduct(Object testCase,Object id,Object title,Object price,Object expectedStatus,Object errorMessage){
        String payload = createJsonPostProduct(title,price);
        Response response= putApiCall(BASE_URL_PRODUCTS+id,payload,expectedStatus);
        assertionErrorMessages(response,errorMessage);
    }
}
