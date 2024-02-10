package ui.pages.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ui.BasePage;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class TextBoxPage extends BasePage {

    private final By fullNameInput = By.xpath("//input[@id='userName']");
    private final By emailInput = By.xpath("//input[@id='userEmail']");
    private final By currentAddressInput = By.xpath("//textarea[@id='currentAddress']");
    private final By permanentAddressInput = By.xpath("//textarea[@id='permanentAddress']");
    private final By submitBtn = By.xpath("//button[@id='submit']");
    private final By resultFullName = By.xpath("//p[@id='name']");
    private final By resultEmail = By.xpath("//p[@id='email']");
    private final By resultCurrentAddress = By.xpath("//p[@id='currentAddress']");
    private final By resultPermanentAddress = By.xpath("//p[@id='permanentAddress']");
    private final By resultTable = By.xpath("//div[@id='output']");

    public TextBoxPage(WebDriver driver) {
        super(driver);
    }

    protected void waitForResults() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(resultTable));
    }

    public TextBoxPage clickSubmitButton() {
        wait.until(elementToBeClickable(submitBtn));
        driver.findElement(submitBtn).click();
        waitForResults();
        return this;
    }

    public TextBoxPage fillFullName(String text) {
        waitForElementAppear(fullNameInput);
        driver.findElement(fullNameInput).sendKeys(text);
        return this;
    }

    public TextBoxPage fillEmail(String text) {
        waitForElementAppear(emailInput);
        driver.findElement(emailInput).sendKeys(text);
        return this;
    }

    public TextBoxPage fillCurrentAddress(String text) {
        waitForElementAppear(currentAddressInput);
        driver.findElement(currentAddressInput).sendKeys(text);
        return this;
    }

    public TextBoxPage fillPermanentAddress(String text) {
        waitForElementAppear(permanentAddressInput);
        driver.findElement(permanentAddressInput).sendKeys(text);
        return this;
    }

    public String getResultFullName() {
        return getTextFromResult(resultFullName);
    }

    public String getResultEmail() {
        return getTextFromResult(resultEmail);
    }

    public String getResultCurrentAddress() {
        return getTextFromResult(resultCurrentAddress);
    }

    public String getResultPermanentAddress() {
        return getTextFromResult(resultPermanentAddress);
    }

    private String getTextFromResult(By element) {
        String text = driver.findElement(element).getText();
        return text.substring(text.indexOf(":") + 1);
    }


}
