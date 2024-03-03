package ui.pages.frames;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ui.BasePage;

public class AlertsWindowsFramesPage extends BasePage {

    private final By browserWindowsMenu = By.xpath("//li[@id='item-0']//span[text()='Browser Windows']");
    private final By alertsMenu = By.xpath("//li[@id='item-1']//span[text()='Alerts']");
    private final By framesMenu = By.xpath("//li[@id='item-2']//span[text()='Frames']");
    private final By nestedFramesMenu = By.xpath("//li[@id='item-3']//span[text()='Nested Frames']");
    private final By modalDialogsMenu = By.xpath("//li[@id='item-4']//span[text()='Modal Dialogs']");
    public AlertsWindowsFramesPage(WebDriver driver) {
        super(driver);
    }

    public BrowserWindowsPage clickOnBrowserWindowsMenu() {
        driver.findElement(browserWindowsMenu).click();
        return new BrowserWindowsPage(driver);
    }

    public AlertsPage clickOnAlertsMenu() {
        driver.findElement(alertsMenu).click();
        return new AlertsPage(driver);
    }

    public FramesPage clickOnFramesMenu() {
        driver.findElement(framesMenu).click();
        return new FramesPage(driver);
    }

    public NestedFramesPage clickOnNestedFramesMenu() {
        driver.findElement(nestedFramesMenu).click();
        return new NestedFramesPage(driver);
    }

    public ModalDialogsPage clickOnModalDialogsMenu() {
        driver.findElement(modalDialogsMenu).click();
        return new ModalDialogsPage(driver);
    }
}
