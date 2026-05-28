package pageObjects;

import org.openqa.selenium.*;

public class RentScooterFormPage {

    private WebDriver driver;

    private final By dateField = By.xpath("//input[@placeholder='* Когда привезти самокат']");
    private final By rentalPeriodField = By.className("Dropdown-control");
    private final By rentalPeriodOption = By.xpath("//div[@class='Dropdown-option' and text()='сутки']");
    private final By colorScooterBlackCheckbox = By.id("black");
    private final By commentForCourierField = By.xpath("//input[@placeholder='Комментарий для курьера']");
    private final By makeOrderButton = By.xpath("//div[@class='Order_Buttons__1xGrp']/button[text()='Заказать']");
    private final By confirmOrderButton = By.xpath("//button[text()='Да']");
    private final By confirmOrderMessage = By.xpath("//div[@class='Order_ModalHeader__3FDaJ' and text()='Заказ оформлен']");


    public RentScooterFormPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterDateField(String date) {
        driver.findElement(dateField).sendKeys(date, Keys.ENTER);
    }

    public void enterRentalPeriodField() {
        driver.findElement(rentalPeriodField).click();
        driver.findElement(rentalPeriodOption).click();
    }

    public void clickColorScooterBlackCheckbox() {
        driver.findElement(colorScooterBlackCheckbox).click();
    }

    public void enterCommentForCourierField(String comment) {
        driver.findElement(commentForCourierField).sendKeys(comment);
    }

    public void clickMakeOrderButton() {
        driver.findElement(makeOrderButton).click();
    }

    public void clickConfirmOrderButton() {
        driver.findElement(confirmOrderButton).click();
    }

    public boolean isConfirmOrderMessageDisplayed() {
        return driver.findElement(confirmOrderMessage).isDisplayed();
    }

    public void setRentScooterInformation(String date, String comment){
        enterDateField(date);
        enterRentalPeriodField();
        clickColorScooterBlackCheckbox();
        enterCommentForCourierField(comment);
        clickMakeOrderButton();
    }

}
