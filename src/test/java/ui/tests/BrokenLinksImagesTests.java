package ui.tests;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;

import ui.pages.MainPage;
import ui.utils.SetupChromeDriver;
import ui.utils.HTTPRequest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

@ExtendWith(SetupChromeDriver.class)
public class BrokenLinksImagesTests {

    private WebDriver driver;
    private MainPage mainPage;
    private String testName;

    @BeforeEach
    public void setUp(TestInfo testInfo) {
/*        driver.get("http://85.192.34.140:8081");
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));*/
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
    @Tag("Screenshots")
    @DisplayName("compare pictures of element")
    public void comparePicturesScreenshotsTest() throws IOException {
        boolean imagesIsEqual = mainPage.clickOnElements().clickBrokenLinksMenu().isImagesIsEqual(testName);
        assertThat(imagesIsEqual).isTrue();
    }

    @Test
    @Tag("Screenshots")
    @DisplayName("compare a whole page screenshot")
    public void comparePagesScreenshotsTest() throws IOException {
        boolean pagesIsEqual = mainPage.clickOnElements().clickBrokenLinksMenu().isPagesIsEqual(testName);
        assertThat(pagesIsEqual).as("screenshots of pages is not equal").isTrue();
    }
    
    @AfterEach
    public void cleanUp() {
        driver.quit();
    }
}
