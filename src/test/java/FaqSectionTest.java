import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pages.FaqPageModel;

@RunWith(Parameterized.class)
public class FaqSectionTest extends BaseTest {
    private final String question;
    private final String answer;

    public FaqSectionTest(String question, String answer){
        this.question =question;
        this.answer = answer;
    }

    @Parameterized.Parameters
    public static Object[][] getTestData(){
        return new Object[][] {
                {"Можно ли заказать самокат прямо на сегодня?", "Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
                {"Я жизу за МКАДом, привезёте?", "Да, обязательно. Всем самокатов! И Москве, и Московской области."}
        };
    }

    @Test
    public void openQuestionAndCheck(){
        FaqPageModel faqPage = new FaqPageModel(driver);
        faqPage.openArrowAndCheck(question, answer);
    }
}
