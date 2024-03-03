package ui.pages.frames;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ui.BasePage;

public class AlertsPage extends BasePage {

    private final By alertBtn = By.xpath("//button[@id='alertButton']");
    private final By alertAfter5SecondsBtn = By.xpath("//button[@id='timerAlertButton']");
    private final By confirmBtn = By.xpath("//button[@id='confirmButton']");
    private final By promptBtn = By.xpath("//button[@id='promtButton']");

    public AlertsPage(WebDriver driver) {
        super(driver);
    }

    public AlertsPage clickOnAlertBtn() {
        driver.findElement(alertBtn).click();
        return this;
    }
    public AlertsPage clickOnAlertAfter5SecondsBtn() {
        driver.findElement(alertAfter5SecondsBtn).click();
        return this;
    }

    public AlertsPage clickOnConfirmBoxBtn() {
        driver.findElement(confirmBtn).click();
        return this;
    }
    public AlertsPage clickOnPromptBoxBtn() {
        driver.findElement(promptBtn).click();
        return this;
    }

    public void clickOnAcceptInAlert() {
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
    }

    public void clickOnDismissInAlert() {
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().dismiss();
    }

    public void fillAlertAndClickOnAccept(String prompt) {
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().sendKeys(prompt);
        driver.switchTo().alert().accept();
    }


    public void fillAlertAndClickOnDismiss(String prompt) {
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().sendKeys("hello");
        driver.switchTo().alert().dismiss();
    }
}
