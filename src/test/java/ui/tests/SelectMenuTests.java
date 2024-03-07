package ui.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import ui.annotations.ChromeSetUp;
import ui.pages.MainPage;

@ChromeSetUp
public class SelectMenuTests {

    private WebDriver driver;
    private MainPage mainPage;


    @BeforeEach
    public void setUp() {
        mainPage = new MainPage(driver);
    }

    @Test
    public void selectOptionsTest() throws InterruptedException {
        mainPage.clickOnWidgets()
                .clickOnSelectMenu()
                .clickOnSelectOption()
                .selectFirstGroupFirstOption()
                .selectCar("Volvo")
                .selectCar("saaB")
                .deselectCar("sAAb")
                .clickOnSelectColor()
                .selectColor("Red")
                .selectColor("Green")
                .selectColor("Black")
                .selectColor("Blue");

        Thread.sleep(3000);
    }
}
