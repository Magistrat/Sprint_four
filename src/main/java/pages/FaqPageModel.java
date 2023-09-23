package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class FaqPageModel {
    private final WebDriver driver;

    // Локатор для проверки загрузки страницы
    private final By pageIsLoaded = By.cssSelector(".Home_BluePrint__TGX2n img");
    // Метод для создания Локатора Вопроса (объекта By)
    private By getLocatorQuestion(String question){
        String locatorQuestion = String.format(".//div[contains(@id, \"accordion__heading\") and text()=\"%s\"]", question);
        return By.xpath(locatorQuestion);
    }
    // Метод для создания Локатора Ответа
    private By getLocatorAnswer(String answer){
        String locatorAnswer = String.format(".//div[@class=\"accordion__panel\"]//p[text()=\"%s\"]", answer);
        return By.xpath(locatorAnswer);
    }

    public FaqPageModel(WebDriver driver){
        this.driver = driver;
    }

    public void checkPageIsLoad(){
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(pageIsLoaded));
    }

    public void openArrowAndCheck(String question, String answer){
        checkPageIsLoad();

        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(getLocatorQuestion(question)));
        new WebDriverWait(driver, 10).until(
                ExpectedConditions.visibilityOfElementLocated(
                        getLocatorQuestion(question)
                )
        );
        driver.findElement(getLocatorQuestion(question)).click();

        new WebDriverWait(driver, 10).until(
                ExpectedConditions.visibilityOfElementLocated(
                        getLocatorAnswer(answer)
                )
        );
    }
}
