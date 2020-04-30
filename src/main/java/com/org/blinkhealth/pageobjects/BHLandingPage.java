package com.org.blinkhealth.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class BHLandingPage {
    private WebDriver driver;


    @FindBy(xpath = "//div[@id='header']/div/div/div/div/div/div[2]/div[3]/div/span/a/span/span")
    private WebElement logIn;

    public BHLandingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickLogin() {
        logIn.click();
    }
}
