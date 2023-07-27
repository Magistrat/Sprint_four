package chrome;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import page_object_model.FaqPageModel;

public class FaqSectionTest extends BaseChromeTest{

    @Test
    public void openQuestionAndCheck(){
        new FaqPageModel(driver).openAllArrowsAndCheck();
    }
}
