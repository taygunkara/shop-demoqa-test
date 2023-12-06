package com.shop.demoqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage{
    public CartPage(WebDriver driver) {
        super(driver);
    }

    public static final By cleanCart = By.xpath("a[class=empty-cart]");
    public static final By productName = By.xpath("(//td[@class='product-name'])[1]//a");

    public static final By productSize = By.xpath("(//dd[@class='variation-Size'])[1]//p");
    public static final By productCount = By.xpath("(//input[@type='text'])[1]");

    public String getProductCount(){
       return getAttribute(productCount, "value");
    }

    public String getProductName(){
        return getText(productName);
    }

    public String getProductSize(){
        return getText(productSize);
    }




}
