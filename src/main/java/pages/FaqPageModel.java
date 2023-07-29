package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class FaqPageModel {
    private WebDriver driver;
    // Локатор для проверки загрузки страницы
    private final By pageIsLoaded = By.cssSelector(".Home_BluePrint__TGX2n img");
    // Строка для создания Локатора Вопроса
    private final String locatorStringFindQuestion = ".//div[contains(@id, \"accordion__heading\") and text()=\"%s\"]";
    // Строка для создания Локатора Ответа
    private final String locatorStringFindAnswer = ".//div[@class=\"accordion__panel\"]//p[text()=\"%s\"]";
    public FaqPageModel(WebDriver driver){
        this.driver = driver;
    }

    public void checkPageIsLoad(){
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(pageIsLoaded));
    }

    public void openArrowAndCheck(String question, String answer){
        String questionLocator = String.format(locatorStringFindQuestion, question);
        checkPageIsLoad();

        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath(questionLocator)));
        new WebDriverWait(driver, 10).until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath(questionLocator)
                )
        );
        driver.findElement(By.xpath(questionLocator)).click();

        String answerLocator = String.format(locatorStringFindAnswer, answer);
        new WebDriverWait(driver, 10).until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath(answerLocator)
                )
        );
    }
}
