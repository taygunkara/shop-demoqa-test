package com.shop.demoqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * The ProductPage represents the page and actions related to viewing and interacting with a product on a web application.
 */
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

    /**
     * Gets the name of the product.
     * @return The product name as a string.
     */
    public String getProductName(){
        return getText(productName);
    }

    /**
     * Gets the message displayed after adding a product to the cart.
     * @return The product added to cart message as a string.
     */
    public String getCartProductAddedMessage(){
        return getText(addedCartMessage);
    }

    /**
     * Clicks the "Add to Cart" button on the product details page.
     */
    public void clickAddToCartButton(){
        delay();
        clickElement(addToCartButton);
    }

    /**
     * Sets the color of the product.
     * @param locator The locator for the color selection.
     */
    public void setColor(By locator){
        scrollDown();
        clickElement(colorSelection);
        clickElement(locator);
    }

    /**
     * Sets the color of the product to red.
     */
    public void setRedColor(){
        setColor(redColor);
    }

    /**
     * Sets the color of the product to mauve.
     */
    public void setMauveColor(){
        setColor(mauveColor);
    }

    /**
     * Sets the size of the product.
     * @param locator The locator for the size selection.
     */
    public void setSize(By locator){
        clickElement(sizeSelection);
        clickElement(locator);
    }

    /**
     * Sets the size of the product to large.
     */
    public void setLargeSize(){
        setSize(largeSize);
    }

    /**
     * Sets the size of the product to medium.
     */
    public void setMediumSize(){
        setSize(mediumSize);
    }

    /**
     * Sets the size of the product to small.
     */
    public void setSmallSize(){
        setSize(smallSize);
    }

    /**
     * Increases the product count on the product details page.
     */
    public void increaseProductCount(){
        clickElement(productCountIncreaseButton);
    }

    /**
     * Decreases the product count on the product details page.
     */
    public void decreaseProductCount(){
        clickElement(productCountDecreaseButton);
    }

    /**
     * Sets the product count on the product details page.
     * @param count The count to set for the product.
     */
    public void setProductCount(String count){
        clear(productCountInput);
        type(productCountInput, count);
    }

    /**
     * Adds the product to the cart with specified color and size.
     * @param color The color of the product.
     * @param size The size of the product.
     */
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

    /**
     * Changes the product count on the product details page based on the specified operation.
     * @param operation The operation to perform on the product count (increase, decrease, or set a specific count).
     */
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
