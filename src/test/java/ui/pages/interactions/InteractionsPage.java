package ui.pages.interactions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ui.BasePage;

public class InteractionsPage extends BasePage {

    private final By sortableMenu = By.xpath("//li[@id='item-0']//span[text()='Sortable']");
    public InteractionsPage(WebDriver driver) {
        super(driver);
    }

    public SortablePage clickOnSortableMenu() {
        driver.findElement(sortableMenu).click();
        return new SortablePage(driver);
    }
}
