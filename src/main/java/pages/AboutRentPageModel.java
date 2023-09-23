package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.StringContains.containsString;

public class AboutRentPageModel {
    private final WebDriver driver;

    // Поле ввода даты для заказа
    private final By fieldDateOrder = By.xpath("//input[@placeholder=\"* Когда привезти самокат\"]");
    // Метод для создания Локатора (объекта By) - Поиска дня в календаре
    private By getLocatorDayForCalendar(String day){
        String locatorDay = String.format(".//div[@class=\"react-datepicker__month\"]//div[text()=\"%s\"]", day);
        return By.xpath(locatorDay);
    }
    // Поле срока аренды
    private final By timeIntervalOrder = By.className("Dropdown-control");
    // Метод для создания Локатора (объекта By) - Элемента для выбора срока аренды
    private By getLocatorRentInterval(String timeInterval){
        String locatorRentInterval = String.format(".//div[@class=\"Dropdown-option\" and text()=\"%s\"]", timeInterval);
        return By.xpath(locatorRentInterval);
    }
    // Поле ввода Комментаря для заказа
    private final By orderMessage = By.xpath(".//input[@placeholder=\"Комментарий для курьера\"]");
    // Кнопка Далее
    private final By orderNextButton = By.xpath(".//div[@class=\"Order_Buttons__1xGrp\"]//button[text() =\"Заказать\"]");
    // Кнопка Да (подтверждение заказа)
    private final By orderConfirmYesButton = By.xpath(".//button[text() = \"Да\"]");
    // Окно с информацией подтверждения заказа
    private final By successfulWindow = By.className("Order_Modal__YZ-d3");
    // Текст о подтвержденном заказе
    private final By successfulMessage = By.className("Order_ModalHeader__3FDaJ");

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
        driver.findElement(timeIntervalOrder).click();
        driver.findElement(getLocatorRentInterval(timeInterval)).click();
    }

    public void selectDateOnCalendar(String day){
        driver.findElement(fieldDateOrder).click();
        driver.findElement(getLocatorDayForCalendar(day)).click();
    }

    public void writeInformationAboutRent(String day, String timeInterval, String color, String message){
        selectDateOnCalendar(day);
        selectTimeInterval(timeInterval);
        selectColor(color);
        writeComment(message);
    }

    public void finallyConfirmOrder(){
        driver.findElement(orderNextButton).click();
        driver.findElement(orderConfirmYesButton).click();
    }

    public void checkSuccessfulWindow(){
        new WebDriverWait(driver, 10).until(
                ExpectedConditions.visibilityOfElementLocated(
                        successfulWindow
                )
        );

        String messageFromWindow = driver.findElement(successfulMessage).getText();
        assertThat(messageFromWindow, containsString("Заказ оформлен"));
    }

}
