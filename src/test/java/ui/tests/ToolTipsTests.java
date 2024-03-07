package ui.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import ui.annotations.ChromeSetUp;
import ui.pages.MainPage;

import static org.assertj.core.api.Assertions.*;

@ChromeSetUp
public class ToolTipsTests {
    private WebDriver driver;
    private MainPage mainPage;


    @BeforeEach
    public void setUp() {
        mainPage = new MainPage(driver);
    }

    @Test
    public void hoverOnBtnTest() throws InterruptedException {
        boolean hoverIsShown = mainPage.clickOnWidgets()
                .clickOnToolTipsMenu()
                .hoverOnBtn()
                .isHoverIsShown();

        Thread.sleep(3000);
        assertThat(hoverIsShown).isTrue();
    }

    @Test
    public void hoverOnInputTest() {
        boolean hoverIsShown = mainPage.clickOnWidgets()
                .clickOnToolTipsMenu()
                .hoverOnInput()
                .isHoverIsShown();

        assertThat(hoverIsShown).isTrue();
    }

    @Test
    public void hoverOnContraryLinkTest() {
        boolean hoverIsShown = mainPage.clickOnWidgets()
                .clickOnToolTipsMenu()
                .hoverOnContraryLink()
                .isHoverIsShown();

        assertThat(hoverIsShown).isTrue();
    }

    @Test
    public void hoverOnSectionLinkTest() throws InterruptedException {
        boolean hoverIsShown = mainPage.clickOnWidgets()
                .clickOnToolTipsMenu()
                .hoverOnSectionLink()
                .isHoverIsShown();

        Thread.sleep(3000);
        assertThat(hoverIsShown).isTrue();
    }

}
