package page_object_model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class FaqPageModel {
    private WebDriver driver;

    // Div блоки вопросов
    private final By arrowsQuestions = By.cssSelector(".accordion__button::before");
    // Отрывшийся выпадающий список
    private final By openAnswer = By.xpath(
            ".//div[@class =\"accordion__item\"]//div[@class=\"accordion__panel\"]//p"
    );

    public FaqPageModel(WebDriver driver){
        this.driver = driver;
    }

    private List<WebElement> getListElementsWithArrows(){
        return driver.findElements(arrowsQuestions);
    }
    public void openAllArrowsAndCheck(){
        for (WebElement arrow: getListElementsWithArrows()) {
            arrow.click();
            new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(openAnswer));
        }
    }
}
