package ui.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ui.pages.MainPage;
import ui.pages.elements.TextBoxPage;

import java.time.Duration;

public class TestUI {
    WebDriver driver = new ChromeDriver();
    WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));

    @BeforeEach
    public void setUp() {
        driver.get("http://85.192.34.140:8081");
    }

    @Test
    public void testOpenURL() throws InterruptedException {
        String name = "Joohn Cally";
        String email = "aasd@mail.ru";
        String city = "Minsk";
        String address = "sssssssssssssssssssssssssssssssssss";
        By textBox = By.xpath("//li[@id='item-0']//span[text()='Text Box']");
        By elementsBtn = By.xpath("//h5[text()='Elements']");
        By userName = By.xpath("//input[@id='userName']");
        By userEmail = By.xpath("//input[@id='userEmail']");
        By currentAddress = By.xpath("//textarea[@id='currentAddress']");
        By permanentAddress = By.xpath("//textarea[@id='permanentAddress']");
        By submitBtn = By.xpath("//button[@id='submit']");
        By resultName = By.xpath("//p[@id='name']");
        By resultEmail = By.xpath("//p[@id='email']");
        By resultCurrentAddres = By.xpath("//p[@id='currentAddress']");
        By resultPermanentAddress = By.xpath("//p[@id='permanentAddress']");
        ChromeOptions chromeOptions = new ChromeOptions();
        driver.manage().window().maximize();

        driver.get("http://85.192.34.140:8081");
        webDriverWait.until(ExpectedConditions.elementToBeClickable(elementsBtn));
        driver.findElement(elementsBtn).click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(textBox));
        driver.findElement(textBox).click();
        //driver.findElement(userName).click();
        driver.findElement(userName).sendKeys(name);
        driver.findElement(userEmail).click();
        driver.findElement(userEmail).sendKeys(email);
        driver.findElement(currentAddress).click();
        driver.findElement(currentAddress).sendKeys(city);
        driver.findElement(permanentAddress).click();
        driver.findElement(permanentAddress).sendKeys(address);
        driver.findElement(submitBtn).click();
        Assertions.assertTrue(driver.findElement(resultName).getText().contains(name));
        Assertions.assertTrue(driver.findElement(resultEmail).getText().contains(email));
        Assertions.assertTrue(driver.findElement(resultCurrentAddres).getText().contains(city));
        Assertions.assertTrue(driver.findElement(resultPermanentAddress).getText().contains(address));



        Thread.sleep(5000);
    }

    @Test
    public void textBoxTest() throws InterruptedException {

        MainPage mainPage = new MainPage(driver);
        TextBoxPage textBoxPage = mainPage.clickOnElements()
                .clickTextBoxMenu()
                .fillFullName("Valera")
                .fillEmail("222@mail.ru")
                .fillCurrentAddress("Minsk")
                .fillPermanentAddress("Moscow")
                .clickSubmitButton();

        System.out.println(textBoxPage.getResultFullName());
        Thread.sleep(5000);
    }

    @AfterEach
    public void cleanUp() {
        driver.quit();
    }
}
