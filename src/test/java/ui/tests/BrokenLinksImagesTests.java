package ui.tests;


import io.qameta.allure.Step;
import org.junit.jupiter.api.*;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;
import ui.pages.MainPage;
import ui.utils.HTTPRequest;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class BrokenLinksImagesTests {

    private WebDriver driver = new ChromeDriver();
    private MainPage mainPage;
    private String testName;

    @BeforeEach
    public void setUp(TestInfo testInfo) {
        driver.get("http://85.192.34.140:8081");
        driver.manage().window().setSize(new Dimension(1920, 1080));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        mainPage = new MainPage(driver);
        testName = testInfo.getTestMethod().get().getName();
    }

    @Test
    public void testBrokenImg() {
        HTTPRequest httpRequest = new HTTPRequest();
        ArrayList<Integer> statusCodes = new ArrayList<>();
        List<String> srcLinksFromImg = mainPage.clickOnElements().clickBrokenLinksMenu().getSrcLinksFromImg();
        for (String link : srcLinksFromImg) {
            try {
                statusCodes.add(httpRequest.getStatusCodeFromSrc(link));
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("img is failed to load " + link + " ---> " + e.getMessage());
            }
        }
        assertThat(statusCodes).allSatisfy(code -> {
            assertThat(code).as("status code of img src request").isEqualTo(200);
        });

    }

    @Test
    @DisplayName("valid")
    public void validLinkTest() {
        boolean isGoogle = mainPage.clickOnElements()
                .clickBrokenLinksMenu()
                .clickOnValidLink()
                .isGoogleOpen();

        assertThat(isGoogle).isTrue();
    }

    @Test
    @DisplayName("Test")
    public void comparePicturesTest() throws IOException {
        mainPage.clickOnElements().clickBrokenLinksMenu().assertPictures(testName);
    }



    @AfterEach
    public void cleanUp() {
        driver.quit();
    }
}
