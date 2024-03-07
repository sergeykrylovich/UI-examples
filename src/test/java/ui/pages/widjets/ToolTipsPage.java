package ui.pages.widjets;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ui.BasePage;

public class ToolTipsPage extends BasePage {

    private final By toolTipInput = By.id("toolTipTextField");
    private final By toolTipBtn = By.id("toolTipButton");
    private final By toolTipContainer = By.id("texToolTopContainer");
    private final By hoverResult = By.xpath("//div[@class='tooltip-inner']");
    private final By hoverOfInput = By.xpath("//div[@class='tooltip-inner' and contains(text(), 'text field')]");
    private final By hoverOfBtn = By.xpath("//div[@class='tooltip-inner' and contains(text(), 'Button')]");
    private final By contraryLink = By.xpath("//div[@id='texToolTopContainer']//a[text()='Contrary']");
    private final By sectionLink = By.xpath("//div[@id='texToolTopContainer']//a[text()='1.10.32']");
    public ToolTipsPage(WebDriver driver) {
        super(driver);
    }

    public ToolTipsPage hoverOnBtn() {
        actions.moveToElement(driver.findElement(toolTipBtn)).perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(toolTipContainer));
        return this;
    }

    public ToolTipsPage hoverOnInput() {
        actions.moveToElement(driver.findElement(toolTipInput)).perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(toolTipContainer));
        return this;
    }

    public ToolTipsPage hoverOnContraryLink() {
        actions.moveToElement(driver.findElement(contraryLink)).perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(toolTipContainer));
        return this;
    }

    public ToolTipsPage hoverOnSectionLink() {
        actions.moveToElement(driver.findElement(sectionLink)).perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(hoverResult));
        return this;
    }

    public boolean isHoverIsShown() {
        if (driver.findElement(hoverResult).isDisplayed()) {
            return true;
        } else return false;
    }

}
