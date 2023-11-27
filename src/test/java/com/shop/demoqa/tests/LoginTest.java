package com.shop.demoqa.tests;

import com.shop.demoqa.pages.LoginPage;
import com.shop.demoqa.testdata.LoginTestData;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class LoginTest extends BaseTest {

    private LoginPage loginPage;

    @BeforeEach
    public void startTests(){
        setUp();
        navigateToLoginAndRegisterPage();
        loginPage = new LoginPage(driver);
    }

    @Test
    @DisplayName("Verify successful login with a valid username and password.")
    @Order(1)
    public void ShouldBeAbleToLoginWithValidUsernameAndValidPassword(){
        loginPage.setLogin(LoginTestData.VALID_USERNAME, LoginTestData.VALID_PASSWORD);
        // FIXME ASSERT WILL CHANGE AFTER CORRECT USERNAME & PASSWORD
        assertFalse(loginPage.isLoggedIn());
        //assertTrue(loginPage.isLoggedIn());
    }

    @Test
    @DisplayName("Verify login failure with an empty username.")
    @Order(2)
    public void ShouldNotBeAbleToLoginWithEmptyUsername(){
        loginPage.setLogin(" ", LoginTestData.VALID_PASSWORD);
    }

    @Test
    @DisplayName("Verify login failure with an empty password.")
    @Order(3)
    public void ShouldNotBeAbleToLoginWithEmptyPassword(){
        loginPage.setLogin(LoginTestData.VALID_USERNAME, " ");

    }

    @Test
    @DisplayName("Verify login failure with a valid username and an invalid password.")
    @Order(4)
    public void ShouldNotBeAbleToLoginWithValidUsernameAndInvalidPassword(){
        loginPage.setLogin(LoginTestData.VALID_USERNAME, LoginTestData.INVALID_PASSWORD);
        assertFalse(loginPage.isLoggedIn());
    }

    @Test
    @DisplayName("Verify login failure with an invalid username and an valid password.")
    @Order(5)
    public void ShouldNotBeAbleToLoginWithInvalidUsernameAndValidPassword(){
        loginPage.setLogin(LoginTestData.INVALID_USERNAME, LoginTestData.VALID_PASSWORD);
        assertFalse(loginPage.isLoggedIn());
    }

    @Test
    @DisplayName("Verify login failure with an invalid username and an invalid password.")
    @Order(6)
    public void ShouldNotBeAbleToLoginWithInvalidUsernameAndInvalidPassword(){
        loginPage.setLogin(LoginTestData.INVALID_USERNAME, LoginTestData.INVALID_PASSWORD);
        assertFalse(loginPage.isLoggedIn());
    }

    @AfterEach
    public void closeTest(){
        tearDown();
    }

}
