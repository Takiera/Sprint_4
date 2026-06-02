import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import pageobjects.MainPage;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class DropDownListTests {

    private final int questionId;
    private final int answerId;

    public DropDownListTests(int questionId, int answerId) {
        this.questionId = questionId;
        this.answerId = answerId;
    }


    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][] {
                {0, 0},
                {1, 1},
                {2, 2},
                {3, 3},
                {4, 4},
                {5, 5},
                {6, 6},
                {7, 7}
        };
    }

    @Rule
    public FactoryDriver factoryDriver = new FactoryDriver();


    @Test
    public void checkQuestionAboutImportantThingsClickShowAnswer() {
        WebDriver driver = factoryDriver.getDriver();
        MainPage mainPage = new MainPage(driver);
        mainPage.openPage();
        mainPage.clickAcceptCookieButton();
        mainPage.clickAccordionButton(questionId);
        assertTrue(mainPage.isQuestionAboutImportantThingsAnswerDisplayed(answerId));
    }

}
