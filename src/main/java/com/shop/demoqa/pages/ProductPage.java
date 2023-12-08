package com.shop.demoqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

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
    public static final By addToFavorite = By.xpath("(//a[@class='add_to_wishlist single_add_to_wishlist'])[1]");
    public static final By wishlist = By.xpath("//*[@id=\"noo-site\"]/header/div[1]/div/ul[2]/li[1]/a");
    public static final By dismissBanner = By.xpath("//a[@class='woocommerce-store-notice__dismiss-link']");
    public static final By relatedProducts = By.xpath("//div[@class='products noo-row']");
    public static final By additionalInformationArea = By.xpath("//*[@id=\"product-1184\"]/div[2]/div/ul/li[1]");
    public static final By clearVariation = By.xpath("//a[@class='reset_variations'][contains(@style, 'visibility: visible;')]");
    public static final By cartPage = By.xpath("//a[@class='cart-button']");


    public void setDismissBanner(){
        if (isDisplayed(dismissBanner)){
            scrollUp();
            clickElement(dismissBanner);
        }
    }

    public String getProductName(){
        return getText(productName);
    }

    public void clickAddToCartButton(){
        delay();
        clickElement(addToCartButton);
    }

    public void clickEnter(){
        clickEnter(productCountInput);
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

    public void decreaseProductCount(int decreaseAmount) {
        for (int i = 0; i < decreaseAmount; i++) {
            clickElement(productCountDecreaseButton);
        }
    }

    public void increaseProductCount(int increaseAmount) {
        for (int i = 0; i < increaseAmount; i++) {
            clickElement(productCountIncreaseButton);
        }
    }

    public void setProductCount(String count){
        clear(productCountInput);
        type(productCountInput, count);
    }

    public void setRequiredInformation(String color, String size, String count){
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
        setProductCount(count);
    }

    public void productAddToCart(String color, String size, String count){
        setRequiredInformation(color, size, count);
        clickAddToCartButton();
    }

    public void productAddToWishlist(String color, String size, String count){
        setRequiredInformation(color, size, count);
        clickAddToWishlist();
    }

    public String getAlert(){
        return getAlertMessage();
    }

    public void clickAddToWishlist() {
        delay();
        clickElement(addToFavorite);
        delay();
    }

    public void goToWishlist(){
        setDismissBanner();
        scrollUp();
        clickElement(wishlist);
    }

    public void productAddToWishlistAndGoToWishlist(String color, String size, String count){
        productAddToWishlist(color, size, count);
        goToWishlist();
    }

    public boolean isRelatedProductsSectionVisible(){
        try{
            return isDisplayed(relatedProducts);
        } catch (NoSuchElementException e){
            return false;
        }
    }

    public boolean isAdditionalInformationSectionPresent(){
        try{
            return isDisplayed(additionalInformationArea);
        } catch (NoSuchElementException e){
            return false;
        }
    }

    public void clearAllVariants(){
        clickElement(clearVariation);
    }

    public boolean isVariantClearButtonActive(){
        try{
            return isDisplayed(clearVariation);
        } catch (NoSuchElementException e){
            return false;
        }
    }

    public void goToCartPage() {
        clickElement(cartPage);
    }

    public void addProductToCartAndGoToCartPage(String color, String size, String count){
        productAddToCart(color, size, count);
        goToCartPage();
    }

}
