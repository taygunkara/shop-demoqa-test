package com.shop.demoqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



// FIXME METHOD NAMES SHOULD BE CLEARER THAN NOW

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
    public final By invalidMessage = By.xpath("//a[@title='Password Lost and Found']");

    //ul[@class='woocommerce-error']
    public final By msg = By.xpath("//ul[@class='woocommerce-error']");
    public final String invalidMessageTitle = "Lost your password";


    /**
     * Method for login.
     */
    public void setLogin(String username, String password){
        type(usernameInput, username);
        type(passwordInput, password);
        clickElement(rememberMeInput);
        clickElement(loginButton);
    }

    /**
     * Method for get error message.
     */
    public String getInvalidLoginMessage(){
        waitUntilItemShowsUp(msg);
        return findElement(msg).getText();
    }

    /**
     * Method for check the login.
     */
    public Boolean isLoggedIn(){
        return !getInvalidLoginMessage().equals(invalidMessageTitle);
    }

}
