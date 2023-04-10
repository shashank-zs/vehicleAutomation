package org.example.pages.MagnetoAssignment3;

import org.example.helper.MagnetoAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.example.utils.Generic.generateRandomEmail;


public class LogIn {
    WebDriver driver;
    public LogIn(WebDriver driver){this.driver=driver;
        PageFactory.initElements(driver,this);}

    @FindBy (css ="input[id=\"firstname\"] " )
    public WebElement firstname;
    @FindBy (css ="input[id=\"lastname\"] " )
    public WebElement lastname;
    @FindBy (css ="input[id=\"email_address\"]" )
    public WebElement email_address;
    @FindBy (css ="input[id=\"password\"] " )
    public WebElement password;
    @FindBy (css ="input[id=\"password-confirmation\"]" )
    public WebElement passwordConfirmation ;
    @FindBy (css ="button[class=\"action submit primary\"]" )
    public WebElement Submit;

    @FindBy (css ="button[class=\"action switch\"]" )
    public WebElement logMenu;
    @FindBy (css =" a[href=\"https://magento.softwaretestingboard.com/customer/account/logout/\"]" )
    public WebElement logOut;

    @FindBy (css ="li[class=\"authorization-link\"]" )
    public WebElement SignIn;
    @FindBy(css = "input[name=\"login[username]\"]")
    public WebElement inputEmail ;

    @FindBy(css = "input[name=\"login[password]\"]")
    public WebElement inputPassword;

    @FindBy(css ="button[class=\"action login primary\"]" )
    public WebElement clickLogIn ;


    public void loginPage(String firstnam,String lastnam ,String pass)  {


        MagnetoAssertions assertion = new MagnetoAssertions(driver);
        String email =generateRandomEmail();
        firstname.sendKeys(firstnam);
        lastname.sendKeys(lastnam);
        email_address.sendKeys(email);
        password.sendKeys(pass);
        passwordConfirmation.sendKeys(pass);
        Submit.click();

        logMenu.isDisplayed();
        logMenu.click();
        logOut.click();

        SignIn.click();
        assertion.assertionLogin();
        inputEmail.sendKeys(email);
        inputPassword.sendKeys(pass);
        clickLogIn.click();

    }
}
