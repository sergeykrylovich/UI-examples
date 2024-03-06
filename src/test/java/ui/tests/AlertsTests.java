package ui.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import ui.annotations.ChromeSetUp;
import ui.pages.MainPage;

@ChromeSetUp
public class AlertsTests {

    private WebDriver driver;
    private MainPage mainPage;


    @BeforeEach
    public void setUp() {
        mainPage = new MainPage(driver);
    }

    @Test
    public void clickOnAlertAndThenAcceptTest() throws InterruptedException {
        mainPage.clickOnFrames()
                .clickOnAlertsMenu()
                .clickOnAlertBtn()
                .clickOnAcceptInAlert();

        Thread.sleep(3000);
    }

    @Test
    public void clickOnAlertAndWait5SecondsThenAcceptTest() throws InterruptedException {
        mainPage.clickOnFrames()
                .clickOnAlertsMenu()
                .clickOnAlertAfter5SecondsBtn()
                .clickOnAcceptInAlert();

        Thread.sleep(3000);
    }

    @Test
    public void clickOnConfirmBoxThenAcceptTest() throws InterruptedException {
        mainPage.clickOnFrames()
                .clickOnAlertsMenu()
                .clickOnConfirmBoxBtn()
                .clickOnAcceptInAlert();

        Thread.sleep(3000);
    }

    @Test
    public void clickOnConfirmBoxThenDismissTest() throws InterruptedException {
        mainPage.clickOnFrames()
                .clickOnAlertsMenu()
                .clickOnConfirmBoxBtn()
                .clickOnDismissInAlert();

        Thread.sleep(3000);
    }

    @Test
    public void clickOnPromptBoxThenAcceptTest() throws InterruptedException {
        mainPage.clickOnFrames()
                .clickOnAlertsMenu()
                .clickOnPromptBoxBtn()
                .fillAlertAndClickOnAccept("LOLOLO");

        Thread.sleep(3000);
    }


}
