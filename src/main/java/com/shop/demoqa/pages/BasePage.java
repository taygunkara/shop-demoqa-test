package com.shop.demoqa.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Represents the base page.
 */

// TODO ADD DOCS
public class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver){
        this.driver = driver;
    }


    /**
     * Find web element with expected conditions.
     */
    public WebElement findElement(By locator){
        return driver.findElement(locator);
    }

    /**
     * Click element with expected conditions.
     */
    public void clickElement(By locator){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(findElement(locator)));
        findElement(locator).click();
    }

    /**
     * Type a text to the locator.
     */
    public void type(By locator, String text){
        findElement(locator).sendKeys(text);
    }

    /**
     * The process waits until the locator appears.
     */
    public void waitUntilItemShowsUp(By locator){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1000));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    static void delay() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public void clear(By locator){
        findElement(locator).clear();
    }
}
