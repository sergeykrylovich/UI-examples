package ui.tests;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import ui.annotations.ChromeSetUp;
import ui.pages.MainPage;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@ChromeSetUp
public class ResizableTests {

    private WebDriver driver;
    private MainPage mainPage;


    @BeforeEach
    public void setUp() {
        mainPage = new MainPage(driver);
    }

    @Test
    public void resizeBoxTest() throws InterruptedException {
        int offsetX = 50;
        int offsetY = 40;
        int expectedX = 200 + offsetX;
        int expectedY = 200 + offsetY;

        List<String> res = mainPage.clickOnInteractions()
                .clickOnResizableMenu()
                .resizeBoxByOffset(offsetX, offsetY);

        assertThat(res).contains(Integer.toString(expectedX), Integer.toString(expectedY));

        Thread.sleep(3000);
    }

    @Test
    public void resizeTest() throws InterruptedException {
        int offsetX = 300;
        int offsetY = 400;
        int expectedX = 200 + offsetX;
        int expectedY = 200 + offsetY;

        List<String> res = mainPage.clickOnInteractions()
                .clickOnResizableMenu()
                .resizeByOffset(offsetX, offsetY);

        assertThat(res).contains(Integer.toString(expectedX), Integer.toString(expectedY));

        Thread.sleep(3000);
    }
}
