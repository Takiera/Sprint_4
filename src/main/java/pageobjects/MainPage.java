package pageobjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {

    private WebDriver driver;

    private final String URL = "https://qa-scooter.praktikum-services.ru/";

    //кнопка принятие cookie
    private final By acceptCookieButton = By.id("rcc-confirm-button");
    //кнопка "Заказать" сверху страницы
    private final By topOrderButton = By.className("Button_Button__ra12g");
    //кнопка "Заказать" снизу страницы
    private final By bottomOrderButton = By.className("Button_Middle__1CSJM");

    //получение локатора для вопроса
    private By getAccordionButtonLocator(int questionId) {
        String id = String.format("accordion__heading-%d", questionId);
        return By.id(id);
    }

    //получение локатора для ответа
    private By getAccordionAnswerLocator(int answerId) {
        String id = String.format("accordion__heading-%d", answerId);
        return By.id(id);
    }

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickAcceptCookieButton() {
        if (!driver.findElements(acceptCookieButton).isEmpty()) {
            driver.findElement(acceptCookieButton).click();
        }
    }

    public void clickAccordionButton(int questionId) {
        driver.findElement(getAccordionButtonLocator(questionId)).click();
    }

    public PersonalInformationFormPage clickTopOrderButton() {
        driver.findElement(topOrderButton).click();
        return new PersonalInformationFormPage(driver);
    }

    public PersonalInformationFormPage clickBottomOrderButton() {
        driver.findElement(bottomOrderButton).click();
        return new PersonalInformationFormPage(driver);
    }

    public void openPage() {
        driver.get(URL);
    }

    public boolean isQuestionAboutImportantThingsAnswerDisplayed(int answerId) {
        return driver.findElement(getAccordionAnswerLocator(answerId)).isDisplayed();
    }

}
