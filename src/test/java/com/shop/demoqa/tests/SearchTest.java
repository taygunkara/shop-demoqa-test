package com.shop.demoqa.tests;

import com.shop.demoqa.pages.HomePage;
import com.shop.demoqa.pages.SearchPage;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SearchTest extends BaseTest{
    private HomePage homePage;
    private SearchPage searchPage;

    // FIXME RENAME TEST
    @BeforeEach
    public void startTest(){
        setUp();
        navigateToHomePage();
        homePage = new HomePage(driver);
        searchPage = new SearchPage(driver);
    }

    @Test
    @DisplayName("Verify Successful Search For A Valid Product.")
    @Order(1)
    public void ShouldBeAbleToSearchForValidProduct(){
        homePage.searchProduct("MIDI DRESS");
        assertTrue(homePage.isProductsAreaVisible());
    }

    @Test
    @DisplayName("Verify Search Failure With Empty Value.")
    @Order(2)
    public void ShouldNotBeAbleToSearchWithEmpty(){
        homePage.searchProduct("");
        assertFalse(homePage.isProductsAreaVisible());
    }

    @Test
    @DisplayName("Verify Successful Search With Exact Product Name.")
    @Order(3)
    public void ShouldYieldResultsWhenSearchingWithExactProductName(){
        homePage.searchProduct("MIDI DRESS");
        assertTrue(searchPage.isProductListContains("MIDI DRESS"));
    }

    @AfterEach
    public void closeTest(){
        tearDown();
    }
}