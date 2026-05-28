import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pageObjects.MainPage;
import pageObjects.PersonalInformationFormPage;
import pageObjects.RentScooterFormPage;

import static org.junit.Assert.assertTrue;

public class ScooterTests {

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
        PersonalInformationFormPage personalInformationFormPage = mainPage.clickTopOrderButton();
        personalInformationFormPage.setPersonalInformation("Кузя", "Пельмешкин", "Агаповка, дом 3", "+79652743654");
        RentScooterFormPage rentScooterFormPage = personalInformationFormPage.clickNextButton();
        rentScooterFormPage.setRentScooterInformation("27.05.2026", "-");
        rentScooterFormPage.clickConfirmOrderButton();
        assertTrue(rentScooterFormPage.isConfirmOrderMessageDisplayed());
    }
}
