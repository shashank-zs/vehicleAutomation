package org.example.pages.MagnetoAssignment3;


import org.example.helper.MagnetoAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;


public class Homepage  {
      WebDriver driver;
    public Homepage (WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy (css ="a[href=\"https://magento.softwaretestingboard.com/customer/account/create/\"]" )
    public WebElement CreateAccount;
    @FindBy (css ="a[id=\"ui-id-6\"]" )
    public WebElement gear;

    @FindBy (css ="a[id=\"ui-id-25\"]" )
    public WebElement bags ;
    @FindBy (css ="span[class=\"logged-in\"]" )
    public WebElement welcome;

    public  void homepageMagneto(String firstname,String lastname ,String password)  {
        MagnetoAssertions assertion = new MagnetoAssertions(driver);
        assertion.assertionHomepage();
        CreateAccount.click();
        assertion.assertionCreateAccount();
        LogIn login = new LogIn(driver);
        login.loginPage( firstname, lastname , password);
        Actions action = new Actions(driver);
        action.moveToElement(gear).perform();
        bags.click();
    }
}
