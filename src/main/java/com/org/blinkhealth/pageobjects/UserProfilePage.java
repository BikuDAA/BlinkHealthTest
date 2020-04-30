package com.org.blinkhealth.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserProfilePage {
    private WebDriver driver;

    @FindBy(xpath = "//*[@id=\"app\"]/div/div[2]/div/div/div/div[2]/h2")
    private WebElement title;

    @FindBy(name = "med-search")
    private WebElement searchMedicationBar;

    @FindBy(css = "span._22s4z > svg")
    private WebElement searchMedicationButton;


    @FindBy(xpath = "//*[@id=\"app\"]/div/div[2]/div/div/div/div[1]/div[1]/span[2]/button[4]/span")
    private WebElement profileAndSettingsPane;

    public final ProfileAndSettingsSection profileAndSettingsSection;


    public UserProfilePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        profileAndSettingsSection = new ProfileAndSettingsSection(driver);
    }

    public String getTitle() {
        return title.getText();
    }

    public void navigateToProfileAndSettingsSection() {
        profileAndSettingsPane.click();
    }

    public void searchMedication(String medicationName){
        searchMedicationBar.click();
        searchMedicationBar.sendKeys(medicationName);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        driver.findElement(By.xpath("//*[@id=\"search\"]/div[2]/div"))
        //searchMedicationBar.findElement(By.linkText(medicationName));
        searchMedicationButton.click();
    }


}


