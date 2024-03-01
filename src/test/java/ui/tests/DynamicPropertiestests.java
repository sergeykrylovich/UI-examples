package ui.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import ui.pages.MainPage;
import ui.utils.Annotations;

@ExtendWith(Annotations.class)
public class DynamicPropertiestests {
    WebDriver driver;

    private MainPage mainPage;

    @BeforeEach
    public void setUp(TestInfo testInfo) {
        mainPage = new MainPage(driver);
    }

    @Test
    public void checkColorOfBtn() {
        mainPage.clickOnElements().clickDynamicPropertiesMenu().colorIsChanged();
    }

    @AfterEach
    public void cleanUp() {
        driver.quit();
    }
}
