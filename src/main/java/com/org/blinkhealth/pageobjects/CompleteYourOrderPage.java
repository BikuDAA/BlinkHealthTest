package com.org.blinkhealth.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CompleteYourOrderPage {
    private WebDriver driver;

    @FindBy(xpath = "//*[@id=\"app\"]/div/div[1]/div[2]/div/div[1]/div[2]/div[1]/div[2]/form/div/label/div/div/div/iframe")
    public WebElement cardNumber;

    @FindBy(xpath = "//*[@id=\"app\"]/div/div[1]/div[2]/div/div[1]/div[2]/div[1]/div[2]/form/div/span/label[1]/div/div/div/iframe")
    public WebElement expDate;

    @FindBy(xpath = "//*[@id=\"app\"]/div/div[1]/div[2]/div/div[1]/div[2]/div[1]/div[2]/form/div/span/label[2]/div/div/div/iframe")
    public WebElement cvc;

    @FindBy(xpath = "//div[@id='app']/div/div/div[2]/div/div/div[2]/div[2]/div/div/div[2]/button/span")
    public WebElement completePurchaseButton;

    @FindBy(xpath = "//*[@id=\"app\"]/div/div[1]/div[2]/div/div[1]/div[1]/div/div/div")
    public WebElement pageBannerTitle;


    public CompleteYourOrderPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void fillCardInfoAndSubmit(String cardNumber, String expDate, String cvc) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.cardNumber.click();
        this.cardNumber.sendKeys(cardNumber);
        this.expDate.click();
        this.expDate.sendKeys(expDate);
        this.cvc.click();
        this.cvc.sendKeys(cvc);
        this.completePurchaseButton.click();
    }

    public String getPaymentErrorDetails() {
        String errorMessageLoc = "//*[@id=\"app\"]/div/div[1]/div[2]/div/div[1]/div[2]/div[2]/div/div/div[2]/div[1]";
        return driver.findElement(By.xpath(errorMessageLoc)).getText();
    }

    public String getPageTitle() {
        return this.pageBannerTitle.getText();
    }

    public void completePurchase() {
        try {
            Thread.sleep(2000);
            driver.findElement(By.xpath("//div[@id='app']/div/div/div[2]/div/div/div[2]/div[2]/div/div/div[2]/button/span")).click();
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
