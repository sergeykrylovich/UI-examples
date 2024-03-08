package ui.pages.interactions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ui.BasePage;

import java.time.Duration;

public class SortablePage extends BasePage {
    private String line = "//div[contains(@id,'demo-tabpane-') and @aria-hidden='false']//div[text()='%s']";
    private final By gridMenu = By.id("demo-tab-grid");
    private final By listMenu = By.id("demo-tab-list");

    public SortablePage(WebDriver driver) {
        super(driver);
    }

    public SortablePage moveSelectedElementToTargetElement(String selected, String target) {
        WebElement selectedElement = driver.findElement(By.xpath(String.format(line, selected)));
        WebElement targetElement = driver.findElement(By.xpath(String.format(line, target)));
        //add pause before start action
        actions.pause(Duration.ofMillis(250))
                .dragAndDrop(selectedElement, targetElement)
                .build()
                .perform();

        return this;
    }

    public SortablePage clickOnGridMenu() {
        driver.findElement(gridMenu).click();
        return this;
    }

    public SortablePage clickOnListMenu() {
        driver.findElement(gridMenu).click();
        return this;
    }
}
