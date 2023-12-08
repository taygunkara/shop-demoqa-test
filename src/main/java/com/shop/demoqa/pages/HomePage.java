package com.shop.demoqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

/**
 * The HomePage represents the home page of a web application.
 * It extends the BasePage class to inherit common functionality and encapsulates
 * actions specific to the home page, such as searching for products and checking
 * the visibility of the product area.
 */
public class HomePage extends BasePage{
    public HomePage(WebDriver driver) {
        super(driver);
    }

    public static final By searchBox = By.xpath("//a[@class='noo-search']");
    public static final By searchInput = By.xpath("//input[@class='form-control']");
    public static final By productsArea = By.xpath("//div[@class='products noo-row']");

    /**
     * Clears the user credentials, including search box.
     */
    public void clearCredentials() {
        clear(searchInput);
    }

    /**
     * A method containing the necessary steps to search for a given product name.
     * This method clicks on the search box, clears user credentials, types the specified
     * product name into the input field, and presses the Enter key.
     *
     * @param product The name of the product to be searched
     */
    public void searchProduct(String product){
        clickElement(searchBox);
        clearCredentials();
        type(searchInput, product);
        clickEnter(searchInput);
    }

    /**
     * A method that checks the visibility of the product area.
     *
     * @return True if the product area is visible; otherwise, false.
     */
    public boolean isProductsAreaVisible(){
        try{
            return isDisplayed(productsArea);
        } catch (NoSuchElementException e){
            return false;
        }
    }
}
