package com.shop.demoqa.testdata;

public class RegisterTestData {

    // FIXME RENAME VARIABLES
    public static final String VALID_USERNAME = "liipuyhfhkey";
    public static final String VALID_EMAIL = "ldtynbipkey@email.com";
    public static final String DUPLICATED_EMAIL = "ldtynbipkey@email.com";
    // -------------------------------------------------------------------
    public static final String STRONG_PASSWORD = "w?sd-ldw9213*0123*-*-3";
    public static final String WEAK_PASSWORD = "123";
    // -------------------------------------------------------------------
    public static final String VALID_REGISTER_MESSAGE = "Hello " +  VALID_USERNAME + " (not " + VALID_USERNAME + "? Log out)";
    public static final String DUPLICATED_EMAIL_MESSAGE = "Error: An account is already registered with your email address. Please log in.";
    public static final String MISSING_USERNAME_MESSAGE = "Error: Please enter a valid account username.";
    public static final String MISSING_EMAIL_MESSAGE = "Error: Please provide a valid email address.";
    public static final String MISSING_PASSWORD_MESSAGE = "Error: Please enter an account password.";
    public static final String WEAK_PASSWORD_MESSAGE = "Very weak - Please enter a stronger password.";
}
