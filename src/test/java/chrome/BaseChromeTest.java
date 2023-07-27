package chrome;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseChromeTest {
    public WebDriver driver;

    @Before
    public void setUp(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--disable-dev-shm-usage", "--remote-allow-origins=*");
        options.setBinary("C:\\Users\\k.nistratov\\chromedriver.exe");
        driver = new ChromeDriver(options);

        driver.get("https://qa-scooter.praktikum-services.ru/");
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
