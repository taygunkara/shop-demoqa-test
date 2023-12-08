package com.shop.demoqa.tests;

import com.shop.demoqa.pages.CartPage;
import com.shop.demoqa.pages.ProductPage;
import com.shop.demoqa.pages.WishlistPage;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WishlistTest extends BaseTest{

    private WishlistPage wishlistPage;
    private ProductPage productPage;
    private CartPage cartPage;

    @BeforeEach
    public void startTest(){
        setUp();
        navigateToWishlistPage();
        wishlistPage = new WishlistPage(driver);
        productPage = new ProductPage(driver);
        cartPage = new CartPage(driver);
        wishlistPage.setDismissBanner();
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

    // [BUG] CAN NOT ADD PRODUCT TO CART FROM WISHLIST // OR THIS IS A FEATURE
    // WE DON'T HAVE REQUIREMENT DOCS FOR THIS WEBSITE
    @Test
    @DisplayName("Successfully Add Product To Cart Page")
    @Order(3)
    public void ShouldBeAddProductToCartPageFromWishlist(){
        navigateToProductPage();
        productPage.productAddToWishlist("red", "large", "1");
        productPage.goToWishlist();
        wishlistPage.addProductToCart();
        wishlistPage.goToCart();
        assertTrue(cartPage.isThereAnyProductOnCart());
    }

    @AfterEach
    public void closeTest(){
        tearDown();
    }

}
