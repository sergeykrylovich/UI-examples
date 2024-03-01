package ui.pages.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ui.BasePage;

public class DynamicPropertiesPage extends BasePage {

    private final By enableAfterBtn = By.xpath("//button[@id='enableAfter']");
    private final By colorChangeAfter = By.xpath("//button[@id='colorChange']");
    private final By visibleAfterBtn = By.xpath("//button[@id='visibleAfter']");
    private final By randomIdText = By.xpath("//p[contains(text(),'This text has random Id')]");

    public DynamicPropertiesPage(WebDriver driver) {
        super(driver);
    }

    public boolean btnIsEnabled() {
        return wait.until(ExpectedConditions.elementToBeClickable(enableAfterBtn)).isEnabled();
    }

    public boolean btnIsVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(visibleAfterBtn)).isEnabled();
    }

    public void colorIsChanged() {
        System.out.println(driver.findElement(colorChangeAfter).getCssValue("color"));
        //wait.until(x-> driver.findElement(colorChangeAfter).getCssValue("color").equalsIgnoreCase("#dc3545"));
    }

}
