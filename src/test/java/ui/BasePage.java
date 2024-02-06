package ui;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected JavascriptExecutor javascriptExecutor;
    protected Actions actions;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        javascriptExecutor = (JavascriptExecutor) driver;
        actions = new Actions(driver);
    }

    public String getTextByJs(By element) {
        return (String) javascriptExecutor.executeScript("return arguments[0].textContent;",
                driver.findElement(element));
    }

    public void waitPageLoad() {
        By imgMain = By.xpath("//div[@id='app']//a[@href='http://85.192.34.140:8081']");
        wait.until(ExpectedConditions.elementToBeClickable(imgMain));
    }

    public void waitForElementAppear(By element) {
        wait.until(visibilityOfElementLocated(element));
    }

}
