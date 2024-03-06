package ui.tests;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import ui.annotations.ChromeSetUp;
import ui.pages.MainPage;

import static org.assertj.core.api.Assertions.*;

@ChromeSetUp
public class ProgressBatTests {
    WebDriver driver;
    MainPage mainPage;
    @BeforeEach
    public void setUp() {
        mainPage = new MainPage(driver);
    }

    @Test
    public void progressBarTest() throws InterruptedException {
        int expectedValueOfProgressBar = 51;
        int actualValueOfProgressBar = mainPage.clickOnWidgets()
                .clickOnProgressBarMenu()
                .clickOnStart()
                .clickOnStopByValue(expectedValueOfProgressBar);

        assertThat(actualValueOfProgressBar).isEqualTo(expectedValueOfProgressBar);
        Thread.sleep(3000);
    }
}
