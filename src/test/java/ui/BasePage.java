package ui;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected JavascriptExecutor javascriptExecutor;
    protected Actions actions;

    private final By listOfSuccessText = By.xpath("//div[@id='result']//span[@class='text-success']");
    private final By successText = By.xpath("//span[@class='text-success']");

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

    public List<String> getListOfTextFromResult() {
        List<WebElement> elements = driver.findElements(listOfSuccessText);
        return elements.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public List<String> getTextFromResult() {
        List<WebElement> elements = driver.findElements(successText);
        return elements.stream().map(WebElement::getText).collect(Collectors.toList());
    }

}
