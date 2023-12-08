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
        loginPage.setDismissBanner();
        loginPage.clearCredentials(); // We Should Clear Credentials Before Proceeding
    }

    @Test
    @DisplayName("Verify Successful Login With A Valid Username And Password.")
    @Order(1)
    public void ShouldBeAbleToLoginWithValidUsernameAndValidPassword(){
        loginPage.setLogin(LoginTestData.VALID_USERNAME, LoginTestData.VALID_PASSWORD);
        assertEquals(LoginTestData.VALID_LOGIN_MESSAGE, loginPage.getSuccessLoginMessage());
    }

    @Test
    @DisplayName("Verify Login Failure With An Empty Username.")
    @Order(2)
    public void ShouldNotBeAbleToLoginWithEmptyUsername(){
        loginPage.setLogin("", LoginTestData.VALID_PASSWORD);
        assertEquals(LoginTestData.MISSING_USERNAME_MESSAGE, loginPage.getInvalidLoginErrorMessage());
    }

    @Test
    @DisplayName("Verify Login Failure With An Empty Password.")
    @Order(3)
    public void ShouldNotBeAbleToLoginWithEmptyPassword(){
        loginPage.setLogin(LoginTestData.VALID_USERNAME, "");
        assertEquals(LoginTestData.MISSING_PASSWORD_MESSAGE, loginPage.getInvalidLoginErrorMessage());

    }

    @Test
    @DisplayName("Verify Login Failure With A Valid Username And An Invalid Password.")
    @Order(4)
    public void ShouldNotBeAbleToLoginWithValidUsernameAndInvalidPassword(){
        loginPage.setLogin(LoginTestData.VALID_USERNAME, LoginTestData.INVALID_PASSWORD);
        assertEquals(LoginTestData.INVALID_LOGIN_MESSAGE, loginPage.getInvalidLoginErrorMessage());
    }

    @Test
    @DisplayName("Verify Login Failure With An Invalid Username And An Valid Password.")
    @Order(5)
    public void ShouldNotBeAbleToLoginWithInvalidUsernameAndValidPassword(){
        loginPage.setLogin(LoginTestData.INVALID_USERNAME, LoginTestData.VALID_PASSWORD);
        assertEquals(LoginTestData.INVALID_LOGIN_MESSAGE, loginPage.getInvalidLoginErrorMessage());
    }

    @Test
    @DisplayName("Verify Login Failure With An Invalid Username And An Invalid Password.")
    @Order(6)
    public void ShouldNotBeAbleToLoginWithInvalidUsernameAndInvalidPassword(){
        loginPage.setLogin(LoginTestData.INVALID_USERNAME, LoginTestData.INVALID_PASSWORD);
        assertEquals(LoginTestData.INVALID_LOGIN_MESSAGE, loginPage.getInvalidLoginErrorMessage());
    }

    @AfterEach
    public void closeTest(){
        tearDown();
    }

}
