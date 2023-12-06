package com.shop.demoqa.pages;


import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;


/**
 * The BasePage class serves as the foundation for other page classes in a web application.
 * It provides common methods and functionalities that are used across different pages,
 * such as finding elements, clicking, typing, waiting, and checking visibility.
 */
public class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver){
        this.driver = driver;
    }

    /**
     * Finds a web element using the provided locator.
     *
     * @param locator The locator strategy and value to identify the web element.
     * @return The WebElement corresponding to the provided locator.
     */
    public WebElement findElement(By locator){
        return driver.findElement(locator);
    }

    /**
     * Clicks on a web element identified by the provided locator after waiting for it to be clickable.
     *
     * @param locator The locator strategy and value to identify the web element.
     */
    public void clickElement(By locator){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(findElement(locator)));
        findElement(locator).click();
    }

    /**
     * Types the specified text into an input field identified by the provided locator.
     *
     * @param locator The locator strategy and value to identify the input field.
     * @param text    The text to be typed into the input field.
     */
    public void type(By locator, String text){
        findElement(locator).sendKeys(text);
    }

    /**
     * Waits until the specified item is visible on the page.
     *
     * @param locator The locator strategy and value to identify the item.
     */
    public void waitUntilItemShowsUp(By locator){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1000));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    /**
     * Simulates pressing the Enter key on the web element identified by the provided locator.
     *
     * @param locator The locator strategy and value to identify the web element.
     */
    public void clickEnter(By locator){
        findElement(locator).sendKeys(Keys.RETURN);
    }

    /**
     * Clears the text from the input field identified by the provided locator.
     *
     * @param locator The locator strategy and value to identify the input field.
     */
    public void clear(By locator){
        findElement(locator).clear();
    }

    /**
     * Checks if the web element identified by the provided locator is displayed.
     *
     * @param locator The locator strategy and value to identify the web element.
     * @return True if the web element is displayed; otherwise, false.
     */
    public Boolean isDisplayed(By locator){
        return findElement(locator).isDisplayed();
    }

    /**
     * Retrieves the visible text of the web element identified by the provided locator.
     *
     * @param locator The locator strategy and value to identify the web element.
     * @return The visible text of the web element.
     */
    public String getText(By locator){
        return findElement(locator).getText();
    }

    /**
     * Scrolls down the page by a specified amount.
     */
    public void scrollDown(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,600)");
    }

    public void scrollUp(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,0)");
    }

    /**
     * Static method to introduce a delay of 1 second.
     */
    static void delay() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String getAlertMessage(){
        Alert alert = driver.switchTo().alert();
        return alert.getText();
    }

    public void dismissAlert(){
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
    }

    public String getAttribute(By locator, String attribute){
        return findElement(locator).getAttribute(attribute);
    }

}
