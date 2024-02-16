package ui.tests;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ui.pages.MainPage;
import ui.pages.elements.ButtonsPage;

import java.time.Duration;

import static org.assertj.core.api.Assertions.*;

public class ButtonsTests {

    WebDriver driver = new ChromeDriver();

    @BeforeEach
    public void setUp() {
        driver.get("http://85.192.34.140:8081");
        driver.manage().window().setSize(new Dimension(1920, 1080));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    @Test
    public void clickOnButtonsTest() {
        MainPage mainPage = new MainPage(driver);
        String expectedDoubleClickMsg = "You have done a double click";
        String expectedRightClickMsg = "You have done a right click";
        String expectedDynamicClickMsg = "You have done a dynamic click";

        ButtonsPage buttonsPage = mainPage.clickOnElements()
                .clickButtonsMenu()
                .clickOnDoubleClickBtn()
                .clickOnRightClickBtn()
                .clickOnDynamicBtn();

        assertThat(buttonsPage.getResultDoubleClickMsg()).isEqualTo(expectedDoubleClickMsg);
        assertThat(buttonsPage.getResultRightClickMsg()).isEqualTo(expectedRightClickMsg);
        assertThat(buttonsPage.getResultDynamicClickMsg()).isEqualTo(expectedDynamicClickMsg);
    }

    @AfterEach
    public void cleanUp() {
        driver.quit();
    }
}
