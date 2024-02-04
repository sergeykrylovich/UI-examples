package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ui.BasePage;

public class MainPage extends BasePage {

    private By elementsBtn = By.xpath("//h5[text()='Elements']");
    private By formsBtn = By.xpath("//h5[text()='Forms']");
    private By framesBtn = By.xpath("//h5[text()='Alerts, Frame & Windows']");
    private By widgetsBtn = By.xpath("//h5[text()='Widgets']");
    private By interactionsBtn = By.xpath("//h5[text()='Interactions']");
    private By gameBtn = By.xpath("//h5[text()='Game Store Application']");

    public MainPage(WebDriver driver) {
        super(driver);
        waitPageLoad();
    }


    public MainPage clickOnElements() {
        driver.findElement(elementsBtn).click();
        return this;
    }

    public MainPage clickOnForms() {
        driver.findElement(formsBtn).click();
        return this;
    }

    public MainPage clickOnFrames() {
        driver.findElement(framesBtn).click();
        return this;
    }

    public MainPage clickOnWidgets() {
        driver.findElement(widgetsBtn).click();
        return this;
    }

    public MainPage clickOnInteractions() {
        driver.findElement(interactionsBtn).click();
        return this;
    }

    public MainPage clickOnGame() {
        driver.findElement(gameBtn).click();
        return this;
    }


}
