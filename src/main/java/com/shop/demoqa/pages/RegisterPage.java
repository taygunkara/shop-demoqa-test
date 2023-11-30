package com.shop.demoqa.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

// TODO ADD DOCS -- FIXME DOCS

public class RegisterPage extends BasePage {
    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    public final By registrationUsernameInput = By.xpath("//input[@id='reg_username']");
    public final By registrationEmailInput = By.xpath("//input[@id='reg_email']");
    public final By registrationPasswordInput = By.xpath("//input[@id='reg_password']");
    public final By registerButton = By.xpath("//*[@id=\"customer_login\"]/div[2]/form/p[4]/button");
    public final By successMessage = By.xpath("//div[@class='woocommerce-MyAccount-content']//p[strong]");
    public final By errorMessage = By.xpath("//ul[@class='woocommerce-error']");
    public final By errorWeakPassword = By.cssSelector("div[class='woocommerce-password-strength short']");

    /**
     * Method for type username.
     */
    public void setUsername(String username){
        type(registrationUsernameInput, username);
    }
    /**
     * Method for type email.
     */
    public void setEmail(String email){
        type(registrationEmailInput, email);
    }

    /**
     * Method for type password.
     */
    public void setPassword(String password){
        type(registrationPasswordInput, password);
    }

    /**
     * Method for type register info.
     */
    public void setRegisterInfo(String username, String email, String password){
        setUsername(username);
        setEmail(email);
        setPassword(password);
        delay();
    }

    // FIXME CANT CLICK WHEN PASSWORD HINT OCCURS
    public void createAnAccount(String username, String email, String password){
        setRegisterInfo(username, email, password);
        clickElement(registerButton);
    }

    public void setWeakPassword(String username, String email, String weakPassword) {
        setRegisterInfo(username, email, weakPassword);
        clickElement(registrationUsernameInput); // Without any clicking area, alert is not showing.
    }

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
