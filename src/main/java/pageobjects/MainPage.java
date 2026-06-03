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
    private By getAccordionButtonLocator(String questionText) {
        String question = String.format("//div[@class='accordion__button' and text()='%s']", questionText);
        return By.xpath(question);
    }

    //получение локатора для ответа
    private By getAccordionAnswerLocator(String answerText) {
        String answer = String.format("//div[@class='accordion__panel']/p[text()='%s']", answerText);
        return By.xpath(answer);
    }

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickAcceptCookieButton() {
        if (!driver.findElements(acceptCookieButton).isEmpty()) {
            driver.findElement(acceptCookieButton).click();
        }
    }

    public void clickAccordionButton(String questionText) {
        driver.findElement(getAccordionButtonLocator(questionText)).click();
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

    public boolean isQuestionAboutImportantThingsAnswerDisplayed(String answerText) {
        return driver.findElement(getAccordionAnswerLocator(answerText)).isDisplayed();
    }

}
