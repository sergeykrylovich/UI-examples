package ui.pages.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ui.BasePage;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class ElementsPage extends BasePage {

    private By textBoxMenu = By.xpath("//li[@id='item-0']//span[text()='Text Box']");
    private By checkBoxMenu = By.xpath("//li[@id='item-1']//span[text()='Check Box']");
    private By radioMenu = By.xpath("//li[@id='item-2']//span[text()='Radio Button']");
    private By webTablesMenu = By.xpath("//li[@id='item-3']//span[text()='Web Tables']");
    private By buttonsMenu = By.xpath("//li[@id='item-4']//span[text()='Buttons']");
    private By linksMenu = By.xpath("//li[@id='item-5']//span[text()='Links']");
    private By brokenLinksMenu = By.xpath("//li[@id='item-6']//span[text()='Broken Links - Images']");
    private By uploadDownloadMenu = By.xpath("//li[@id='item-6']//span[text()='Upload and Download']");
    private By dynamicPropertiesMenu = By.xpath("//li[@id='item-6']//span[text()='Dynamic Properties']");



    public ElementsPage(WebDriver driver) {
        super(driver);
    }

    public TextBoxPage clickTextBoxMenu() {
        wait.until(elementToBeClickable(textBoxMenu));
        driver.findElement(textBoxMenu).click();
        return new TextBoxPage(driver);
    }

    public ElementsPage clickCheckBoxMenu(WebDriver driver) {
        wait.until(elementToBeClickable(checkBoxMenu));
        driver.findElement(checkBoxMenu).click();
        return this;
    }

    public ElementsPage clickRadioMenu(WebDriver driver) {
        wait.until(elementToBeClickable(radioMenu));
        driver.findElement(radioMenu).click();
        return this;
    }

    public ElementsPage clickWebTablesMenu(WebDriver driver) {
        wait.until(elementToBeClickable(webTablesMenu));
        driver.findElement(webTablesMenu).click();
        return this;
    }

    public ElementsPage clickButtonsMenu(WebDriver driver) {
        wait.until(elementToBeClickable(buttonsMenu));
        driver.findElement(buttonsMenu).click();
        return this;
    }

    public ElementsPage clickLinksMenu(WebDriver driver) {
        wait.until(elementToBeClickable(linksMenu));
        driver.findElement(linksMenu).click();
        return this;
    }

    public ElementsPage clickBrokenLinksMenu(WebDriver driver) {
        wait.until(elementToBeClickable(brokenLinksMenu));
        driver.findElement(brokenLinksMenu).click();
        return this;
    }

    public ElementsPage clickUploadDownloadMenu(WebDriver driver) {
        wait.until(elementToBeClickable(uploadDownloadMenu));
        driver.findElement(uploadDownloadMenu).click();
        return this;
    }

    public ElementsPage clickDynamicPropertiesMenu(WebDriver driver) {
        wait.until(elementToBeClickable(dynamicPropertiesMenu));
        driver.findElement(dynamicPropertiesMenu).click();
        return this;
    }









}
