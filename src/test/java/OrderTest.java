import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pages.AboutRentPageModel;
import pages.MainPageModel;
import pages.OrderUserInfoPageModel;

@RunWith(Parameterized.class)
public class OrderTest extends BaseTest {

    private final String firstName;
    private final String lastName;
    private final String address;
    private final String metroStation;
    private final String phone;

    private final String day;
    private final String timeInterval;
    private final String color;
    private final String message;

    public OrderTest(String firstName, String lastName, String address, String metroStation, String phone, String day, String timeInterval, String color, String message){
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.metroStation = metroStation;
        this.phone = phone;

        this.day = day;
        this.timeInterval = timeInterval;
        this.color = color;
        this.message = message;
    }

    @Parameterized.Parameters
    public static Object[][] getTestData(){
        return new Object[][] {
//                {"Николай", "Елецкий", "Пушкина д 19", "Сокольники", "88182470008", "10", "сутки", "black", "2 подъезд"},
                {"Юлия", "Черенкова", "Мира д 185", "Лубянка", "89148659484", "20", "трое сутки", "gray", "Красный дом возле магазина"}
        };
    }


    @Test
    public void orderFromHead(){
        new MainPageModel(driver).clickForOrderInHeader();

        OrderUserInfoPageModel orderUserInfoPage = new OrderUserInfoPageModel(driver);
        orderUserInfoPage.writeUserInOrder(firstName, lastName, address, metroStation, phone);

        AboutRentPageModel aboutRentPage = new AboutRentPageModel(driver);
        aboutRentPage.writeInformationAboutRent(day, timeInterval, color, message);
        aboutRentPage.finallyConfirmOrder();
        aboutRentPage.checkSuccessfulWindow();
    }
}
