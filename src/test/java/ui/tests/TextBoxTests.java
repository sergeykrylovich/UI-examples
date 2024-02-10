package ui.tests;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ui.pages.MainPage;
import ui.pages.elements.TextBoxPage;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;

public class TextBoxTests {
    WebDriver driver = new ChromeDriver();

    @BeforeEach
    public void setUp() {
        driver.get("http://85.192.34.140:8081");
        driver.manage().window().setSize(new Dimension(1920, 1080));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    @Test
    public void textBoxTest() throws InterruptedException {

        String fullName = "Valera";
        String email = "222@mail.ru";
        String currentAddress = "Minsk";
        String permanentAddress = "Moscow";

        MainPage mainPage = new MainPage(driver);
        TextBoxPage textBoxPage = mainPage.clickOnElements()
                .clickTextBoxMenu()
                .fillFullName(fullName)
                .fillEmail(email)
                .fillCurrentAddress(currentAddress)
                .fillPermanentAddress(permanentAddress)
                .clickSubmitButton();

        SoftAssertions.assertSoftly(softAssert -> {
            softAssert.assertThat(textBoxPage.getResultFullName()).as("Full Name input").isEqualToIgnoringCase(fullName);
            softAssert.assertThat(textBoxPage.getResultEmail()).as("Email input").isEqualToIgnoringCase(email);
            softAssert.assertThat(textBoxPage.getResultCurrentAddress()).as("Current Address input").isEqualToIgnoringCase(currentAddress);
            softAssert.assertThat(textBoxPage.getResultPermanentAddress()).as("Permanent Address input").isEqualToIgnoringCase(permanentAddress);
        });

    }

    @AfterEach
    public void cleanUp() {
        driver.quit();
    }
}
