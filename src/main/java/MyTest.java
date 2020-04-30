import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MyTest {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/lib/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.blinkhealth.com/?xp=control");
        System.out.println(driver.getTitle());
        driver.quit();
    }
}
