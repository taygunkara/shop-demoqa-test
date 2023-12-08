package com.shop.demoqa.tests;

import com.shop.demoqa.pages.CartPage;
import com.shop.demoqa.pages.ProductPage;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

// TODO METHOD IN TEST CLASS ?
/*
    navigate to login
    add product to cart and go to cart page
 */

public class CartTest extends BaseTest{

    private CartPage cartPage;
    private ProductPage productPage;

    @BeforeEach
    public void startTest(){
        setUp();
        navigateToCartPage();
        cartPage = new CartPage(driver);
        productPage = new ProductPage(driver);
        cartPage.setDismissBanner();
        cartPage.clearShoppingCart(); // We Should Clear Cart Before Proceeding
    }

    @Test
    @DisplayName("Verify Current Page is Cart Page")
    @Order(1)
    public void ShouldVerifyCurrentPageIsCartPage(){
        assertTrue(cartPage.isOnCartPage());
    }

    @Test
    @DisplayName("Clear Cart - Verify Empty Message")
    @Order(2)
    public void ShouldClearCartAndVerifyEmptyMessage(){
        navigateToProductPage();
        productPage.addProductToCartAndGoToCartPage("red", "large", "1");
        cartPage.clearShoppingCart();
        assertEquals("Your cart is currently empty.", cartPage.getEmptyMessage());
    }

    @Test
    @DisplayName("Update Cart - Verify Success Message")
    @Order(3)
    public void ShouldUpdateCartAndVerifySuccessMessage(){
        navigateToProductPage();
        productPage.addProductToCartAndGoToCartPage("red", "large", "1");
        cartPage.updateProduct();
        assertEquals("Cart updated.", cartPage.getUpdateMessage());
    }

    @Test
    @DisplayName("Continue Shopping - Verify Redirect")
    @Order(4)
    public void ShouldContinueToShoppingAndVerifyRedirect(){
        navigateToProductPage();
        productPage.addProductToCartAndGoToCartPage("red", "large", "1");
        cartPage.continueShopping();
        assertEquals("https://shop.demoqa.com/shop/", driver.getCurrentUrl());
    }

    @Test
    @DisplayName("Apply Invalid Coupon - Verify No Discount")
    @Order(5)
    public void ShouldNotApplyDiscountWithInvalidCoupon(){
        navigateToProductPage();
        productPage.addProductToCartAndGoToCartPage("red", "large", "1");
        cartPage.applyCoupon("1111111");
        assertTrue(cartPage.isGetCouponError());
    }

    @Test
    @DisplayName("Proceed to Checkout - Verify Redirect")
    @Order(6)
    public void ShouldProceedToCheckoutAndVerifyRedirect(){
        navigateToProductPage();
        productPage.addProductToCartAndGoToCartPage("red", "large", "1");
        cartPage.goToCheckout();
        assertEquals("https://shop.demoqa.com/checkout/", driver.getCurrentUrl());
    }

    @Test
    @DisplayName("Successfully Remove Product from Cart")
    @Order(7)
    public void ShouldRemoveProductFromCart(){
        navigateToProductPage();
        productPage.addProductToCartAndGoToCartPage("red", "large", "1");
        cartPage.removeProduct();
        assertTrue(cartPage.isProductRemoved());
    }

    @AfterEach
    public void closeTest(){
        tearDown();
    }

}
