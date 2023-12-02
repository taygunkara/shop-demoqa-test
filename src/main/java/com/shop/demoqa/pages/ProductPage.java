package com.shop.demoqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


// TODO ADD DOCS
public class ProductPage extends BasePage{
    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public static final By productName = By.xpath("//h1[@class='product_title entry-title']");
    public static final By colorSelection = By.xpath("//select[@id='pa_color']");
    public static final By mauveColor = By.xpath("//option[@value='mauve']");
    public static final By redColor = By.xpath("//option[@value='red']");
    public static final By sizeSelection = By.xpath("//select[@id='pa_size']");
    public static final By largeSize = By.xpath("//option[@value='large']");
    public static final By mediumSize = By.xpath("//option[@value='medium']");
    public static final By smallSize = By.xpath("//option[@value='small]");
    public static final By productCountInput = By.xpath("//input[@name='quantity']");
    public static final By productCountIncreaseButton = By.xpath("//button[@class='qty-increase']");
    public static final By productCountDecreaseButton = By.xpath("//button[@class='qty-decrease']");
    public static final By addToCartButton = By.xpath("//button[@class='single_add_to_cart_button button alt']");
    public static final By addedCartMessage = By.xpath("//a[@class='button wc-forward']");


    public String getProductName(){
        return getText(productName);
    }

    // FIXME RENAME
    public String getAddedCartMessage(){
        return getText(addedCartMessage);
    }

    public void clickAddToCartButton(){
        delay();
        clickElement(addToCartButton);
    }

    public void setColor(By locator){
        scrollDown();
        clickElement(colorSelection);
        clickElement(locator);
    }

    public void setRedColor(){
        setColor(redColor);
    }

    public void setMauveColor(){
        setColor(mauveColor);
    }

    public void setSize(By locator){
        clickElement(sizeSelection);
        clickElement(locator);
    }

    public void setLargeSize(){
        setSize(largeSize);
    }

    public void setMediumSize(){
        setSize(mediumSize);
    }

    public void setSmallSize(){
        setSize(smallSize);
    }

    public void increaseProductCount(){
        clickElement(productCountIncreaseButton);
    }

    public void decreaseProductCount(){
        clickElement(productCountDecreaseButton);
    }

    public void setProductCount(String count){
        clear(productCountInput);
        type(productCountInput, count);
    }


    public void productAddToCart(String color, String size){
        switch (color) {
            case "red":
                setRedColor();
                break;
            case "mauve":
                setMauveColor();
                break;
        }

        switch (size) {
            case "large":
                setLargeSize();
                break;
            case "medium":
                setMediumSize();
                break;
            case "small":
                setSmallSize();
                break;
        }
        clickAddToCartButton();
    }

    public void changeProductCount(String operation){
        switch (operation) {
            case "increase":
                increaseProductCount();
                break;
            case "decrease":
                decreaseProductCount();
                break;
            default:
                setProductCount(operation);
                break;
        }
    }
}
