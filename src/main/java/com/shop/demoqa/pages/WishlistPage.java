package com.shop.demoqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WishlistPage extends BasePage{
    public WishlistPage(WebDriver driver) {
        super(driver);
    }

    public static final By product =  By.xpath("(//td[@class='product-name'])[1]//a");
    public static final By removeProduct = By.xpath("(//td[@class='product-remove']//a[@class='remove remove_from_wishlist'])");
    public static final By removedProductMessage = By.xpath("//div[@class='woocommerce-message']");
    public static final By addProductToCart = By.xpath("(//a[@class='product_type_variation add_to_cart_button ajax_add_to_cart add_to_cart alt'])[1]");
    public static final By cartPage = By.xpath("//a[@class='cart-button']");
    public static final By dismissBanner = By.xpath("//a[@class='woocommerce-store-notice__dismiss-link']");


    public String getProductName(){
        return getText(product);
    }

    public void clearAllProducts() {
        clickAllElements(findAllElements(removeProduct));
    }

    public String productRemovedMessage(){
        return getText(removedProductMessage);
    }

    public void addProductToCart() {
        clickElement(addProductToCart);
        delay();
    }

    public void goToCart(){
        clickElement(cartPage);
    }

    public void setDismissBanner(){
        if (isDisplayed(dismissBanner)){
            scrollUp();
            clickElement(dismissBanner);
        }
    }
}