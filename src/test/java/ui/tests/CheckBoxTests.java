package ui.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ui.annotations.ChromeSetUp;
import ui.pages.MainPage;

import java.time.Duration;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static ui.pages.elements.CheckBoxPage.CheckBoxes.DOCUMENTS;
import static ui.pages.elements.CheckBoxPage.CheckBoxes.WORDFILE;

@ChromeSetUp
public class CheckBoxTests {

    WebDriver driver;

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
                .getListOfTextFromResult();

        assertThat(textFromResult).contains("wordFile");

    }

}
