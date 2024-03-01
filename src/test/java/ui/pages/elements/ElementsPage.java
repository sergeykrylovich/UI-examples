package ui.pages.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ui.BasePage;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class ElementsPage extends BasePage {

    private final By textBoxMenu = By.xpath("//li[@id='item-0']//span[text()='Text Box']");
    private final By checkBoxMenu = By.xpath("//li[@id='item-1']//span[text()='Check Box']");
    private final By radioMenu = By.xpath("//li[@id='item-2']//span[text()='Radio Button']");
    private final By webTablesMenu = By.xpath("//li[@id='item-3']//span[text()='Web Tables']");
    private final By buttonsMenu = By.xpath("//li[@id='item-4']//span[text()='Buttons']");
    private final By linksMenu = By.xpath("//li[@id='item-5']//span[text()='Links']");
    private final By brokenLinksMenu = By.xpath("//li[@id='item-6']//span[text()='Broken Links - Images']");
    private final By uploadDownloadMenu = By.xpath("//li[@id='item-7']//span[text()='Upload and Download']");
    private final By dynamicPropertiesMenu = By.xpath("//li[@id='item-8']//span[text()='Dynamic Properties']");



    public ElementsPage(WebDriver driver) {
        super(driver);
    }

    public TextBoxPage clickTextBoxMenu() {
        wait.until(elementToBeClickable(textBoxMenu));
        driver.findElement(textBoxMenu).click();
        return new TextBoxPage(driver);
    }

    public CheckBoxPage clickCheckBoxMenu() {
        wait.until(elementToBeClickable(checkBoxMenu));
        driver.findElement(checkBoxMenu).click();
        return new CheckBoxPage(driver);
    }

    public ElementsPage clickRadioMenu() {
        wait.until(elementToBeClickable(radioMenu));
        driver.findElement(radioMenu).click();
        return this;
    }

    public WebTablesPage clickWebTablesMenu() {
        wait.until(elementToBeClickable(webTablesMenu));
        driver.findElement(webTablesMenu).click();
        return new WebTablesPage(driver);
    }

    public ButtonsPage clickButtonsMenu() {
        wait.until(elementToBeClickable(buttonsMenu));
        driver.findElement(buttonsMenu).click();
        return new ButtonsPage(driver);
    }

    public LinksPage clickLinksMenu() {
        wait.until(elementToBeClickable(linksMenu));
        driver.findElement(linksMenu).click();
        return new LinksPage(driver);
    }

    public BrokenLinksImagesPage clickBrokenLinksMenu() {
        wait.until(elementToBeClickable(brokenLinksMenu));
        driver.findElement(brokenLinksMenu).click();
        return new BrokenLinksImagesPage(driver);
    }

    public DownloadUploadPage clickUploadDownloadMenu() {
        wait.until(elementToBeClickable(uploadDownloadMenu));
        driver.findElement(uploadDownloadMenu).click();
        return new DownloadUploadPage(driver);
    }

    public DynamicPropertiesPage clickDynamicPropertiesMenu() {
        wait.until(elementToBeClickable(dynamicPropertiesMenu));
        driver.findElement(dynamicPropertiesMenu).click();
        return new DynamicPropertiesPage(driver);
    }









}
