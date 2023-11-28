package com.shop.demoqa.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage extends BasePage {
    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    public final By registrationUsernameInput = By.xpath("//input[@id='reg_username']");
    public final By registrationEmailInput = By.xpath("//input[@id='reg_email']");
    public final By registrationPasswordInput = By.xpath("//input[@id='reg_password']");
    public final By registerButton = By.xpath("//button[@name='register']");
    public final By successMessage = By.xpath("//div[@class='woocommerce-MyAccount-content']//p[strong]");
    public final By errorMessage = By.xpath("//ul[@class='woocommerce-error']");
    public final By errorWeakPassword = By.cssSelector("div[class='woocommerce-password-strength short']");

    // FIXME CANT CLICK WHEN PASSWORD HINT OCCURS
    public void createAnAccount(String username, String email, String password){
        type(registrationUsernameInput, username);
        type(registrationEmailInput, email);
        type(registrationPasswordInput, password);
        clickElement(registerButton);
    }

    // FIXME REGISTER & LOGIN SAME GET MESSAGE PROCESS
    public String getRegisterMessage(By messageLocator){
        waitUntilItemShowsUp(messageLocator);
        return findElement(messageLocator).getText();
    }

    public String getSuccessRegisterMessage(){
        return getRegisterMessage(successMessage);
    }

    public String getInvalidRegisterMessage(){
        return getRegisterMessage(errorMessage);
    }

    // FIXME RENAME
    public String getWeakPasswordMessage(){
        return getRegisterMessage(errorWeakPassword);
    }

}
