package pageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {

    private WebDriver driver;

    //кнопка принятие cookie
    private final By acceptCookieButton = By.id("rcc-confirm-button");
    //элемент списка в разделе "Вопросы о важном"
    private final By accordionButton = By.id("accordion__heading-0");
    //элемент ответа на вопрос в разделе "Вопросы о важном"
    private final By accordionAnswer = By.id("accordion__panel-0");
    //кнопка "Заказать" сверху страницы
    private final By topOrderButton = By.className("Button_Button__ra12g");
    //кнопка "Заказать" снизу страницы
    private final By bottomOrderButton = By.className("Button_Middle__1CSJM");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickAcceptCookieButton() {
        driver.findElement(acceptCookieButton).click();
    }

    public void clickAccordionButton() {
        driver.findElement(accordionButton).click();
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
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }

    public boolean isQuestionAboutImportantThingsAnswerDisplayed() {
        return driver.findElement(accordionAnswer).isDisplayed();
    }

}
