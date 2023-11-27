package com.shop.demoqa.RegisterPage;

import com.shop.demoqa.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage extends BasePage {
    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    public final By registrationUsernameInput = By.xpath("//input[@id='reg_username']");
    public final By registrationEmailInput = By.xpath("//input[@id='reg_email']");
    public final By registrationPasswordInput = By.xpath("//input[@id='reg_password']");
    public final By registerButton = By.xpath("//button[@value='Register']");


    // FIXME RENAME VARIABLES
    public final String username = "username";
    public final String email = "email@email.com";
    public final String password = "password123";


    // TODO SAME METHOD FOR LOGIN PAGE SO CREATE METHOD IN BASE OR IN MODEL PAGE
    public void setUsername(String username) {
        type(registrationUsernameInput, username);
    }
    public void setEmail(String email) {
        type(registrationEmailInput, email);
    }
    public void setPassword(String password) {
        type(registrationPasswordInput, password);
    }

    public void setRegister(String username, String email, String password){
        setUsername(username);
        setEmail(email);
        setPassword(password);
        clickElement(registerButton);
    }

    public void setValidRegister(){
        setRegister(username, email, password);
    }

}
