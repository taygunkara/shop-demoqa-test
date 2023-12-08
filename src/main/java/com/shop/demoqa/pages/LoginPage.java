package com.shop.demoqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


/**
 * The LoginPage represents the page and actions related to user login on a web application.
 * It provides methods to interact with the login form and retrieve login-related messages.
 */
public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public static final By usernameInput = By.xpath("//input[@id='username']");
    public static final By passwordInput = By.xpath("//input[@id='password']");
    public static final By rememberMeInput = By.xpath("//input[@id='rememberme']");
    public static final By loginButton = By.xpath("//button[@name='login']");
    public static final By errorMessage = By.xpath("//ul[@class='woocommerce-error']");
    public static final By successMessage = By.xpath("//div[@class='woocommerce-MyAccount-content']//p[strong]");
    public static final By dismissBanner = By.xpath("//a[@class='woocommerce-store-notice__dismiss-link']");

    /**
     * Sets the username in the login form.
     * @param username The username to set.
     */
    public void setUsername(String username){
        type(usernameInput, username);
    }

    /**
     * Sets the password in the login form.
     * @param password The password to set.
     */
    public void setPassword(String password){
        type(passwordInput, password);
    }

    /**
     * Sets the login credentials and performs a login action.
     * @param username The username to set.
     * @param password The password to set.
     */
    public void setLogin(String username, String password){
        setUsername(username);
        setPassword(password);
        clickElement(rememberMeInput);
        clickElement(loginButton);
    }

    /**
     * Clears the login credentials, including username and password.
     */
    public void clearCredentials() {
        clear(usernameInput);
        clear(passwordInput);

    }

    /**
     * Gets the login message based on the provided locator.
     * @param messageLocator The locator for the login message.
     * @return The login message as a string.
     */
    public String getLoginMessage(By messageLocator){
        return getText(messageLocator);
    }

    /**
     * Gets the invalid login error message.
     * @return The invalid login error message as a string.
     */
    public String getInvalidLoginErrorMessage(){
        return getLoginMessage(errorMessage);
    }

    /**
     * Gets the success login message.
     * @return The success login message as a string.
     */
    public String getSuccessLoginMessage(){
        return getLoginMessage(successMessage);
    }

    public void setDismissBanner(){
        if (isDisplayed(dismissBanner)){
            scrollUp();
            clickElement(dismissBanner);
        }
    }
}
