package ui.tests;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import ui.annotations.ChromeSetUp;
import ui.pages.MainPage;

import static org.assertj.core.api.Assertions.*;

@ChromeSetUp
public class FramesTests {

    private WebDriver driver;
    private MainPage mainPage;


    @BeforeEach
    public void setUp() {
        mainPage = new MainPage(driver);
    }

    @Test
    public void switchToFirstParentFrameAndChildFrame() {
        boolean childFrame = mainPage.clickOnFrames()
                .clickOnFramesMenu()
                .switchToFirstParentFrame()
                .switchToChildFrame()
                .isChildFrame();

        assertThat(childFrame).isTrue();
    }

    @Test
    public void switchToSecondParentFrameAndChildFrame() {
        boolean childFrame = mainPage.clickOnFrames()
                .clickOnFramesMenu()
                .switchToSecondParentFrame()
                .switchToChildFrame()
                .isChildFrame();

        assertThat(childFrame).isTrue();
    }


}
