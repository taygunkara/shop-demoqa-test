package com.shop.demoqa.LoginPage;

import com.shop.demoqa.BasePage;
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


    // TODO CREATE CLASS FOR VARIABLES

    public final String invalidMessageTitle = "Lost your password";
    public final String validUsername = "123@gmail.com";
    public final String validPassword = "123";
    public final String invalidUsername = "123@gmail.com";
    public final String invalidPassword = "123";


    // TODO CREATE MODEL CLASS FOR GETTER & SETTER

    /**
     * Method for set username.
     */
    public void setUsername(String username) {
        type(usernameInput, username);
    }

    /**
     * Method for set password.
     */
    public void setPassword(String password) {
        type(passwordInput, password);
    }

    /**
     * Method for login.
     */
    public void setLogin(String username, String password){
        setUsername(username);
        setPassword(password);
        clickElement(rememberMeInput);
        clickElement(loginButton);
    }


    /**
     * Method for logging in with a valid username and password.
     */
    public void setValidLogin(){
        setLogin(validUsername, validPassword);
    }

    /**
     * Method for logging in with a valid username and invalid password.
     */
    public void setValidUsernameInvalidPassword(){
        setLogin(validUsername, invalidPassword);
    }

    /**
     * Method for logging in with an invalid username and valid password.
     */
    public void setInvalidUsernameValidPassword(){
        setLogin(invalidUsername, validPassword);
    }

    /**
     * Method for logging in with an invalid username and password.
     */
    public void setInvalidUsernameInvalidPassword(){
        setLogin(invalidUsername, invalidPassword);
    }


    public String getInvalidLoginMessage(){
        waitUntilItemShowsUp(invalidMessage);
        return findElement(invalidMessage).getText();
    }

    public Boolean isLoggedIn(){
        return !getInvalidLoginMessage().equals(invalidMessageTitle);
    }

}
