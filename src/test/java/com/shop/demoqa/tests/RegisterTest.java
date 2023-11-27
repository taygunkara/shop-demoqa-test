package com.shop.demoqa.tests;

import com.shop.demoqa.pages.RegisterPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RegisterTest extends BaseTest {
    private RegisterPage registerPage;

    @BeforeEach
    public void start(){
        setUp();
        navigateToLoginAndRegisterPage();
        registerPage = new RegisterPage(driver);

    }

    @Test
    public void ShouldBeAbleToCreateAnAccount(){
    }

}
