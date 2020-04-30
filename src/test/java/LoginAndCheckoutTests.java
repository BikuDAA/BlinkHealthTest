import com.org.blinkhealth.pageobjects.*;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;


import java.util.concurrent.TimeUnit;

public class LoginAndCheckoutTests {
    public static final String USER_EMAIL = "bikash_automation_challenge@testblinkhealth.com";
    public static final String USER_PASSWORD = "hello123";
    public static final String BASE_URL_BLINKHEALTH = "http://www.blinkhealth.com/?xp=control";
    public static final String INVALID_VISA_CREDIT_CARD = "4242424242424242";

    public static WebDriver driver;

    @BeforeClass
    public static void setupBeforeTestSuite() {
        System.setProperty("webdriver.chrome.driver", "src/lib/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @Before
    public void setupBeforeTest() {
        driver.get(BASE_URL_BLINKHEALTH);
        System.out.println(driver.getTitle());

    }

    @Test
    public void testLoginNavigateAndCheckoutWithInvalidCreditCard() {
        BHLandingPage homePage = PageFactory.initElements(driver, BHLandingPage.class);
        homePage.clickLogin();
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.login(USER_EMAIL, USER_PASSWORD);

        UserProfilePage userProfilePage = PageFactory.initElements(driver, UserProfilePage.class);
        userProfilePage.navigateToProfileAndSettingsSection();

        Assert.assertEquals("Profile and Settings", userProfilePage.profileAndSettingsSection.getTitle());


        userProfilePage.searchMedication("Antacid");

        MedicationInfoPage medicationInfoPage = PageFactory.initElements(driver, MedicationInfoPage.class);
        medicationInfoPage.moreInfoLink.click();
        medicationInfoPage.scrollPageToBottom();
        Assert.assertTrue(medicationInfoPage.disclosureFooter.isDisplayed());
        medicationInfoPage.scrollPageToTop();

        medicationInfoPage.addToCartButton.click();

        ShoppingCartPage shoppingCartPage = PageFactory.initElements(driver, ShoppingCartPage.class);
        Assert.assertEquals("$1.91", shoppingCartPage.getPurchaseTotal());
        shoppingCartPage.continueToChecoutButton.click();

//        PatientInformationPage patientInformationPage = PageFactory.initElements(driver, PatientInformationPage.class);
//        patientInformationPage.continueButton.click();

        CompleteYourOrderPage completeYourOrderPage = PageFactory.initElements(driver, CompleteYourOrderPage.class);
//        completeYourOrderPage.fillCardInfoAndSubmit(INVALID_VISA_CREDIT_CARD, "0122", "112");

        String expectedErrorMessage = "Your card was declined.";
        completeYourOrderPage.completePurchase();
        Assert.assertEquals("Order not placed yet", expectedErrorMessage, completeYourOrderPage.getPaymentErrorDetails());


    }


    @After
    public void tearAfterTest() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }

    @AfterClass
    public static void tearAfterSuite() {

    }

}
