package ui.tests;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import ui.pages.MainPage;
import ui.utils.HTTPRequest;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class BrokenLinksImagesTests {

    WebDriver driver = new ChromeDriver();
    MainPage mainPage;

    @BeforeEach
    public void setUp() {
        driver.get("http://85.192.34.140:8081");
        driver.manage().window().setSize(new Dimension(1920, 1080));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        mainPage = new MainPage(driver);
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
    public void validLinkTest() {
        boolean isGoogle = mainPage.clickOnElements()
                .clickBrokenLinksMenu()
                .clickOnValidLink()
                .isGoogleOpen();

        assertThat(isGoogle).isTrue();
    }

    @AfterEach
    public void cleanUp() {
        driver.quit();
    }
}
