package com.shop.demoqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


/**
 * Represents the login page.
 */
public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public final By usernameInput = By.xpath("//input[@id='username']");
    public final By passwordInput = By.xpath("//input[@id='password']");
    public final By rememberMeInput = By.xpath("//input[@id='rememberme']");
    public final By loginButton = By.xpath("//button[@name='login']");
    public final By errorMessage = By.xpath("//ul[@class='woocommerce-error']");
    public final By successMessage = By.xpath("//div[@class='woocommerce-MyAccount-content']//p[strong]");

    // FIXME restore methods back to original state

    /**
     * Method for type username.
     */
    public void setUsername(String username){
        type(usernameInput, username);
    }

    /**
     * Method for type password.
     */
    public void setPassword(String password){
        type(passwordInput, password);
    }

    public void clearCredentials() {
        clear(usernameInput);
        clear(passwordInput);

    }

    public void setLogin(String username, String password){
        setUsername(username);
        setPassword(password);
        clickElement(rememberMeInput);
        clickElement(loginButton);
    }

    /**
     * Method for get message.
     */
    public String getLoginMessage(By messageLocator){
        // waitUntilItemShowsUp(messageLocator);
        return getText(messageLocator);
        // return findElement(messageLocator).getText();
    }

    /**
     * Method for get error login message.
     */
    public String getInvalidLoginMessage(){
        return getLoginMessage(errorMessage);
    }

    /**
     * Method for get success login message.
     */
    public String getSuccessLoginMessage(){
        return getLoginMessage(successMessage);
    }
}
