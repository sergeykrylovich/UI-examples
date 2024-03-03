package ui.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import ui.annotations.ChromeSetUp;
import ui.pages.MainPage;

import static ui.pages.forms.PracticeFormEnum.*;

@ChromeSetUp
public class PracticeFormTests {
    private WebDriver driver;
    private MainPage mainPage;

    @BeforeEach
    public void setUp() {
        mainPage = new MainPage(driver);
    }


    @Test
    public void formTest() throws InterruptedException {
        String firstName = "John";
        String lastName = "Travolta";
        String email = "JT@google.com";
        Gender gender = Gender.MALE;
        String mobileNumber = "9999999999";
        Months month = Months.JULY;
        int year = 1990;
        int day = 23;
        String subject = "Physics";
        Hobbies[] hobbies = new Hobbies[]{Hobbies.SPORTS, Hobbies.MUSIC};
        String address = "California";
        States state = States.NCR;
        String city = "Gurgaon";

        mainPage.clickOnForms()
                .clickOnPracticeForm()
                .fillFirstName(firstName)
                .fillLastName(lastName)
                .selectGender(gender)
                .fillMobileNumber(mobileNumber)
                .clickOnDateOfBirth()
                .selectOfYear(year)
                .selectOfMonth(month)
                .selectDay(day)
                .fillSubjects(subject)
                .selectHobbies(hobbies)
                .uploadPicture()
                .fillCurrentAddress(address)
                .selectState(state)
                .selectCity(city)
                .clickOnSubmitBtn();

        Thread.sleep(3000);

    }

    @AfterEach
    public void cleanUp() {
        driver.quit();
    }
}
