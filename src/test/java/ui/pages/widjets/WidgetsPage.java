package ui.pages.widjets;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ui.BasePage;

public class WidgetsPage extends BasePage {
    private final By sliderMenu = By.xpath("//li[@id='item-3']//span[text()='Slider']");
    private final By progressBarMenu = By.xpath("//li[@id='item-4']//span[text()='Progress Bar']");
    private final By toolTipsMenu = By.xpath("//li[@id='item-6']//span[text()='Tool Tips']");
    public WidgetsPage(WebDriver driver) {
        super(driver);
    }

    public SliderPage clickOnSliderMenu() {
        driver.findElement(sliderMenu).click();
        return new SliderPage(driver);
    }

    public ProgressBarPage clickOnProgressBarMenu() {
        driver.findElement(progressBarMenu).click();
        return new ProgressBarPage(driver);
    }

    public ToolTipsPage clickOnToolTipsMenu() {
        driver.findElement(toolTipsMenu).click();
        return new ToolTipsPage(driver);
    }
}
