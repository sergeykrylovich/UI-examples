package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ui.BasePage;
import ui.pages.elements.ElementsPage;

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


    public ElementsPage clickOnElements() {
        driver.findElement(elementsBtn).click();
        return new ElementsPage(driver);
    }

    public FormsPage clickOnForms() {
        driver.findElement(formsBtn).click();
        return new FormsPage(driver);
    }

    public FramesPage clickOnFrames() {
        driver.findElement(framesBtn).click();
        return new FramesPage(driver);
    }

    public WidgetsPage clickOnWidgets() {
        driver.findElement(widgetsBtn).click();
        return new WidgetsPage(driver);
    }

    public InteractionsPage clickOnInteractions() {
        driver.findElement(interactionsBtn).click();
        return new InteractionsPage(driver);
    }

    public GamePage clickOnGame() {
        driver.findElement(gameBtn).click();
        return new GamePage(driver);
    }


}
