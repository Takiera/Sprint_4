import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import pageObjects.MainPage;
import pageObjects.PersonalInformationFormPage;
import pageObjects.RentScooterFormPage;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class ScooterTests {

    private final String name;
    private final String surname;
    private final String address;
    private final String phone;
    private final String date;
    private final String comment;
    private final String buttonLocation;

    public ScooterTests(String name, String surname, String address, String phone, String date, String comment, String buttonLocation) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.phone = phone;
        this.date = date;
        this.comment = comment;
        this.buttonLocation = buttonLocation;

    }

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][] {
                {"Бенджамин", "Ковалевич", "Русаковская улица, 28", "+79845623476", "05.06.2026", "Самый рокерский самокат, пожалуйста", "top"},
                {"Серж", "Танкян", "Песочный переулок, 3", "+79843923816", "07.06.2026", "Без комментариев", "bottom"}
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
        mainPage.clickAccordionButton();
        assertTrue(mainPage.isQuestionAboutImportantThingsAnswerDisplayed());
    }

    @Test
    public void checkMakeOrderWithCorrectData() {
        WebDriver driver = factoryDriver.getDriver();
        MainPage mainPage = new MainPage(driver);
        mainPage.openPage();
        mainPage.clickAcceptCookieButton();
        PersonalInformationFormPage personalInformationFormPage;
        if ("top".equals(buttonLocation)) {
            personalInformationFormPage = mainPage.clickTopOrderButton();
        } else {
            personalInformationFormPage = mainPage.clickBottomOrderButton();
        }
        personalInformationFormPage.setPersonalInformation(name, surname, address, phone);
        RentScooterFormPage rentScooterFormPage = personalInformationFormPage.clickNextButton();
        rentScooterFormPage.setRentScooterInformation(date, comment);
        rentScooterFormPage.clickConfirmOrderButton();
        assertTrue("Сообщение об успешном оформлении заказа не отображается",rentScooterFormPage.isConfirmOrderMessageDisplayed());
    }
}
