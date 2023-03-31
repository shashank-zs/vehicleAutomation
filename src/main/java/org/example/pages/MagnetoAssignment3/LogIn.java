package org.example.pages.MagnetoAssignment3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.example.utils.DataPath.EMAIL;
import static org.example.utils.DataPath.PASSWORD;


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

    @FindBy (css ="button[data-action=\"customer-menu-toggle\"]" )
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


    public void loginPage(){
        firstname.sendKeys("shashank");
        lastname.sendKeys("sdsdsd");
        email_address.sendKeys("sdhffsjjdhs@gmasidf.com");
        password.sendKeys("sfsdfsfd@1");
        passwordConfirmation.sendKeys("sfsdfsfd@1");
        Submit.click();
        logMenu.click();
        logOut.click();
        SignIn.click();
        inputEmail.sendKeys(EMAIL);
        inputPassword.sendKeys(PASSWORD);
        clickLogIn.click();

    }
}
