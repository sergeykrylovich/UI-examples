package ui.pages.frames;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ui.BasePage;

public class ModalDialogsPage extends BasePage {

    private final By smallModalBtn = By.id("showSmallModal");
    private final By largeModalBtn = By.id("showLargeModal");
    private final By modalTitle = By.xpath("//div[contains(@id, 'example-modal-sizes-title')]");
    private final String modalText= "Modal";

    public ModalDialogsPage(WebDriver driver) {
        super(driver);
    }

    public ModalDialogsPage clickOnSmallModalBtn() {
        driver.findElement(smallModalBtn).click();
        return this;
    }

    public ModalDialogsPage clickOnLargeModalBtn() {
        driver.findElement(largeModalBtn).click();
        return this;
    }

    public boolean isModalIsOpen() {
        return driver.findElement(modalTitle).getText().contains(modalText);
    }
}
