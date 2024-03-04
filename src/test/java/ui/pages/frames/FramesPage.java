package ui.pages.frames;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ui.BasePage;

public class FramesPage extends BasePage {
    private final String firstParentFrameId = "frame1";
    private final String secondParentFrameId = "frame2";

    private final By childFrame = By.xpath("//iframe");
    private final By childText = By.xpath("//p[contains(text(), 'Child Thread QA iFrame :)')]");
    private final By parentText = By.xpath("//body[contains(text(), 'Parent frame')]");

    public FramesPage(WebDriver driver) {
        super(driver);
    }

    public FramesPage switchToFirstParentFrame() {
        driver.switchTo().frame(firstParentFrameId);
        return this;
    }

    public FramesPage switchToSecondParentFrame() {
        driver.switchTo().frame(secondParentFrameId);
        return this;
    }

    public FramesPage switchToChildFrame() {
        driver.switchTo().frame(driver.findElement(childFrame));
        return this;
    }

    public boolean isChildFrame() {
        int i = 0;
        if(driver.findElement(childText).isDisplayed()){
            return true;
        } else return false;
    }

    public boolean isParentFrame() {
        if(driver.findElement(parentText).isDisplayed()){
            return true;
        } else return false;
    }
}
