package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPageModel {
    private WebDriver driver;
    // Локатор Кнопки заказать из заголовка
    private final By orderButtonFromHeader = By.xpath(".//button[text()=\"Заказать\" and not(contains(@class, \"Button_Middle__1CSJM\"))]");
    // Локатор Кнопки заказать из середины страницы
    private final By orderButtonFromMiddleBody = By.xpath(".//button[text()=\"Заказать\" and contains(@class, \"Button_Middle__1CSJM\")]");
    public MainPageModel(WebDriver driver){
        this.driver = driver;
    }

    public void clickForOrderInHeader(){
        driver.findElement(orderButtonFromHeader).click();
    }

    public void clickForOrderInMiddleBody(){
        driver.findElement(orderButtonFromMiddleBody).click();
    }
}
