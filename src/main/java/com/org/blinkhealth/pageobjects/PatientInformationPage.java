package com.org.blinkhealth.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PatientInformationPage {
    private WebDriver driver;

    @FindBy(id = "firstName")
    private WebElement firstName;

    @FindBy(id = "lastName")
    private WebElement lastName;

    @FindBy(id = "dob")
    private WebElement dateOfBirth;

    @FindBy(xpath = "//div[@id='app']/div/div/div[2]/div/div/div[2]/div/form/div/div/div[4]/span[2]/label/span")
    private WebElement optionMale;

    @FindBy(xpath = "//div[@id='app']/div/div/div[2]/div/div/div[2]/div/form/span/button/span")
    public WebElement continueButton;


    public PatientInformationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterPatientInfo(String firstName, String lastName, String dob, String gender) {
        this.firstName.sendKeys(firstName);
        this.lastName.sendKeys(lastName);
        this.dateOfBirth.sendKeys(dob);
        if (gender.equals("male")) {
            this.optionMale.click();
        } else {
            //TODO: add code for female
        }

    }

}