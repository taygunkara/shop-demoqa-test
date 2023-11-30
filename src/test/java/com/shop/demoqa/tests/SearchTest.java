package com.shop.demoqa.tests;

import com.shop.demoqa.pages.HomePage;
import com.shop.demoqa.pages.SearchPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

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
    @DisplayName("Verify successful search for a valid product.")
    @Order(1)
    public void ShouldBeAbleToSearchForValidProduct(){
        homePage.searchProduct("MIDI DRESS");
        assertTrue(homePage.isProductsAreaVisible());
    }

    @Test
    @DisplayName("Verify search failure with empty value.")
    @Order(2)
    public void ShouldNotBeAbleToSearchWithEmpty(){
        homePage.searchProduct("");
        assertFalse(homePage.isProductsAreaVisible());
    }

    @Test
    @DisplayName("Verify successful search with exact product name.")
    @Order(3)
    public void ShouldYieldResultsWhenSearchingWithExactProductName(){
        homePage.searchProduct("MIDI DRESS");
        assertTrue(searchPage.checkContainsProduct("MIDI DRESS"));
    }
}
