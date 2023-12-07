package com.shop.demoqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WishlistPage extends BasePage{
    public WishlistPage(WebDriver driver) {
        super(driver);
    }

    public static final By product =  By.xpath("(//td[@class='product-name'])[1]//a");
    public static final By removeProduct = By.xpath("(//td[@class='product-remove']//a[@class='remove remove_from_wishlist'])"); // FIXME
    public static final By removedProductMessage = By.xpath("//div[@class='woocommerce-message']");

    public String getProductName(){
        return getText(product);
    }
    public void clearAllProducts() {
        clickAllElements(findAllElements(removeProduct));
    }
    public String productRemovedMessage(){
        return getText(removedProductMessage);
    }

}