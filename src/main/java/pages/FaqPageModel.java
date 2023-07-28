package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class FaqPageModel {
    private WebDriver driver;

    // Div блоки вопросов
    private final By arrowsQuestions = By.cssSelector(".accordion__button");
    // Отрывшийся выпадающий список
    private final By openAnswer = By.xpath(
            ".//div[@class =\"accordion__item\"]//div[@class=\"accordion__panel\"]//p"
    );

    public FaqPageModel(WebDriver driver){
        this.driver = driver;
    }

    public void openArrowAndCheck(String question, String answer){
        WebElement element = driver.findElement(By.id("root"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);


    }
}
