package org.example.pages.MagnetoAssignment3;

import org.example.helper.MagnetoAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;

public class CheckoutPage {
    WebDriver driver;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(css = "input[name=\"company\"]")
    public WebElement company;
    @FindBy(css = "input[name=\"street[0]\"]")
    public WebElement street;
    @FindBy(css = "select[name=\"region_id\"]")
    public WebElement selectRegion;
    @FindBy(css = "select[name=\"country_id\"]")
    public WebElement selectCountry;
    @FindBy(css = "input[name=\"postcode\"] ")
    public WebElement postCode;
    @FindBy(css = "input[name=\"city\"] ")
    public WebElement city;
    @FindBy(css = "input[name=\"telephone\"]")
    public WebElement telephone;
    @FindBy(css = "span[data-bind=\"i18n: 'Next'\"]")
    public WebElement next;
    @FindBy(css = "button[class=\"action primary checkout\"]")
    public WebElement placeOrder;
    @FindBy(css = "td[id=\"label_method_bestway_tablerate\"]")
    public WebElement shipType;
    @FindBy(css = "div[class=\"billing-address-details\"]")
    public WebElement shipDetails;



    public void checkout(String companyName,String streetname ,String country,String region,String cityName,Object postCodeCity,Object telephoneNum) throws InterruptedException, AWTException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20000));
        MagnetoAssertions assertion = new MagnetoAssertions(driver);
        wait.until(ExpectedConditions.elementToBeClickable(next));
        assertion.assertionCheckout();

        company.sendKeys(companyName);
        street.sendKeys(streetname);
        selectCountry.sendKeys(country);
        selectRegion.sendKeys(region);
        city.sendKeys(cityName);
        postCode.sendKeys(postCodeCity.toString());
        telephone.sendKeys(telephoneNum.toString());

        wait.until(ExpectedConditions.invisibilityOf( shipType));
        next.click();
        wait.until(ExpectedConditions.textToBePresentInElement(shipDetails, "shashank"));
        assertion.paymentPageAssertion();
        placeOrder.click();

    }
}
