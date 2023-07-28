package firefox;

import org.junit.Test;
import page_object_model.FaqPageModel;

public class FaqSectionTest extends BaseFirefoxTest {

    @Test
    public void openQuestionAndCheck(){
        new FaqPageModel(driver).openAllArrowsAndCheck();
    }
}
