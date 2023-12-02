package com.shop.demoqa.tests;

import com.shop.demoqa.pages.ProductPage;
import com.shop.demoqa.testdata.ProductTestData;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductTest extends BaseTest{

    ProductPage productPage;

    @BeforeEach
    public void startTest(){
        setUp();
        navigateToProductPage();
        productPage = new ProductPage(driver);
    }

    @Test
    @DisplayName("Verify Correct Display of Product Name on Product Page.")
    public void shouldDisplayCorrectProductNameOnProductPage(){
        assertEquals(ProductTestData.ACTUAL_PRODUCT_NAME, productPage.getProductName());
    }

    @Test
    @DisplayName("Add Product to Cart Successfully.")
    public void shouldSuccessfullyAddProductToCart(){
        productPage.productAddToCart(ProductTestData.PRODUCT_COLOR_RED, ProductTestData.PRODUCT_SIZE_LARGE);
        assertEquals(ProductTestData.PRODUCT_ADDED_SUCCESS_MESSAGE, productPage.getAddedCartMessage());
    }

    @AfterEach
    public void closeTest(){
        tearDown();
    }

}
