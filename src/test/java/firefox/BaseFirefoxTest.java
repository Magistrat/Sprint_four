package firefox;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;


public class BaseFirefoxTest {
    WebDriver driver;
    @Before
    public void setUp(){
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--no-sandbox", "--disable-dev-shm-usage");
        driver = new FirefoxDriver();

        driver.get("https://qa-scooter.praktikum-services.ru/");
    }


    @After
    public void tearDown(){
        driver.quit();
    }
}
