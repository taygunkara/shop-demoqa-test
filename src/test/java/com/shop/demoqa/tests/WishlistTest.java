package com.shop.demoqa.tests;

import com.shop.demoqa.pages.ProductPage;
import com.shop.demoqa.pages.WishlistPage;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WishlistTest extends BaseTest{

    private WishlistPage wishlistPage;
    private ProductPage productPage;

    @BeforeEach
    public void startTest(){
        setUp();
        navigateToWishlistPage();
        wishlistPage = new WishlistPage(driver);
        productPage = new ProductPage(driver);
        wishlistPage.clearAllProducts();
    }

    @Test
    @DisplayName("Should Be on Wishlist Page")
    @Order(1)
    public void ShouldBeOnWishlistPage(){
        assertEquals("https://shop.demoqa.com/wishlist/", driver.getCurrentUrl());
    }

    @Test
    @DisplayName("Successfully Clear All Products on Wishlist")
    @Order(2)
    public void ShouldClearAllProductsOnWishlist(){
        navigateToProductPage();
        productPage.productAddToWishlist("red", "large", "1");
        productPage.goToWishlist();
        wishlistPage.clearAllProducts();
        assertEquals("Product successfully removed.", wishlistPage.productRemovedMessage());
    }

    @AfterEach
    public void closeTest(){
        tearDown();
    }
}
