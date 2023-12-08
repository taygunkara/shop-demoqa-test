package com.shop.demoqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * The SearchPage represents a page displaying search results in a web application.
 * It extends the BasePage class to inherit common functionality and encapsulates actions
 * specific to the search results page, such as retrieving product names and checking
 * if the product list contains a specific product.
 */
public class SearchPage extends BasePage{
    public SearchPage(WebDriver driver) {
        super(driver);
    }
    public static final By firstProduct = By.cssSelector("div[class=noo-product-inner]");
    public static final By dismissBanner = By.xpath("//a[@class='woocommerce-store-notice__dismiss-link']");


    /**
     * Retrieves the name of the first product in the list.
     *
     * @return The name of the first product.
     */
    public String getProductName(){
        return getText(firstProduct);
    }

    /**
     * Checks if the product list contains a specific product.
     *
     * @param product The name of the product to check for.
     * @return True if the product list contains the specified product; otherwise, false.
     */
    public boolean isProductListContains(String product) {
        return getProductName().contains(product);
    }

    public void setDismissBanner(){
        if (isDisplayed(dismissBanner)){
            scrollUp();
            clickElement(dismissBanner);
        }
    }
}
