package ui.pages.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ui.BasePage;

import java.util.List;
import java.util.stream.Collectors;

public class CheckBoxPage extends BasePage {

    private final By homeCheckBox = By.xpath("//label[@for='tree-node-home']//span[@class='rct-checkbox']");
    private final By desktopCheckBox = By.xpath("//label[@for='tree-node-desktop']//span[@class='rct-checkbox']");
    private final By notesCheckBox = By.xpath("//label[@for='tree-node-notes']//span[@class='rct-checkbox']");
    private final By commandsCheckBox = By.xpath("//label[@for='tree-node-commands']//span[@class='rct-checkbox']");
    private final By documentsCheckBox = By.xpath("//label[@for='tree-node-documents']//span[@class='rct-checkbox']");
    private final By workspaceCheckBox = By.xpath("//label[@for='tree-node-workspace']//span[@class='rct-checkbox']");
    private final By reactCheckBox = By.xpath("//label[@for='tree-node-react']//span[@class='rct-checkbox']");
    private final By angularCheckBox = By.xpath("//label[@for='tree-node-angular']//span[@class='rct-checkbox']");
    private final By vueCheckBox = By.xpath("//label[@for='tree-node-veu']//span[@class='rct-checkbox']");
    private final By officeCheckBox = By.xpath("//label[@for='tree-node-office']//span[@class='rct-checkbox']");
    private final By publicCheckBox = By.xpath("//label[@for='tree-node-public']//span[@class='rct-checkbox']");
    private final By privateCheckBox = By.xpath("//label[@for='tree-node-private']//span[@class='rct-checkbox']");
    private final By classifiedCheckBox = By.xpath("//label[@for='tree-node-classified']//span[@class='rct-checkbox']");
    private final By generalCheckBox = By.xpath("//label[@for='tree-node-general']//span[@class='rct-checkbox']");
    private final By downloadsCheckBox = By.xpath("//label[@for='tree-node-downloads']//span[@class='rct-checkbox']");
    private final By wordFileCheckBox = By.xpath("//label[@for='tree-node-wordFile']//span[@class='rct-checkbox']");
    private final By excelFileCheckBox = By.xpath("//label[@for='tree-node-excelFile']//span[@class='rct-checkbox']");
    private final By homeToggleBtn = By.xpath("//label[@for='tree-node-home']//preceding-sibling::button");
    private final By desktopToggleBtn = By.xpath("//label[@for='tree-node-desktop']//preceding-sibling::button");
    private final By documentsToggleBtn = By.xpath("//label[@for='tree-node-documents']//preceding-sibling::button");
    private final By workspaceToggleBtn = By.xpath("//label[@for='tree-node-workspace']//preceding-sibling::button");
    private final By officeToggleBtn = By.xpath("//label[@for='tree-node-office']//preceding-sibling::button");
    private final By downloadsToggleBtn = By.xpath("//label[@for='tree-node-downloads']//preceding-sibling::button");
    private final By expandAllBtn = By.xpath("//button[@class='rct-option rct-option-expand-all']");
    private final By collapseAllBtn = By.xpath("//button[@class='rct-option rct-option-collapse-all']");


    public CheckBoxPage(WebDriver driver) {
        super(driver);
    }

    public CheckBoxPage clickHomeToggleBtn() {
        driver.findElement(homeToggleBtn).click();
        return this;
    }

    public CheckBoxPage clickDesktopToggleBtn() {
        driver.findElement(desktopToggleBtn).click();
        return this;
    }

    public CheckBoxPage clickDocumentsToggleBtn() {
        driver.findElement(documentsToggleBtn).click();
        return this;
    }

    public CheckBoxPage clickWorkSpaceToggleBtn() {
        driver.findElement(workspaceToggleBtn).click();
        return this;
    }

    public CheckBoxPage clickOfficeToggleBtn() {
        driver.findElement(officeToggleBtn).click();
        return this;
    }

    public CheckBoxPage clickDownloadsToggleBtn() {
        driver.findElement(downloadsToggleBtn).click();
        return this;
    }

    public CheckBoxPage clickOnHomeCheckBox() {
        driver.findElement(homeCheckBox).click();
        return this;
    }

    public CheckBoxPage clickOnDesktopCheckBox() {
        driver.findElement(desktopCheckBox).click();
        return this;
    }

    public CheckBoxPage clickOnExpandAllBtn() {
        driver.findElement(expandAllBtn).click();
        return this;
    }

    public CheckBoxPage clickOnCollapseAllBtn() {
        driver.findElement(collapseAllBtn).click();
        return this;
    }



    public CheckBoxPage clickOnCheckBox(CheckBoxes checkBox) {
        switch (checkBox) {
            case HOME -> {
                driver.findElement(homeCheckBox).click();
                return this;
            }
            case DESKTOP -> {
                driver.findElement(desktopCheckBox).click();
                return this;
            }
            case NOTES -> {
                driver.findElement(notesCheckBox).click();
                return this;
            }
            case COMMANDS -> {
                driver.findElement(commandsCheckBox).click();
                return this;
            }
            case DOCUMENTS -> {
                driver.findElement(documentsCheckBox).click();
                return this;
            }
            case WORKSPACE -> {
                driver.findElement(workspaceCheckBox).click();
                return this;
            }
            case REACT -> {
                driver.findElement(reactCheckBox).click();
                return this;
            }
            case ANGULAR -> {
                driver.findElement(angularCheckBox).click();
                return this;
            }
            case VUE -> {
                driver.findElement(vueCheckBox).click();
                return this;
            }
            case OFFICE -> {
                driver.findElement(officeCheckBox).click();
                return this;
            }
            case PUBLIC -> {
                driver.findElement(publicCheckBox).click();
                return this;
            }
            case PRIVATE -> {
                driver.findElement(privateCheckBox).click();
                return this;
            }
            case CLASSIFIED -> {
                driver.findElement(classifiedCheckBox).click();
                return this;
            }
            case GENERAL -> {
                driver.findElement(generalCheckBox).click();
                return this;
            }
            case DOWNLOADS -> {
                driver.findElement(downloadsCheckBox).click();
                return this;
            }
            case WORDFILE -> {
                driver.findElement(wordFileCheckBox).click();
                return this;
            }
            case EXCELFILE -> {
                driver.findElement(excelFileCheckBox).click();
                return this;
            }
        }
        return this;
    }

    public enum CheckBoxes {
        HOME, DESKTOP, NOTES, COMMANDS, DOCUMENTS,
        WORKSPACE, REACT, ANGULAR, VUE, OFFICE,
        PUBLIC, PRIVATE, CLASSIFIED, GENERAL,
        DOWNLOADS, WORDFILE, EXCELFILE

    }



}
