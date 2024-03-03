package ui.pages.frames;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ui.BasePage;

public class BrowserWindowsPage extends BasePage {

    private final By newTabBtn = By.xpath("//button[@id='tabButton']");
    private final By newWindowBtn = By.xpath("//button[@id='windowButton']");
    private final By newWindowMessageBtn = By.xpath("//button[@id='messageWindowButton']");
    private final By newTabH1 = By.xpath("//h1[@id='sampleHeading']");
    //private String tabName;

    public BrowserWindowsPage(WebDriver driver) {
        super(driver);
    }

    public BrowserWindowsPage clickOnNewTabBtn() {
        //tabName = driver.getWindowHandle());
        driver.findElement(newTabBtn).click();
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        return this;
    }

    public BrowserWindowsPage clickOnNewWindowBtn() {
        //tabName = driver.getWindowHandle());
        driver.findElement(newWindowBtn).click();
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        return this;
    }

    public BrowserWindowsPage clickOnNewWindowMessageBtn() {
        //tabName = driver.getWindowHandle());
        driver.findElement(newWindowMessageBtn).click();
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        return this;
    }

    public boolean isNewTabOrWindowsIsOpen() {
        String currentTabName = driver.getWindowHandle();
        try {
            for (String window : driver.getWindowHandles()) {
                if (!currentTabName.equals(window)) {
                    driver.switchTo().window(window);
                    return true;
                }
            }
        } catch (Throwable e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
}
