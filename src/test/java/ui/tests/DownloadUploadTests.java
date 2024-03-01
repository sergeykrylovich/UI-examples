package ui.tests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ui.pages.MainPage;

import java.io.File;
import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;

public class DownloadUploadTests {

    WebDriver driver = new ChromeDriver();

    @BeforeEach
    public void setUp() {
        driver.get("http://85.192.34.140:8081");
        driver.manage().window().setSize(new Dimension(1920, 1080));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

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

    @AfterEach
    public void cleanUp() {
        driver.quit();
    }
}
