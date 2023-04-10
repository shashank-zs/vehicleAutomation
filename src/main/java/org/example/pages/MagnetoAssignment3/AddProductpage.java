package org.example.pages.MagnetoAssignment3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AddProductpage {
    WebDriver driver;
    public AddProductpage (WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }


    @FindBy (xpath ="(//button[@class=\"action tocart primary\"])[2]" )
    public WebElement addCart1;
    @FindBy (xpath ="(//a[@class=\"action towishlist\"])[2]" )
    public WebElement wishlist1;
    @FindBy (xpath ="(//a[@class=\"action towishlist\"])[7]" )
    public WebElement wishlist2;
    @FindBy (xpath ="(//a[@class=\"action towishlist\"])[11]" )
    public WebElement wishlist3;

    @FindBy (xpath ="(//button[@class=\"action tocart primary\"])[11]" )
    public WebElement addCart3;
    @FindBy (xpath ="(//button[@class=\"action tocart primary\"])[7]" )
    public WebElement addCart2;
    @FindBy (css ="a[href=\"https://magento.softwaretestingboard.com/overnight-duffle.html\"]" )
    public WebElement bag1;
    @FindBy (css ="a[href=\"https://magento.softwaretestingboard.com/wayfarer-messenger-bag.html\"]" )
    public WebElement bag3 ;
    @FindBy (css ="a[href=\"https://magento.softwaretestingboard.com/voyage-yoga-bag.html\"]" )
    public WebElement bag2;
    @FindBy (css ="a[class=\"modes-mode mode-list\"]" )
    public WebElement listView;
    @FindBy (css ="div[data-bind=\"html: $parent.prepareMessageForHtml(message.text)\"]" )
    public WebElement shoppingCart;

    @FindBy (css ="a[id=\"ui-id-5\"]" )
    public WebElement men;
    @FindBy (css ="a[id=\"ui-id-17\"]" )
    public WebElement tops ;
    @FindBy (css ="a[id=\"ui-id-20\"]" )
    public WebElement hoodies ;
    @FindBy (xpath ="(//div[@id=\"option-label-size-143-item-168\"])[3]" )
    public WebElement size;
    @FindBy (xpath ="(//div[@id=\"option-label-color-93-item-58\"])[2]" )
    public WebElement colour;
    @FindBy (css ="a[href=\"https://magento.softwaretestingboard.com/grayson-crewneck-sweatshirt.html\"]" )
    public WebElement graysonHoodie ;
    @FindBy (xpath ="(//button[@title=\"Add to Cart\"])[3]" )
    public WebElement addCart4;
    @FindBy (css ="a[href=\"https://magento.softwaretestingboard.com/checkout/cart/\"]" )
    public WebElement goToCart ;
    @FindBy (css ="button[id=\"top-cart-btn-checkout\"]" )
    public WebElement clickCheckout ;
    public void addCart(WebElement product,WebElement WishList,WebElement addCart,WebElement Shopping,String msg){
        Actions action = new Actions(driver);
        action.moveToElement(product).perform();
        WishList.isDisplayed();
        action.moveToElement(addCart).perform();
        addCart.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25000));
        wait.until(ExpectedConditions.textToBePresentInElement(Shopping, msg));

    }


    public void addProducts()  {
        Actions action = new Actions(driver);

        addCart(bag1,wishlist1,addCart1,shoppingCart,"You added Overnight Duffle to your shopping cart.");
        addCart(bag2,wishlist2,addCart2,shoppingCart,"You added Voyage Yoga Bag to your shopping cart.");
        addCart(bag3,wishlist3,addCart3,shoppingCart,"You added Wayfarer Messenger Bag to your shopping cart.");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25000));

        listView.click();
        action.moveToElement(men).perform();
        action.moveToElement(tops).perform();
        hoodies.click();

        size.click();
        colour.click();
        action.moveToElement(graysonHoodie).perform();
        addCart4.click();
        wait.until(ExpectedConditions.textToBePresentInElement(shoppingCart, "You added Grayson Crewneck Sweatshirt to your shopping cart."));
        goToCart.click();
        clickCheckout.click();


    }
}
