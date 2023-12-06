package com.shop.demoqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class WishlistPage extends BasePage{
    public WishlistPage(WebDriver driver) {
        super(driver);
    }

    public static final By wishlistText = By.xpath("//h1[@class='page-title']");
    public static final By product =  By.xpath("(//td[@class='product-name'])[1]//a");

    public boolean isOnWishlistPage(){
        try{
            return isDisplayed(wishlistText);
        } catch (NoSuchElementException e){
            return false;
        }
    }

    public String getProductName(){
        return getText(product);
    }

}
