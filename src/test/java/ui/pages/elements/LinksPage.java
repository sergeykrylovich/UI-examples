package ui.pages.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ui.BasePage;

public class LinksPage extends BasePage {

    //private final By simpleLink = By.xpath("//a[@id='simpleLink']");
    private final By homeLink = By.cssSelector("#simpleLink");

    //private final By dynamicLink = By.xpath("//a[@id='dynamicLink']");
    private final By dynamicLink = By.cssSelector("#dynamicLink");

    //private final By createdLink = By.xpath("//a[@id='created']");
    private final By createdLink = By.cssSelector("#created");

    //private final By noContentLink = By.xpath("//a[@id='no-content']");
    private final By noContentLink = By.cssSelector("#no-content");

    //private final By movedLink = By.xpath("//a[@id='moved']");
    private final By movedLink = By.cssSelector("#moved");

    //private final By badRequestLink = By.xpath("//a[@id='bad-request']");
    private final By badRequestLink = By.cssSelector("#bad-request");

    //private final By unauthorizedLink = By.xpath("//a[@id='unauthorized']");
    private final By unauthorizedLink = By.cssSelector("#unauthorized");

    //private final By forbiddenLink = By.xpath("//a[@id='forbidden']");
    private final By forbiddenLink = By.cssSelector("#forbidden");

    //private final By invalidUrlLink = By.xpath("//a[@id='invalid-url']");
    private final By invalidUrlLink = By.cssSelector("#invalid-url");

    public LinksPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnHomeLink() {
        driver.findElement(homeLink).click();
        String originalWindow = driver.getWindowHandle();
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        for (String window : driver.getWindowHandles()) {
            if(!originalWindow.contentEquals(window)) {
                driver.switchTo().window(window);
            }
        }

    }
}
