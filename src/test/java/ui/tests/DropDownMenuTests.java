package ui.tests;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import ui.annotations.ChromeSetUp;
import ui.pages.MainPage;

@ChromeSetUp
public class DropDownMenuTests {

    private WebDriver driver;
    private MainPage mainPage;


    @BeforeEach
    public void setUp() {
        mainPage = new MainPage(driver);
    }

    @Test
    public void dropDownTest() throws InterruptedException {
        mainPage.clickOnWidgets()
                .clickOnDropDownMenu()
                .hoverOnMainItem2()
                .hoverOnSubSubList()
                .hoverOnSubSubItem1()
                .hoverOnSubSubItem2();

        Thread.sleep(3000);
    }
}
