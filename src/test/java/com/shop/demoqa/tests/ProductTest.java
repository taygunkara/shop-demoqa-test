package com.shop.demoqa.tests;

import com.shop.demoqa.pages.CartPage;
import com.shop.demoqa.pages.ProductPage;
import com.shop.demoqa.pages.WishlistPage;
import com.shop.demoqa.testdata.ProductTestData;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class ProductTest extends BaseTest{
    private ProductPage productPage;
    private CartPage cartPage;
    private WishlistPage wishlistPage;

    @BeforeEach
    public void startTest(){
        setUp();
        navigateToProductPage();
        productPage = new ProductPage(driver);
        cartPage = new CartPage(driver);
        productPage.setDismissBanner();
        wishlistPage = new WishlistPage(driver);
    }

    @Test
    @DisplayName("Verify Correct Display of Product Name on Product Page.")
    @Order(1)
    public void ShouldDisplayCorrectProductNameOnProductPage(){
        assertEquals(ProductTestData.ACTUAL_PRODUCT_NAME, productPage.getProductName());
    }

    @Test
    @DisplayName("Add Product to Cart Successfully.")
    @Order(2)
    public void ShouldSuccessfullyAddProductToCart(){
        productPage.productAddToCart(ProductTestData.PRODUCT_COLOR_RED, ProductTestData.PRODUCT_SIZE_LARGE, ProductTestData.TYPE_PRODUCT_COUNT);
        productPage.goToCart();
        assertEquals(ProductTestData.PRODUCT_NAME_ADDED_TO_CART, cartPage.getProductName());
    }

    @Test
    @DisplayName("Verify Unable to Add Product to Cart Without Variants")
    @Order(3)
    public void ShouldNotAddProductToCartWithoutVariants(){
        productPage.setRequiredInformation("", "", "1");
        productPage.clickEnter();
        assertEquals(ProductTestData.ALERT_MESSAGE, productPage.getAlert());
        productPage.dismissAlert();
    }

    @Test
    @DisplayName("Verify Increasing Product Count")
    @Order(4)
    public void ShouldIncreaseProductCount(){
        productPage.setRequiredInformation("red", "large", "0");
        productPage.increaseProductCount(5);
        productPage.clickAddToCartButton();
        productPage.goToCart();
        assertEquals("5", cartPage.getProductCount());
    }

    @Test
    @DisplayName("Verify Decreasing Product Count")
    @Order(5)
    public void ShouldDecreaseProductCount(){
        productPage.setRequiredInformation("red", "large", "10");
        productPage.decreaseProductCount(5);
        productPage.clickAddToCartButton();
        productPage.goToCart();
        assertEquals("5", cartPage.getProductCount());
    }

    @Test
    @DisplayName("Verify Adding Product to Favorites")
    @Order(6)
    public void ShouldAddProductToFavorites(){
        productPage.setRequiredInformation("red", "large", "1");
        productPage.addToFavorite();
        productPage.goToWishlist();
        assertEquals("RED SATIN ROUND NECK BACKLESS MAXI DRESS", wishlistPage.getProductName());
    }

    @Test
    @DisplayName("Verify Display of Related Products Section on Product Page")
    @Order(7)
    public void ShouldDisplayRelatedProductsSection(){
        assertTrue(productPage.isRelatedProductsSectionVisible());
    }

    @Test
    @DisplayName("Verify Presence of Additional Information Section on Product Page")
    @Order(8)
    public void ShouldDetectAdditionalInformationSectionOnProductPage(){
        assertTrue(productPage.isAdditionalInformationSectionPresent());
    }

    @Test
    @DisplayName("Should Clear All Variants With Clear Button")
    @Order(9)
    public void ShouldClearAllVariants(){
        productPage.setRequiredInformation("red", "large", "1");
        productPage.clearAllVariants();
        assertFalse(productPage.isVariantClearButtonActive());
    }

    @AfterEach
    public void closeTest(){
        tearDown();
    }


}
