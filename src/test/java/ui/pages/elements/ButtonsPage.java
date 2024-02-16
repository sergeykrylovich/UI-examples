package ui.pages.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import ui.BasePage;

public class ButtonsPage extends BasePage {

    private Actions actions;

    //private final By doubleClickBtn = By.xpath("//button[@id='doubleClickBtn']");
    private final By doubleClickBtn = By.cssSelector("#doubleClickBtn");

    //private final By doubleClickBtn = By.xpath("//button[@id='rightClickBtn']");
    private final By rightClickBtn = By.cssSelector("#rightClickBtn");

    //private final By doubleClickMsg = By.xpath("//p[@id='doubleClickMessage']");
    private final By doubleClickMsg = By.cssSelector("#doubleClickMessage");

    //private final By rightClickMsg = By.xpath("//p[@id='rightClickMessage']");
    private final By rightClickMsg = By.cssSelector("#rightClickMessage");

    //private final By dynamicClickMsg = By.xpath("//p[@id='dynamicClickMessage']");
    private final By dynamicClickMsg = By.cssSelector("#dynamicClickMessage");

    private final By dynamicClickBtn = By.xpath("//button[text()='Click Me']");

    public ButtonsPage(WebDriver driver) {
        super(driver);
        actions = new Actions(driver);
    }

    public ButtonsPage clickOnDoubleClickBtn() {
        actions.doubleClick(driver.findElement(doubleClickBtn)).perform();
        return this;
    }

    public ButtonsPage clickOnRightClickBtn() {
        actions.contextClick(driver.findElement(rightClickBtn)).perform();
        return this;
    }

    public ButtonsPage clickOnDynamicBtn() {
        driver.findElement(dynamicClickBtn).click();
        return this;
    }

    public String getResultDoubleClickMsg() {
        return driver.findElement(doubleClickMsg).getText();
    }

    public String getResultRightClickMsg() {
        return driver.findElement(rightClickMsg).getText();
    }

    public String getResultDynamicClickMsg() {
        return driver.findElement(dynamicClickMsg).getText();
    }
}
