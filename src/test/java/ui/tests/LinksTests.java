package ui.tests;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v121.network.Network;
import org.openqa.selenium.devtools.v121.network.Network.*;
import ui.pages.MainPage;

import java.time.Duration;
import java.util.Optional;

public class LinksTests {

    WebDriver driver = new ChromeDriver();

    @BeforeEach
    public void setUp() {
        DevTools devTools = ((ChromeDriver) driver).getDevTools();
        devTools.createSession();
        devTools.send(Network.enable(Optional.of(1000000), Optional.empty(), Optional.empty()));
        devTools.addListener(Network.responseReceived(), responseReceived -> {
            System.out.println("Status is ---------------- " + responseReceived.getResponse().getStatus());
        });

        driver.get("http://85.192.34.140:8081");
        driver.manage().window().setSize(new Dimension(1920, 1080));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    @Test
    public void clickOnHomeLinkTest() {
        MainPage mainPage = new MainPage(driver);
        boolean elementsBtnIsVisible = mainPage.clickOnElements()
                .clickLinksMenu()
                .clickOnHomeLink()
                .switchtoMainPage()
                .elementsBtnIsVisible();

        Assertions.assertThat(elementsBtnIsVisible).isTrue();
    }

    @Test
    public void clickOnDynamicLinkTest() {
        MainPage mainPage = new MainPage(driver);
        boolean elementsBtnIsVisible = mainPage.clickOnElements()
                .clickLinksMenu()
                .clickOnDynamicLink()
                .switchtoMainPage()
                .elementsBtnIsVisible();

        Assertions.assertThat(elementsBtnIsVisible).isTrue();

    }

    @Test
    public void clickOnCreatedLinkTest() {


        MainPage mainPage = new MainPage(driver);
        mainPage.clickOnElements()
                .clickLinksMenu()
                .clickOnCreatedLink();
    }

    @AfterEach
    public void cleanUp() {
        driver.quit();
    }
}
