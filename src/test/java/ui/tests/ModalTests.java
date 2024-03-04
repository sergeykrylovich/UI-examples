package ui.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import ui.annotations.ChromeSetUp;
import ui.pages.MainPage;

import static org.assertj.core.api.Assertions.*;

@ChromeSetUp
public class ModalTests {

    private WebDriver driver;
    private MainPage mainPage;


    @BeforeEach
    public void setUp() {
        mainPage = new MainPage(driver);
    }

    @Test
    public void clickOnSmallModalBtnAndCheckIt() {
        boolean modalIsOpen = mainPage.clickOnFrames()
                .clickOnModalDialogsMenu()
                .clickOnSmallModalBtn()
                .isModalIsOpen();

        assertThat(modalIsOpen).isTrue();
    }

    @Test
    public void clickOnLargeModalBtnAndCheckIt() {
        boolean modalIsOpen = mainPage.clickOnFrames()
                .clickOnModalDialogsMenu()
                .clickOnLargeModalBtn()
                .isModalIsOpen();

        assertThat(modalIsOpen).isTrue();
    }

    @AfterEach
    public void cleanUp() {
        driver.quit();
    }
}
