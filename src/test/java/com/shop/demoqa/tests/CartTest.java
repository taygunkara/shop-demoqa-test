package com.shop.demoqa.tests;

import com.shop.demoqa.pages.CartPage;
import com.shop.demoqa.pages.ProductPage;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

    // FIXME RENAME
    @Test
    @DisplayName("Should Be In Cart Page")
    @Order(1)
    public void isOnCartPage(){
        assertTrue(cartPage.isOnCartPage());
    }

    // FIXME RENAME
    @Test
    @DisplayName(" clear cart page")
    @Order(2)
    public void isCartPageEmpty(){
        cartPage.clearShoppingCart();
        assertEquals("Your cart is currently empty.", cartPage.getEmptyMessage());
    }

    // FIXME RENAME
    @Test
    @DisplayName(" adasd")
    @Order(3)
    public void CartShouldBeUpdate(){
        cartPage.updateProduct();
        assertEquals("Cart updated.", cartPage.getUpdateMessage());
    }

    // FIXME RENAME
    @Test
    @DisplayName(" continue ")
    @Order(4)
    public void ShouldContinueToShopping(){
        cartPage.continueShopping();
        System.out.println(driver.getCurrentUrl());
        assertEquals("https://shop.demoqa.com/shop/", driver.getCurrentUrl());
    }

    // FIXME RENAME
    @Test
    @DisplayName(" apply coupon with error")
    @Order(5)
    public void ShouldNotBeDiscountWithInvalidCoupon(){
        cartPage.applyCoupon("1121232");
        assertTrue(cartPage.isGetCouponError());
    }

    // FIXME RENAME
    @Test
    @DisplayName(" proceed to checkout ")
    @Order(6)
    public void ShouldProceedToCheckout(){
        cartPage.goToCheckout();
        System.out.println(driver.getCurrentUrl());
        assertEquals("https://shop.demoqa.com/checkout/", driver.getCurrentUrl());
    }

    // FIXME RENAME
    @Test
    @DisplayName(" remove product ")
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
