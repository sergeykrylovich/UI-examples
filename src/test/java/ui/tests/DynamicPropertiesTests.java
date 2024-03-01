package ui.tests;



import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import ui.annotations.ChromeSetUp;
import ui.pages.MainPage;
import ui.utils.SetupChromeDriver;

import static org.assertj.core.api.Assertions.*;

@ChromeSetUp
public class DynamicPropertiesTests {
    WebDriver driver;

    private MainPage mainPage;

    @BeforeEach
    public void setUp(TestInfo testInfo) {
        mainPage = new MainPage(driver);
    }

    @Test
    public void ColorOfBtnTest() {
        boolean isChanged = mainPage.clickOnElements().clickDynamicPropertiesMenu().colorIsChanged();
        assertThat(isChanged).isTrue();
    }

    @Test
    public void btnEnabledTest() {
        boolean isEnabled = mainPage.clickOnElements().clickDynamicPropertiesMenu().btnIsEnabled();
        assertThat(isEnabled).isTrue();
    }

    @Test
    public void btnVisibleTest() {
        boolean isVisible = mainPage.clickOnElements().clickDynamicPropertiesMenu().btnIsVisible();
        assertThat(isVisible).isTrue();
    }

    @AfterEach
    public void cleanUp() {
        driver.quit();
    }
}
