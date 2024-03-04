package ui.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import ui.annotations.ChromeSetUp;
import ui.pages.MainPage;

@ChromeSetUp
public class SliderTests {

    private WebDriver driver;
    private MainPage mainPage;


    @BeforeEach
    public void setUp() {
        mainPage = new MainPage(driver);
    }

    @Test
    public void sliderTest() throws InterruptedException {
        mainPage.clickOnWidgets().clickOnSliderMenu().moveSliderByValue(-35);
        Thread.sleep(4000);
    }

    @AfterEach
    public void cleanUp() {
        driver.quit();
    }
}
