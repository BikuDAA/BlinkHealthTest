package com.org.blinkhealth.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private WebDriver driver;

    @FindBy(id = "email")
    private WebElement user_email;

    @FindBy(id = "password")
    private WebElement user_password;

    @FindBy(xpath = "//div[@id='app']/div/div/div[2]/div/div/div[2]/div/form/div/div/span/button/span")
    private WebElement loginButton;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void login(String email, String passwd) {
        user_email.sendKeys(email);
        user_password.sendKeys(passwd);
        loginButton.click();
    }
}
