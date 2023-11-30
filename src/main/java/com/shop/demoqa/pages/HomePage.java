package com.shop.demoqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

// TODO ADD DOCS
public class HomePage extends BasePage{
    public HomePage(WebDriver driver) {
        super(driver);
    }

    // FIXME LOCATORS
    public static final By searchBox = By.xpath("//*[@id=\"noo-site\"]/header/div[2]/div/a");
    public static final By searchInput = By.xpath("//*[@id=\"noo-site\"]/header/div[3]/div[2]/form/input[1]");
    public static final By productsArea = By.xpath("//*[@id=\"noo-site\"]/div[2]/div[2]/div/div");
    public void clearCredentials() {
        clear(searchInput);
    }

    //FIXME CLEAR METHOD ?
    public void searchProduct(String product){
        clickElement(searchBox);
        clearCredentials();
        type(searchInput, product);
        clickEnter(searchInput);
    }
    public boolean isProductsAreaVisible(){
        try{
            return isDisplayed(productsArea);
        } catch (NoSuchElementException e){
            return false;
        }
    }
}
