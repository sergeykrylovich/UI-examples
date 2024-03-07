package ui.pages.widjets;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ui.BasePage;

public class DropDownMenuPage extends BasePage {

    private final By mainItem2 = By.xpath("//ul[@id='nav']//a[text()='Main Item 2']");
    private final By subSubList = By.xpath("//ul[@id='nav']//a[text()='SUB SUB LIST »']");
    private final By subSubItem1 = By.xpath("//ul[@id='nav']//a[text()='Sub Sub Item 1']");
    private final By subSubItem2 = By.xpath("//ul[@id='nav']//a[text()='Sub Sub Item 2']");


    public DropDownMenuPage(WebDriver driver) {
        super(driver);
    }

    public DropDownMenuPage hoverOnMainItem2() {
        actions.moveToElement(driver.findElement(mainItem2)).perform();
        return this;
    }

    public DropDownMenuPage hoverOnSubSubList() {
        actions.moveToElement(driver.findElement(subSubList)).perform();
        return this;
    }

    public DropDownMenuPage hoverOnSubSubItem1() {
        actions.moveToElement(driver.findElement(subSubItem1)).perform();
        return this;
    }

    public DropDownMenuPage hoverOnSubSubItem2() {
        actions.moveToElement(driver.findElement(subSubItem2)).perform();
        return this;
    }
}
