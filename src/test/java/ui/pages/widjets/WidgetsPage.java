package ui.pages.widjets;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ui.BasePage;

public class WidgetsPage extends BasePage {
    private final By sliderMenu = By.xpath("//li[@id='item-3']//span[text()='Slider']");
    public WidgetsPage(WebDriver driver) {
        super(driver);
    }

    public SliderPage clickOnSliderMenu() {
        driver.findElement(sliderMenu).click();
        return new SliderPage(driver);
    }
}
