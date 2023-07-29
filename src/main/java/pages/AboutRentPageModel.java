package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AboutRentPageModel {
    private WebDriver driver;

    private final By fieldDateOrder = By.xpath("//input[@placeholder=\"* Когда привезти самокат\"]");
    private final By timeIntervalOrder = By.className("Dropdown-control");
    // Строка для создания Локатора Ответа
    private final String locatorStringFindInterval = ".//div[@class=\"Dropdown-option\" and text()=\"%s\"]";
    private final By orderMessage = By.xpath(".//input[@placeholder=\"Комментарий для курьера\"]");
    private final By orderNextButton = By.xpath(".//button[@text=\"Заказать\"]");

    public AboutRentPageModel(WebDriver driver){
        this.driver = driver;
    }

    public void writeComment(String message){
        driver.findElement(orderMessage).clear();
        driver.findElement(orderMessage).sendKeys(message);
    }

    public void selectColor(String color){
        driver.findElement(By.id(color)).click();
    }

    public void selectTimeInterval(String timeInterval){
        String locatorInterval = String.format(locatorStringFindInterval, timeInterval);

        driver.findElement(timeIntervalOrder).click();
        driver.findElement(By.xpath(locatorInterval)).click();
    }


    public void writeInformationAboutRent(String dateTime, String timeInterval, String color, String message){
        selectTimeInterval(timeInterval);
        selectColor(color);
        writeComment(message);
    }

}
