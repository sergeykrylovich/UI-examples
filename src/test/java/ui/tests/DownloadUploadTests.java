package ui.tests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import ui.pages.MainPage;
import ui.pages.elements.DownloadUploadPage;

import java.io.File;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;
import static ui.pages.elements.DownloadUploadPage.DOWNLOADFILEPATH;

public class DownloadUploadTests {


    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        Map<String, String> prefs = new HashMap<>();
        prefs.put("download.default_directory", DOWNLOADFILEPATH);
        //prefs.put("profile.default_content_settings.popups", 0);
        options.setExperimentalOption("prefs", prefs);
        driver = new ChromeDriver(options);


        driver.get("http://85.192.34.140:8081");
        driver.manage().window().maximize();
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
