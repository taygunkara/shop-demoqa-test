package com.shop.demoqa.tests;

import com.shop.demoqa.pages.LoginPage;
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
        loginPage.setLogin("validusername", "validpassword123*-*");
        assertEquals("Hello validusername (not validusername? Log out)",
                loginPage.getSuccessLoginMessage());
    }

    @Test
    @DisplayName("Verify Login Failure With An Empty Username.")
    @Order(2)
    public void ShouldNotBeAbleToLoginWithEmptyUsername(){
        loginPage.setLogin("", "validpassword123*-*");
        assertEquals("Error: Username is required.",
                loginPage.getInvalidLoginErrorMessage());
    }

    @Test
    @DisplayName("Verify Login Failure With An Empty Password.")
    @Order(3)
    public void ShouldNotBeAbleToLoginWithEmptyPassword(){
        loginPage.setLogin("validusername", "");
        assertEquals("Error: The password field is empty.",
                loginPage.getInvalidLoginErrorMessage());

    }

    @Test
    @DisplayName("Verify Login Failure With A Valid Username And An Invalid Password.")
    @Order(4)
    public void ShouldNotBeAbleToLoginWithValidUsernameAndInvalidPassword(){
        loginPage.setLogin("validusername", "invalidPass");
        assertEquals("ERROR: The username or password you entered is incorrect. Lost your password?",
                loginPage.getInvalidLoginErrorMessage());
    }

    @Test
    @DisplayName("Verify Login Failure With An Invalid Username And An Valid Password.")
    @Order(5)
    public void ShouldNotBeAbleToLoginWithInvalidUsernameAndValidPassword(){
        loginPage.setLogin("invalidUser", "validpassword123*-*");
        assertEquals("ERROR: The username or password you entered is incorrect. Lost your password?",
                loginPage.getInvalidLoginErrorMessage());
    }

    @Test
    @DisplayName("Verify Login Failure With An Invalid Username And An Invalid Password.")
    @Order(6)
    public void ShouldNotBeAbleToLoginWithInvalidUsernameAndInvalidPassword(){
        loginPage.setLogin("invalidUser", "invalidPass");
        assertEquals("ERROR: The username or password you entered is incorrect. Lost your password?",
                loginPage.getInvalidLoginErrorMessage());
    }

    @AfterEach
    public void closeTest(){
        tearDown();
    }

}
