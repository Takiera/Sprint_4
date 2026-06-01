package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PersonalInformationFormPage {

    private WebDriver driver;

    //поле "Имя"
    private final By nameField = By.xpath("//input[@placeholder='* Имя']");
    //поле "Фамилия"
    private final By surnameField = By.xpath("//input[@placeholder='* Фамилия']");
    //поле "Адрес, куда привезти заказ"
    private final By addressField = By.xpath("//input[@placeholder='* Адрес: куда привезти заказ']");
    //поле "Станция метро"
    private final By metroStationField = By.xpath("//input[@placeholder='* Станция метро']");
    //Станция метро "Сокольники"
    private final By stationSokolniki = By.xpath("//li[@data-value='4']/button");
    //поле "Телефон"
    private final By phoneField = By.xpath("//input[@placeholder='* Телефон: на него позвонит курьер']");
    //кнопка "Далее"
    private final By nextButton = By.xpath("//button[text()='Далее']");

    public PersonalInformationFormPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterNameField(String name) {
        driver.findElement(nameField).sendKeys(name);
    }

    public void enterSurnameField(String surname) {
        driver.findElement(surnameField).sendKeys(surname);
    }

    public void enterAddressField(String address) {
        driver.findElement(addressField).sendKeys(address);
    }

    public void enterPhoneField(String phone) {
        driver.findElement(phoneField).sendKeys(phone);
    }

    public void enterMetroStationField() {
        driver.findElement(metroStationField).click();
        driver.findElement(stationSokolniki).click();
    }

    public RentScooterFormPage clickNextButton() {
        driver.findElement(nextButton).click();
        return new RentScooterFormPage(driver);
    }

    public void setPersonalInformation(String name, String surname, String address, String phone){
        enterNameField(name);
        enterSurnameField(surname);
        enterAddressField(address);
        enterPhoneField(phone);
        enterMetroStationField();
    }
}