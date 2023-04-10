package org.example.helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class MagnetoAssertions {
    WebDriver driver;
    public MagnetoAssertions (WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(css ="a[id=\"ui-id-3\"]>span" )
    public WebElement whatsNew ;
    @FindBy(xpath ="(//a[@id=\"ui-id-4\"]/span)[2]" )
    public WebElement women ;
    @FindBy(xpath ="(//a[@id=\"ui-id-5\"]/span)[2]" )
    public WebElement men ;
    @FindBy(xpath ="(//a[@id=\"ui-id-6\"]/span)[2]" )
    public WebElement gear ;
    @FindBy(xpath ="(//a[@id=\"ui-id-7\"]/span)[2]" )
    public WebElement training ;
    @FindBy(css ="a[id=\"ui-id-8\"]>span" )
    public WebElement sale ;
    @FindBy (css ="a[href=\"https://magento.softwaretestingboard.com/customer/account/create/\"]" )
    public WebElement CreateAccount;
    @FindBy (css ="input[id=\"search\"]" )
    public WebElement search;
    @FindBy (css ="button[class=\"action submit primary\"]" )
    public WebElement submit;
    @FindBy (css ="span[data-ui-id=\"page-title-wrapper\"]" )
    public WebElement createAccount;
    @FindBy (css ="div[for=\"email_address\"]" )
    public WebElement email;
    @FindBy (css ="div[for=\"password\"]" )
    public WebElement password;
    @FindBy (css ="div[for=\"lastname\"]" )
    public WebElement lastname;
    @FindBy (css ="div[for=\"firstname\"]" )
    public WebElement firstname;
    @FindBy (css ="div[ for=\"password-confirmation\"]" )
    public WebElement confirmation;
    @FindBy(css ="button[class=\"action login primary\"]" )
    public WebElement clickLogIn ;
    @FindBy (css ="span[data-ui-id=\"page-title-wrapper\"]" )
    public WebElement SignInText;
    @FindBy (css ="div[for=\"email\"]" )
    public WebElement SignInEmail;
    @FindBy (css ="div[for=\"pass\"]" )
    public WebElement SignInPass;
    @FindBy (css ="div[data-bind=\"i18n: 'Shipping Address'\"]" )
    public WebElement shipping;
    @FindBy(css = "div[class=\"title\"]>strong")
    public WebElement itemInCart;
    @FindBy (css ="span[data-th=\"Cart Subtotal\"]" )
    public WebElement cartTotal;

    @FindBy(xpath = "(//span[@class=\"cart-price\"]/span)[1]")
    public WebElement item1Price;
    @FindBy(xpath = "(//span[@class=\"cart-price\"]/span)[2]")
    public WebElement item2Price;
    @FindBy(xpath = "(//span[@class=\"cart-price\"]/span)[3]")
    public WebElement item3Price;
    @FindBy(xpath = "(//span[@class=\"cart-price\"]/span)[4]")
    public WebElement item4Price;


    public  void assertionHomepage(){
        Assert.assertEquals(driver.getTitle(),"Home Page");
        Assert.assertEquals(whatsNew.getText(),"What's New");
        Assert.assertEquals(women.getText(),"Women");
        Assert.assertEquals(men.getText(),"Men");
        Assert.assertEquals(gear.getText(),"Gear");
        Assert.assertEquals(training.getText(),"Training");
        Assert.assertEquals(sale.getText(),"Sale");
        Assert.assertEquals(CreateAccount.getText(),"Create an Account");
        search.isDisplayed();
    }
    public void assertionCreateAccount(){
        Assert.assertEquals(driver.getTitle(),"Create New Customer Account");
        submit.isDisplayed();
        Assert.assertEquals(createAccount.getText(),"Create New Customer Account");
        submit.click();
        Assert.assertEquals(email.getText(),"This is a required field.");
        Assert.assertEquals(password.getText(),"This is a required field.");
        Assert.assertEquals(firstname.getText(),"This is a required field.");
        Assert.assertEquals(lastname.getText(),"This is a required field.");
        Assert.assertEquals(confirmation.getText(),"This is a required field.");
    }
    public void assertionLogin(){
        Assert.assertEquals(driver.getTitle(),"Customer Login");
        clickLogIn.isDisplayed();
        Assert.assertEquals(SignInText.getText(),"Customer Login");
        clickLogIn.click();
        Assert.assertEquals(SignInEmail.getText(),"This is a required field.");
        Assert.assertEquals(SignInPass.getText(),"This is a required field.");
    }
    public void assertionCheckout() {
        Assert.assertEquals(driver.getTitle(), "Checkout");
        Assert.assertEquals(shipping.getText(),"Shipping Address");

    }
    public void paymentPageAssertion(){
        itemInCart.click();
        String item1=item1Price.getText().replaceAll("[^\\d]", "");
        int price1 = Integer.parseInt(item1);
        String item2=item2Price.getText().replaceAll("[^\\d]", "");
        int price2 = Integer.parseInt(item2);
        String item3=item3Price.getText().replaceAll("[^\\d]", "");
        int price3 = Integer.parseInt(item3);
        String item4=item4Price.getText().replaceAll("[^\\d]", "");
        int price4 = Integer.parseInt(item4);
        String item5=cartTotal.getText().replaceAll("[^\\d]", "");
        int totalprice = Integer.parseInt(item5);
        int expectedTotal= price1+price2+price3+price4;
        Assert.assertEquals(totalprice,expectedTotal);
    }

}
