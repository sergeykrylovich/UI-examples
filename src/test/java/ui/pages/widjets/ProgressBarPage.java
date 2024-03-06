package ui.pages.widjets;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ui.BasePage;

public class ProgressBarPage extends BasePage {

    private final By startStopResetBtn = By.id("startStopButton");
    private final By progressBar = By.xpath("//div[@role='progressbar']");
    private int currentProgressValue = Integer.parseInt(driver.findElement(progressBar).getAttribute("aria-valuenow"));
    public ProgressBarPage(WebDriver driver) {
        super(driver);
    }

    public ProgressBarPage clickOnStart() {
        driver.findElement(startStopResetBtn).click();
        return this;
    }
    public ProgressBarPage clickOnStop() {
        driver.findElement(startStopResetBtn).click();
        return this;
    }

    public ProgressBarPage clickReset() {
        driver.findElement(startStopResetBtn).click();
        return this;
    }

    public int clickOnStopByValue(int expectedProgressValue) {
        if (expectedProgressValue < currentProgressValue) {
            throw new IllegalArgumentException("progress value cannot be less tha actual progress");
        }
        while (currentProgressValue != expectedProgressValue) {
            currentProgressValue = Integer.parseInt(driver.findElement(progressBar).getAttribute("aria-valuenow"));
        }
        clickOnStop();
        return currentProgressValue;
    }

}
