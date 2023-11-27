package com.shop.demoqa.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseTest {
    public WebDriver driver;
    public String BASE_URL = "https://shop.demoqa.com/";
    public String LOGIN_AND_REGISTER_PATH = "my-account/";

    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito").
                addArguments("--start-maximized").
                addArguments("--ignore-certificate-errors").
                addArguments("--allow-insecure-localhost").
                addArguments("--acceptInsecureCerts").
                addArguments("--disable-blink-features=AutomationControlled").
                addArguments("--disable-extensions");

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
    }

    public void navigateToHomePage() {
        driver.get(BASE_URL);
    }
    public void navigateToLoginAndRegisterPage() {
        driver.get(BASE_URL + LOGIN_AND_REGISTER_PATH);
    }

    public void tearDown() {
        driver.close();
        driver.quit();
    }
}
