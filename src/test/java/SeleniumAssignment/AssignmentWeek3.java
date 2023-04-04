package SeleniumAssignment;
import org.example.pages.MagnetoAssignment3.AddProductpage;
import org.example.pages.MagnetoAssignment3.CheckoutPage;
import org.example.pages.MagnetoAssignment3.Homepage;
import org.example.utils.ExcelReader;
import org.example.utils.WebDriverUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;

import static org.example.utils.DataPath.*;

public class AssignmentWeek3   {
    @DataProvider(name = "dataProvider")
    public Object[][] DataProviderForExtension() throws IOException {
        return ExcelReader.getData(PATH_EXCEL_ASS3, SHEETNAME_ASS3);
    }
    @Test (dataProvider = "dataProvider")
    public void main( String firstname,String lastname ,String password ,String company,String street ,String country,String region,String city,Object postCode,Object telephone) throws InterruptedException, AWTException {
        WebDriverUtils webDriver= new WebDriverUtils();
        webDriver.browserOpen();
        WebDriver driver = webDriver.driver;
        driver.get(BASE_URL_MAGNETO);

        Homepage homepage = new Homepage(driver);
        homepage.homepageMagneto(firstname,lastname,password);
        AddProductpage addproduct = new AddProductpage(driver);
        addproduct.addProducts();
        CheckoutPage payment =new CheckoutPage(driver);
        payment.checkout(company,street,country,region,city,postCode,telephone);

    }
}
