package ui.pages.widjets;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import ui.BasePage;

public class SliderPage extends BasePage {

    private final By slider = By.xpath("//input[@type='range']");
    private final By sliderValue = By.xpath("//input[@id='sliderValue']");

    public SliderPage(WebDriver driver) {
        super(driver);
    }

    public String moveSliderByValue(int value) {
        int positionValue = Integer.parseInt(driver.findElement(slider).getAttribute("value"));
        if ((positionValue + value) > positionValue) {
            for (int i = 0; i < value; i++) {
                driver.findElement(slider).sendKeys(Keys.ARROW_RIGHT);
            }
        } else if ((positionValue + value) < positionValue) {
            for (int i = 0; i < Math.abs(value); i++) {
                driver.findElement(slider).sendKeys(Keys.ARROW_LEFT);
            }
        }
        return driver.findElement(sliderValue).getAttribute("value");
    }
}
