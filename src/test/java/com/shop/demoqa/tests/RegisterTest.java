package com.shop.demoqa.tests;

import com.shop.demoqa.pages.RegisterPage;
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
        registerPage.createAnAccount("liipuyhfhkey", "ldtynbipkey@email.com", "w?sd-ldw9213*0123*-*-3");
        assertEquals("Hello liipuyhfhkey (not liipuyhfhkey? Log out)",
                registerPage.getSuccessRegisterMessage());
    }

    @Test
    @DisplayName("Verify Registration Failure With Empty Username.")
    @Order(2)
    public void ShouldNotBeAbleToCreateAnAccountWithEmptyUsername(){
        registerPage.createAnAccount("", "ldtynbipkey@email.com", "w?sd-ldw9213*0123*-*-3");
        assertEquals("Error: Please enter a valid account username.",
                registerPage.getInvalidRegisterErrorMessage());
    }

    @Test
    @DisplayName("Verify Registration Failure With Empty Email.")
    @Order(3)
    public void ShouldNotBeAbleToCreateAnAccountWithEmptyEmail(){
        registerPage.createAnAccount("liipuyhfhkey", "", "w?sd-ldw9213*0123*-*-3");
        assertEquals("Error: Please provide a valid email address.",
                registerPage.getInvalidRegisterErrorMessage());
    }

    @Test
    @DisplayName("Verify Registration Failure With Empty Password.")
    @Order(4)
    public void ShouldNotBeAbleToCreateAnAccountWithEmptyPassword(){
        registerPage.createAnAccount("liipuyhfhkey", "ldtynbipkey@email.com", "");
        assertEquals("Error: Please enter an account password.",
                registerPage.getInvalidRegisterErrorMessage());
    }

    @Test
    @DisplayName("Verify Registration Failure With Weak Password.")
    @Order(5)
    public void ShouldNotBeAbleToCreateAnAccountWithWeakPassword() {
        registerPage.setWeakPassword("liipuyhfhkey", "ldtynbipkey@email.com", "123");
        assertEquals("Very weak - Please enter a stronger password.",
                registerPage.getWeakPasswordErrorMessage());
    }

    @Test
    @DisplayName("Verify Registration Failure With Duplicated Email.")
    @Order(6)
    public void ShouldNotBeAbleToCreateAnAccountWithDuplicatedEmail(){
        registerPage.createAnAccount("liipuyhfhkey", "ldtynbipkey@email.com", "w?sd-ldw9213*0123*-*-3");
        assertEquals("Error: An account is already registered with your email address. Please log in.",
                registerPage.getInvalidRegisterErrorMessage());
    }

    @AfterEach
    public void closeTest(){
        tearDown();
    }

}
