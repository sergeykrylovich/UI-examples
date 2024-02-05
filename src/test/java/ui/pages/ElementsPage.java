package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ui.BasePage;

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




}
