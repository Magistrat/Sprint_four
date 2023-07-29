package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class OrderUserInfoPageModel {
    private final WebDriver driver;

    // Кнопка Далее (для перехеда на ввод дополнительной информации)
    private final By nextButtonConfirmOrder = By.xpath(".//button[text() = \"Далее\"]");
    // Поле Имя
    private final By fieldFirstName = By.xpath(".//input[@type = \"text\" and @placeholder = \"* Имя\"]");
    // Поле Фамилия
    private final By fieldLastName = By.xpath(".//input[@type = \"text\" and @placeholder = \"* Фамилия\"]");
    // Поле Адрес
    private final By fieldAddress = By.xpath(".//input[@type = \"text\" and @placeholder = \"* Адрес: куда привезти заказ\"]");
    // Поле Телефон
    private final By fieldPhone = By.xpath(".//input[@type = \"text\" and @placeholder = \"* Телефон: на него позвонит курьер\"]");
    // Поле Выбора станции Метро
    private final By fieldMetroStation = By.xpath("//input[@class= \"select-search__input\"]");
    // Метод для создания Локатора станции Метро в выпадающем списке (Объект By)
    private By getLocatorSelectMetro(String stationName){
        String locatorStation = String.format(".//div[@class=\"Order_Text__2broi\" and text()=\"%s\"]", stationName);
        return By.xpath(locatorStation);
    }

    public OrderUserInfoPageModel(WebDriver driver){
        this.driver = driver;
    }

    public void writeFirstNameOnField(String name){
        driver.findElement(fieldFirstName).clear();
        driver.findElement(fieldFirstName).sendKeys(name);
    }

    public void writeLastNameOnField(String lastName){
        driver.findElement(fieldLastName).clear();
        driver.findElement(fieldLastName).sendKeys(lastName);
    }

    public void writeAddressOnField(String address){
        driver.findElement(fieldAddress).clear();
        driver.findElement(fieldAddress).sendKeys(address);
    }

    public void writePhoneOnField(String phone){
        driver.findElement(fieldPhone).clear();
        driver.findElement(fieldPhone).sendKeys(phone);
    }

    public void selectMetroStation(String stationName){
        driver.findElement(fieldMetroStation).click();

        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(getLocatorSelectMetro(stationName)));
        driver.findElement(getLocatorSelectMetro(stationName)).click();
    }

    public void writeUserInOrder(String firstName, String lastName, String address, String metroStation, String phone){
        writeFirstNameOnField(firstName);
        writeLastNameOnField(lastName);
        writeAddressOnField(address);
        selectMetroStation(metroStation);
        writePhoneOnField(phone);

        driver.findElement(nextButtonConfirmOrder).click();
    }
}
