package ui.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import ui.annotations.ChromeSetUp;
import ui.pages.MainPage;

@ChromeSetUp
public class SortableTests {
    private WebDriver driver;
    private MainPage mainPage;

    @BeforeEach
    public void setUp() {
        mainPage = new MainPage(driver);
    }

    @Test
    public void moveElementToTargetElementOnListMenuTest() throws InterruptedException {
        String firstLine = "One";
        String secondLine = "Five";
        mainPage.clickOnInteractions()
                .clickOnSortableMenu()
                .moveSelectedElementToTargetElement(firstLine, secondLine);

        Thread.sleep(3000);
    }

    @Test
    public void moveElementToTargetElementOnGridMenuTest() throws InterruptedException {
        String firstLine = "Two";
        String secondLine = "Nine";
        mainPage.clickOnInteractions()
                .clickOnSortableMenu()
                .clickOnGridMenu()
                .moveSelectedElementToTargetElement(firstLine, secondLine);

        Thread.sleep(3000);
    }


}
