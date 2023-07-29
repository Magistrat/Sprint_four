package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AboutRentPageModel {
    private WebDriver driver;

    private final By fieldDateOrder = By.xpath("//input[@placeholder=\"* Когда привезти самокат\"]");
    private final By timeIntervalOrder = By.className("Dropdown-control");
    private final By colorBlackInOrder = By.id("black");
    private final By colorGreyInOrder = By.id("grey");
    private final By orderMessage = By.xpath(".//input[placeholder=\"Комментарий для курьера\"]");
    private final By orderNextButton = By.xpath(".//button[@text=\"Заказать\"]");

    public AboutRentPageModel(WebDriver driver){
        this.driver = driver;
    }

    public void writeComment(String message){
        driver.findElement(orderMessage).clear();
        driver.findElement(orderMessage).sendKeys(message);
    }




}
