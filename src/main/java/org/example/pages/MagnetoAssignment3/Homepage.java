package org.example.pages.MagnetoAssignment3;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class Homepage  {
      WebDriver driver;
    public Homepage (WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy (css ="a[href=\"https://magento.softwaretestingboard.com/customer/account/create/\"]" )
    public WebElement CreateAccount;

    public  void homepageMagneto(){


        CreateAccount.click();
        LogIn login = new LogIn(driver);
        login.loginPage();


    }


}
