package com.shop.demoqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class SearchPage extends BasePage{
    public SearchPage(WebDriver driver) {
        super(driver);
    }
    public static final By firstProduct = By.cssSelector("div[class=noo-product-inner]");

    public String getProductName(){
        return getText(firstProduct);
    }

    // FIXME RENAME
    public boolean checkContainsProduct(String product) {
        return getProductName().contains(product);
    }
}
