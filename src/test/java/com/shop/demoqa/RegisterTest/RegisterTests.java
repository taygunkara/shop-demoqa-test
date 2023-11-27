package com.shop.demoqa.RegisterTest;

import com.shop.demoqa.BaseTest;
import com.shop.demoqa.RegisterPage.RegisterPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RegisterTests extends BaseTest {
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
