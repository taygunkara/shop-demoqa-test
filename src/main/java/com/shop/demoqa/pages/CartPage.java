package com.shop.demoqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage{
    public CartPage(WebDriver driver) {
        super(driver);
    }

    public static final By productName = By.xpath("(//td[@class='product-name'])[1]//a");
    public static final By productSize = By.xpath("(//dd[@class='variation-Size'])[1]//p");
    public static final By productCount = By.xpath("(//input[@type='text'])[1]");
    public static final By pageTitle = By.xpath("//h1[@class='page-title']");
    public static final By clearShoppingCart = By.xpath("//a[@class='empty-cart']");
    public static final By emptyCartMessage = By.xpath("//div[@class='cart-empty woocommerce-info']");
    public static final By updateCartMessage = By.xpath("//div[@class='woocommerce-message']");
    public static final By productCountIncreaseButton = By.xpath("//button[@class='qty-increase']");
    public static final By productCountDecreaseButton = By.xpath("//button[@class='qty-decrease']");
    public static final By updateShoppingCart = By.xpath("//input[@name='update_cart']");
    public static final By continueShopping = By.xpath("//a[@class='continue']");
    public static final By couponInput = By.xpath("//input[@id='noo_coupon_code']");
    public static final By applyCouponButton = By.xpath("//button[@class='noo-apply-coupon']");
    public static final By couponError = By.xpath("//ul[@class='woocommerce-error']");
    public static final By proceedCheckout = By.xpath("//a[@class='checkout-button button alt wc-forward']");
    public static final By removeProduct = By.xpath("//a[@class='icon_close_alt2']");
    public static final By restoreProduct = By.xpath("//a[@class='restore-item']");

    public String getProductCount(){
       return getAttribute(productCount, "value");
    }
    public String getProductName(){
        return getText(productName);
    }
    public String getProductSize(){
        return getText(productSize);
    }
    public String getTitle(){
        return getText(pageTitle);
    }

    public boolean isOnCartPage(){
        return getTitle().equals("CART");
    }

    // CLEAR  ------------------------------------------------
    public void clearShoppingCart(){
        clickElement(clearShoppingCart);
    }

    public String getEmptyMessage(){
        return getText(emptyCartMessage);
    }
    // CLEAR ------------------------------------------------

    // UPDATE ------------------------------------------------
    public String getUpdateMessage(){
        return getText(updateCartMessage);
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

    public void updateProduct(){
        increaseProductCount(5);
        clickElement(updateShoppingCart);
    }
    // UPDATE ------------------------------------------------

    // FIXME SAME NAME PROBLEM ?
    public void continueShopping(){
        clickElement(continueShopping);
    }

    // COUPON -------------------------------------------------

    public void applyCoupon(String coupon){
        type(couponInput, coupon);
        clickElement(applyCouponButton);
    }

    public boolean isGetCouponError(){
        try{
            return isDisplayed(couponError);
        } catch (NoSuchElementException e){
            return false;
        }
    }

    // COUPON -------------------------------------------------

    public void goToCheckout(){
        clickElement(proceedCheckout);
    }

    // --------------------------------------------------------
    public void removeProduct() {
        clickElement(removeProduct);
    }

    public boolean isProductRemoved(){
        try{
            return isDisplayed(restoreProduct);
        } catch (NoSuchElementException e){
            return false;
        }
    }

}
