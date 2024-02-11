package ui.tests;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ui.pages.MainPage;
import ui.pages.elements.CheckBoxPage;

import java.time.Duration;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static ui.pages.elements.CheckBoxPage.CheckBoxes.DOCUMENTS;
import static ui.pages.elements.CheckBoxPage.CheckBoxes.WORDFILE;

public class CheckBoxTests {

    WebDriver driver = new ChromeDriver();

    @BeforeEach
    public void setUp() {
        driver.get("http://85.192.34.140:8081");
        driver.manage().window().setSize(new Dimension(1920, 1080));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    @Test
    public void testClickOnAllToggleButtons() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickOnElements()
                .clickCheckBoxMenu()
                .clickHomeToggleBtn()
                .clickDesktopToggleBtn()
                .clickDocumentsToggleBtn()
                .clickDownloadsToggleBtn()
                .clickWorkSpaceToggleBtn()
                .clickOfficeToggleBtn();
    }

    @Test
    public void testClickOnAllCheckBoxes() {
        MainPage mainPage = new MainPage(driver);
        List<String> textFromResult = mainPage.clickOnElements()
                .clickCheckBoxMenu()
                .clickOnExpandAllBtn()
                .clickOnCheckBox(DOCUMENTS)
                .clickOnCheckBox(WORDFILE)
                .getTextFromResult();

        assertThat(textFromResult).contains("wordFile");



    }

    @AfterEach
    public void cleanUp() {
        driver.quit();
    }
}
