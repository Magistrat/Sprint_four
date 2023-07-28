package firefox;

import org.junit.Test;
import pages.FaqPageModel;

public class FaqSectionTest extends BaseFirefoxTest {

    @Test
    public void openQuestionAndCheck(){
        new FaqPageModel(driver).openAllArrowsAndCheck();
    }
}
