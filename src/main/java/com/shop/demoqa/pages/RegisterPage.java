package com.shop.demoqa.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * The RegisterPage class represents the page and actions related to user registration on the shop.demoqa.com website.
 * It extends the BasePage class to inherit common page functionalities.
 */
public class RegisterPage extends BasePage {
    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    public static final By registrationUsernameInput = By.xpath("//input[@id='reg_username']");
    public static final By registrationEmailInput = By.xpath("//input[@id='reg_email']");
    public static final By registrationPasswordInput = By.xpath("//input[@id='reg_password']");
    public static final By registerButton = By.xpath("//button[@name='register']");
    public static final By successMessage = By.xpath("//div[@class='woocommerce-MyAccount-content']//p[strong]");
    public static final By errorMessage = By.xpath("//ul[@class='woocommerce-error']");
    public static final By errorWeakPassword = By.cssSelector("div[class='woocommerce-password-strength short']");

    /**
     * Sets the username in the registration form.
     * @param username The username to set.
     */
    public void setUsername(String username){
        type(registrationUsernameInput, username);
    }

    /**
     * Sets the email address in the registration form.
     * @param email The email address to set.
     */
    public void setEmail(String email){
        type(registrationEmailInput, email);
    }

    /**
     * Sets the password in the registration form.
     * @param password The password to set.
     */
    public void setPassword(String password){
        type(registrationPasswordInput, password);
    }

    /**
     * Clears the credentials in the registration form, including username, email, and password.
     */
    public void clearCredentials() {
        clear(registrationUsernameInput);
        clear(registrationEmailInput);
        clear(registrationPasswordInput);
    }

    /**
     * Sets the registration information, including username, email, and password.
     * @param username The username to set.
     * @param email The email address to set.
     * @param password The password to set.
     */
    public void setRegisterInfo(String username, String email, String password){
        setUsername(username);
        setEmail(email);
        setPassword(password);
        delay();
    }

    /**
     * Creates an account by setting the registration information and clicking the registration button.
     * @param username The username to set.
     * @param email The email address to set.
     * @param password The password to set.
     */
    public void createAnAccount(String username, String email, String password){
        setRegisterInfo(username, email, password);
        clickElement(registrationUsernameInput); // FIXME Without any clicking area, register button is not active.
        delay();
        clickElement(registerButton);
    }

    /**
     * Sets a weak password in the registration form and triggers an event to show an alert.
     * @param username The username to set.
     * @param email The email address to set.
     * @param weakPassword The weak password to set.
     */
    public void setWeakPassword(String username, String email, String weakPassword) {
        setRegisterInfo(username, email, weakPassword);
        clickElement(registrationUsernameInput); // FIXME Without any clicking area, alert is not showing.
    }

    /**
     * Gets the registration message based on the provided locator.
     * @param messageLocator The locator for the registration message.
     * @return The registration message as a string.
     */
    public String getRegisterMessage(By messageLocator){
        return getText(messageLocator);
    }

    /**
     * Gets the success registration message.
     * @return The success registration message as a string.
     */
    public String getSuccessRegisterMessage(){
        return getRegisterMessage(successMessage);
    }

    /**
     * Gets the invalid registration error message.
     * @return The invalid registration error message as a string.
     */
    public String getInvalidRegisterErrorMessage(){
        return getRegisterMessage(errorMessage);
    }

    /**
     * Gets the weak password error message.
     * @return The weak password error message as a string.
     */
    public String getWeakPasswordErrorMessage(){
        return getRegisterMessage(errorWeakPassword);
    }
}
