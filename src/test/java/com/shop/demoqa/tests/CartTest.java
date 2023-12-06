package com.shop.demoqa.tests;

import com.shop.demoqa.pages.CartPage;
import com.shop.demoqa.pages.ProductPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CartTest extends BaseTest{

    CartPage cartPage;
    ProductPage productPage;

    @BeforeEach
    public void startTest(){
        setUp();
        navigateToProductPage();
        cartPage = new CartPage(driver);
        productPage = new ProductPage(driver);
    }

    @Test
    public void get(){
        productPage.productAddToCart("red", "large", "5");
        productPage.goToCart();
        System.out.println(cartPage.getProductCount());
        System.out.println("-------------");
        System.out.println(cartPage.getProductName());
        System.out.println("-------------");
        System.out.println(cartPage.getProductSize());
    }

}
