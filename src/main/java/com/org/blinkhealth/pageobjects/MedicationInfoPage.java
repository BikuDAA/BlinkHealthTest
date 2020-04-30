package com.org.blinkhealth.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class MedicationInfoPage {
    private WebDriver driver;

    @FindBy(xpath = "//*[@id=\"app\"]/div/div[2]/div/span/div[1]/div[1]/div/span/span[1]/h1")
    public WebElement medication_title;

    @FindBy(linkText = "More Info")
    public WebElement moreInfoLink;

    @FindBy(xpath = "//*[@id=\"app\"]/div/div[3]/div/div[5]/div/div[2]/p[2]")
    public WebElement disclosureFooter;

    @FindBy(xpath = "//div[@id='app']/div/div[2]/div/span/div[3]/span/div/div/span/span[2]/button/span")
    public WebElement addToCartButton;

    @FindBy(xpath = "//*[@id=\"react-select-3--value\"]/div[2]")
    public WebElement medicationType;

    @FindBy(xpath = "//*[@id=\"react-select-3--value-item\"]")
    public WebElement medicationDosage;

    @FindBy(xpath = "//*[@id=\"react-select-4--value-item\"]")
    public WebElement medicationCounts;



    public MedicationInfoPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void scrollPageToBottom(){
        try {
            long lastHeight = (long) ((JavascriptExecutor) driver).executeScript("return document.body.scrollHeight");

            while (true) {
                ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
                Thread.sleep(2000);

                long newHeight = (long) ((JavascriptExecutor) driver).executeScript("return document.body.scrollHeight");
                if (newHeight == lastHeight) {
                    break;
                }
                lastHeight = newHeight;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void scrollPageToTop(){
        try {
            long lastHeight = (long) ((JavascriptExecutor) driver).executeScript("return document.body.scrollHeight");

            while (true) {
                ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0);");
                Thread.sleep(2000);

                long newHeight = (long) ((JavascriptExecutor) driver).executeScript("return document.body.scrollHeight");
                if (newHeight == lastHeight) {
                    break;
                }
                lastHeight = newHeight;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
