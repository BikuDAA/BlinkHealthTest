package com.org.blinkhealth.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage {
    private WebDriver driver;

    @FindBy(xpath = "//div[@id='app']/div/div[2]/div/div/div/div/span/button/span")
    public WebElement continueToChecoutButton;

    @FindBy(xpath = "//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div[1]/div/div/span/span[2]")
    private WebElement purchaseTotal;

    public ShoppingCartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getPurchaseTotal(){
        return purchaseTotal.getText();
    }

}
