package ui.tests;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.openqa.selenium.WebDriver;
import ui.annotations.ChromeSetUp;
import ui.pages.MainPage;

@ChromeSetUp
public class BrowserWindowsTests {

    private WebDriver driver;
    private MainPage mainPage;


    @BeforeEach
    public void setUp() {
        mainPage = new MainPage(driver);
    }

    @Test
    public void openNewTabTest() {
        boolean newTabIsOpen = mainPage.clickOnFrames()
                .clickOnBrowserWindowsMenu()
                .clickOnNewTabBtn()
                .isNewTabOrWindowsIsOpen();

        System.out.println(newTabIsOpen);
    }

    @Test
    public void openNewWindowTest() {
        boolean newTabIsOpen = mainPage.clickOnFrames()
                .clickOnBrowserWindowsMenu()
                .clickOnNewWindowBtn()
                .isNewTabOrWindowsIsOpen();

        System.out.println(newTabIsOpen);
    }

    @Test
    public void openNewWindowMessageTest() {
        boolean newTabIsOpen = mainPage.clickOnFrames()
                .clickOnBrowserWindowsMenu()
                .clickOnNewWindowMessageBtn()
                .isNewTabOrWindowsIsOpen();

        System.out.println(newTabIsOpen);
    }

    @AfterEach
    public void cleanUp() {
        driver.quit();
    }
}
