package com.shop.demoqa.tests;

import com.shop.demoqa.pages.RegisterPage;
import com.shop.demoqa.testdata.RegisterTestData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

public class RegisterTest extends BaseTest {
    private RegisterPage registerPage;

    @BeforeEach
    public void start(){
        setUp();
        navigateToLoginAndRegisterPage();
        registerPage = new RegisterPage(driver);

    }

    // TODO ADD ASSERTS

    @Test
    @DisplayName("Verify successful registration with valid information.")
    @Order(1)
    public void ShouldBeAbleToCreateAnAccount(){
        registerPage.createAnAccount(RegisterTestData.VALID_USERNAME, RegisterTestData.VALID_EMAIL, RegisterTestData.STRONG_PASSWORD);
    }

    @Test
    @DisplayName("Verify registration failure with empty username.")
    @Order(2)
    public void ShouldNotBeAbleToCreateAnAccountWithEmptyUsername(){
        registerPage.createAnAccount(" ", RegisterTestData.VALID_EMAIL, RegisterTestData.STRONG_PASSWORD);
    }

    @Test
    @DisplayName("Verify registration failure with empty email.")
    @Order(3)
    public void ShouldNotBeAbleToCreateAnAccountWithEmptyEmail(){
        registerPage.createAnAccount(RegisterTestData.VALID_USERNAME, " ", RegisterTestData.STRONG_PASSWORD);
    }

    @Test
    @DisplayName("Verify registration failure with empty password.")
    @Order(4)
    public void ShouldNotBeAbleToCreateAnAccountWithEmptyPassword(){
        registerPage.createAnAccount(RegisterTestData.VALID_USERNAME, RegisterTestData.VALID_EMAIL, " ");
    }

    @Test
    @DisplayName("Verify registration failure with weak password.")
    @Order(5)
    public void ShouldNotBeAbleToCreateAnAccountWithWeakPassword(){
        registerPage.createAnAccount(RegisterTestData.VALID_USERNAME, RegisterTestData.VALID_EMAIL, RegisterTestData.WEAK_PASSWORD);
    }

    @Test
    @DisplayName("Verify registration failure with duplicated email.")
    @Order(6)
    public void ShouldNotBeAbleToCreateAnAccountWithDuplicatedEmail(){
        registerPage.createAnAccount(RegisterTestData.VALID_USERNAME, RegisterTestData.DUPLICATED_EMAIL, RegisterTestData.STRONG_PASSWORD);
    }

    @Test
    @DisplayName("Verify successful registration with duplicated username and different email.")
    @Order(7)
    public void ShouldBeAbleToCreateAnAccountWithDuplicatedUsername(){
        registerPage.createAnAccount(RegisterTestData.DUPLICATED_USERNAME, RegisterTestData.VALID_EMAIL, RegisterTestData.STRONG_PASSWORD);
    }
}
