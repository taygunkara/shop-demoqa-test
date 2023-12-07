package com.shop.demoqa.tests;

import com.shop.demoqa.pages.CartPage;
import com.shop.demoqa.pages.ProductPage;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

// FIXME ALL TESTS -- METHODS
public class CartTest extends BaseTest{

    private CartPage cartPage;
    private ProductPage productPage;

    // FIXME Cart should not be empty. So in the beginning we need to add product to cart. ?
    @BeforeEach
    public void startTest(){
        setUp();
        navigateToProductPage();
        cartPage = new CartPage(driver);
        productPage = new ProductPage(driver);
        productPage.productAddToCart("red", "large", "5");
        productPage.goToCart();
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
        cartPage.clearShoppingCart();
        assertEquals("Your cart is currently empty.", cartPage.getEmptyMessage());
    }

    @Test
    @DisplayName("Update Cart - Verify Success Message")
    @Order(3)
    public void ShouldUpdateCartAndVerifySuccessMessage(){
        cartPage.updateProduct();
        assertEquals("Cart updated.", cartPage.getUpdateMessage());
    }

    @Test
    @DisplayName("Continue Shopping - Verify Redirect")
    @Order(4)
    public void ShouldContinueToShoppingAndVerifyRedirect(){
        cartPage.continueShopping();
        assertEquals("https://shop.demoqa.com/shop/", driver.getCurrentUrl());
    }

    @Test
    @DisplayName("Apply Invalid Coupon - Verify No Discount")
    @Order(5)
    public void ShouldNotApplyDiscountWithInvalidCoupon(){
        cartPage.applyCoupon("1111111");
        assertTrue(cartPage.isGetCouponError());
    }

    @Test
    @DisplayName("Proceed to Checkout - Verify Redirect")
    @Order(6)
    public void ShouldProceedToCheckoutAndVerifyRedirect(){
        cartPage.goToCheckout();
        assertEquals("https://shop.demoqa.com/checkout/", driver.getCurrentUrl());
    }

    @Test
    @DisplayName("Successfully Remove Product from Cart")
    @Order(7)
    public void ShouldRemoveProductFromCart(){
        cartPage.removeProduct();
        assertTrue(cartPage.isProductRemoved());
    }

    @AfterEach
    public void closeTest(){
        tearDown();
    }

}
