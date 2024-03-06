package ui.tests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ui.annotations.ChromeSetUp;
import ui.pages.MainPage;

import java.io.File;
import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;

@ChromeSetUp
public class DownloadUploadTests {

    WebDriver driver;


    @Test
    @Tag("UI")
    @DisplayName("upload png file to site")
    public void uploadFileTest() {
        String expectedFileName = "expectedImage.png";
        String expectedFilePath = "src/test/resources/references/" + expectedFileName;

        MainPage mainPage = new MainPage(driver);
        String actualFileName = mainPage.clickOnElements()
                .clickUploadDownloadMenu()
                .uploadFile(expectedFilePath)
                .getUploadedPathFromPage();

        assertThat(actualFileName).isEqualTo(expectedFileName);
    }

    @Test
    @Tag("UI")
    @DisplayName("upload png file to site")
    public void downloadFileTest() {

        MainPage mainPage = new MainPage(driver);
        mainPage.clickOnElements()
                .clickUploadDownloadMenu()
                .downloadFile();

        File file = new File("build/downloadFiles/sticker.png");

        assertThat(file).isNotEmpty();

    }

}
