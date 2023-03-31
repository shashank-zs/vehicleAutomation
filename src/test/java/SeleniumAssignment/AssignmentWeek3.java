package SeleniumAssignment;

import org.example.pages.MagnetoAssignment3.Homepage;
import org.example.utils.WebDriverUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import static org.example.utils.DataPath.BASE_URL_MAGNETO;

public class AssignmentWeek3   {
    @Test 
    public void main(){
        WebDriverUtils webDriver= new WebDriverUtils();
        webDriver.browserOpen();
        WebDriver driver = webDriver.driver;
        driver.get(BASE_URL_MAGNETO);
        Homepage homepage = new Homepage(driver);
        homepage.homepageMagneto();
    }
}
