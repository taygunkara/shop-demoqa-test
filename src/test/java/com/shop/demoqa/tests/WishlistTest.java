package com.shop.demoqa.tests;

import com.shop.demoqa.pages.WishlistPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class WishlistTest extends BaseTest{

    private WishlistPage wishlistPage;
    @BeforeEach
    public void startTest(){
        setUp();
        navigateToWishlistPage();
        wishlistPage = new WishlistPage(driver);
    }

    @Test
    @DisplayName("is on wishlist page")
    @Order(1)
    public void ShouldBeOnWishlistPage(){
        assertTrue(wishlistPage.isOnWishlistPage());
    }


}
