package ui.tests;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ui.pages.InteractionsPage;
import ui.pages.MainPage;

import java.time.Duration;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class WebTabletsTests {

    WebDriver driver = new ChromeDriver();

    @BeforeEach
    public void setUp() {
        driver.get("http://85.192.34.140:8081");
        driver.manage().window().setSize(new Dimension(1920, 1080));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    @Test
    public void setAllFieldsOnFormTest() throws InterruptedException {
        String firstName = "Vasya";
        String lastName = "Ivanov";
        String email = "vasya@mail.ru";
        String age = "25";
        String salary = "5000";
        String department = "Minsk";

        MainPage mainPage = new MainPage(driver);
        List<String> listOfTextFromResult = mainPage.clickOnElements().clickWebTablesMenu()
                .clickAddBtn()
                .setFirstNameInput(firstName)
                .setLastNameInput(lastName)
                .setEmail(email)
                .setAgeInput(age)
                .setSalaryInput(salary)
                .setDepartmentInput(department)
                .clickSubmitBtn()
                .goToPageNumber(1)
                .searchRecord(firstName)
                .findResultInTable();

        assertThat(listOfTextFromResult).anySatisfy(x -> {
            assertThat(x).isEqualTo(firstName);
        });
        Thread.sleep(5000);
    }

    @AfterEach
    public void cleanUp() {
        driver.quit();
    }
}
