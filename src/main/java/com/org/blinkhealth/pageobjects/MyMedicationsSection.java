package com.org.blinkhealth.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyMedicationsSection {
    private WebDriver driver;

    @FindBy(xpath = "//*[@id=\"app\"]/div/div[2]/div/div/div/div[2]/h2")
    private WebElement title;


    public MyMedicationsSection(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getTitle() {
        return title.getText();
    }
}
