package ui.pages.widjets;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import ui.BasePage;

import java.util.Locale;

public class SelectMenuPage extends BasePage {

    private final By firstGroupFirstOption = By.id("react-select-2-option-0-0");
    private final By firstGroupSecondOption = By.id("react-select-2-option-0-1");
    private final By secondGroupFirstOption = By.id("react-select-2-option-1-0");
    private final By secondGroupSecondOption = By.id("react-select-2-option-1-1");
    private final By selectColor = By.xpath("//div[@id='selectMenuContainer']//div[text()='Select...']/parent::div/parent::div");

    private String colorElement = "//div[@id='selectMenuContainer']//div[text()='%s']";
    private final By carOption = By.id("cars");
    private final By rootOption = By.id("react-select-2-option-2");
    private final By anotherRootOption = By.id("react-select-2-option-3");
    private final By selectOption = By.id("withOptGroup");
    public SelectMenuPage(WebDriver driver) {
        super(driver);
    }

    public SelectMenuPage clickOnSelectOption() {
        driver.findElement(selectOption).click();
        return this;
    }

    public SelectMenuPage selectFirstGroupFirstOption() {
        driver.findElement(firstGroupFirstOption).click();
        return this;
    }

    public SelectMenuPage selectCar(String value) {
        Select select = new Select(driver.findElement(carOption));
        select.selectByValue(value.toLowerCase(Locale.ROOT));
        return this;
    }
    public SelectMenuPage deselectCar(String value) {
        Select select = new Select(driver.findElement(carOption));
        select.deselectByValue(value.toLowerCase(Locale.ROOT));
        return this;
    }

    public SelectMenuPage clickOnSelectColor() {
        driver.findElement(selectColor).click();
        return this;
    }

    public SelectMenuPage selectColor(String color) {
        By colorOption = By.xpath(String.format(colorElement, color));
        driver.findElement(colorOption).click();
        return this;
    }
}
