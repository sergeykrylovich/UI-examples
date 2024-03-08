package ui.pages.interactions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ui.BasePage;

public class InteractionsPage extends BasePage {

    private final By sortableMenu = By.xpath("//li[@id='item-0']//span[text()='Sortable']");
    private final By resizableMenu = By.xpath("//li[@id='item-2']//span[text()='Resizable']");
    public InteractionsPage(WebDriver driver) {
        super(driver);
    }

    public SortablePage clickOnSortableMenu() {
        driver.findElement(sortableMenu).click();
        return new SortablePage(driver);
    }

    public ResizablePage clickOnResizableMenu() {
        driver.findElement(resizableMenu).click();
        return new ResizablePage(driver);
    }
}
