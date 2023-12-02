package com.shop.demoqa.tests;

import com.shop.demoqa.pages.RegisterPage;
import com.shop.demoqa.testdata.RegisterTestData;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegisterTest extends BaseTest {
    private RegisterPage registerPage;

    @BeforeEach
    public void start(){
        setUp();
        navigateToLoginAndRegisterPage();
        registerPage = new RegisterPage(driver);
        registerPage.clearCredentials();
    }

    @Test
    @DisplayName("Verify Successful Registration With Valid Information.")
    @Order(1)
    public void ShouldBeAbleToCreateAnAccount(){
        registerPage.createAnAccount(RegisterTestData.VALID_USERNAME, RegisterTestData.VALID_EMAIL, RegisterTestData.STRONG_PASSWORD);
        assertEquals(RegisterTestData.VALID_REGISTER_MESSAGE, registerPage.getSuccessRegisterMessage());
    }

    @Test
    @DisplayName("Verify Registration Failure With Empty Username.")
    @Order(2)
    public void ShouldNotBeAbleToCreateAnAccountWithEmptyUsername(){
        registerPage.createAnAccount("", RegisterTestData.VALID_EMAIL, RegisterTestData.STRONG_PASSWORD);
        assertEquals(RegisterTestData.MISSING_USERNAME_MESSAGE,registerPage.getInvalidRegisterErrorMessage());
    }

    @Test
    @DisplayName("Verify Registration Failure With Empty Email.")
    @Order(3)
    public void ShouldNotBeAbleToCreateAnAccountWithEmptyEmail(){
        registerPage.createAnAccount(RegisterTestData.VALID_USERNAME, "", RegisterTestData.STRONG_PASSWORD);
        assertEquals(RegisterTestData.MISSING_EMAIL_MESSAGE,registerPage.getInvalidRegisterErrorMessage());
    }

    @Test
    @DisplayName("Verify Registration Failure With Empty Password.")
    @Order(4)
    public void ShouldNotBeAbleToCreateAnAccountWithEmptyPassword(){
        registerPage.createAnAccount(RegisterTestData.VALID_USERNAME, RegisterTestData.VALID_EMAIL, "");
        assertEquals(RegisterTestData.MISSING_PASSWORD_MESSAGE,registerPage.getInvalidRegisterErrorMessage());
    }

    @Test
    @DisplayName("Verify Registration Failure With Weak Password.")
    @Order(5)
    public void ShouldNotBeAbleToCreateAnAccountWithWeakPassword() {
        registerPage.setWeakPassword(RegisterTestData.VALID_USERNAME, RegisterTestData.VALID_EMAIL, RegisterTestData.WEAK_PASSWORD);
        assertEquals(RegisterTestData.WEAK_PASSWORD_MESSAGE, registerPage.getWeakPasswordErrorMessage());
    }

    @Test
    @DisplayName("Verify Registration Failure With Duplicated Email.")
    @Order(6)
    public void ShouldNotBeAbleToCreateAnAccountWithDuplicatedEmail(){
        registerPage.createAnAccount(RegisterTestData.VALID_USERNAME, RegisterTestData.DUPLICATED_EMAIL, RegisterTestData.STRONG_PASSWORD);
        assertEquals(RegisterTestData.DUPLICATED_EMAIL_MESSAGE, registerPage.getInvalidRegisterErrorMessage());
    }

    @AfterEach
    public void closeTest(){
        tearDown();
    }

}
