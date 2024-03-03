package ui.pages.forms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import ui.BasePage;

import java.io.File;

import static ui.pages.forms.PracticeFormEnum.*;

public class FormsPage extends BasePage {

    public static final String FILEFORUPLOAD = System.getProperty("user.dir") + File.separator +
            "src/test/resources/references/pageScreenshot.png";
    private final By practiceForm = By.xpath("//li[@id='item-0']//span[text()='Practice Form']");
    private final By firstNameInput = By.xpath("//input[@id='firstName']");
    private final By lastNameInput = By.xpath("//input[@id='lastName']");
    private final By userEmailInput = By.xpath("//input[@id='userEmail']");
    private final By maleCheckBox = By.xpath("//label[@for='gender-radio-1']");
    private final By femaleCheckBox = By.xpath("//label[@id='gender-radio-2']");
    private final By otherSexCheckBox = By.xpath("//label[@id='gender-radio-3']");
    private final By mobileNumberInput = By.xpath("//input[@id='userNumber']");
    private final By dateOfBirthInput = By.xpath("//input[@id='dateOfBirthInput']");
    private final By selectMonth = By.xpath("//select[@class='react-datepicker__month-select']");
    private final By selectYear = By.xpath("//select[@class='react-datepicker__year-select']");
    private final By subjectInput = By.xpath("//input[@id='subjectsInput']");
    private final By subjectChoice = By.xpath("//div[@id='react-select-2-option-0']");
    private final By sportsCheckBox = By.xpath("//label[@for='hobbies-checkbox-1']");
    private final By readingCheckBox = By.xpath("//label[@for='hobbies-checkbox-2']");
    private final By musicCheckBox = By.xpath("//label[@for='hobbies-checkbox-3']");
    private final By uploadFileBtn = By.xpath("//input[@id='uploadPicture']");
    private final By currentAddressArea = By.xpath("//textArea[@id='currentAddress']");
    private final By selectStateInput = By.xpath("//div[@id='state']");
    private final By cityInput = By.xpath("//div[@id='city']");

    private final By NCRStateOption = By.xpath("//div[@id='react-select-3-option-0']");
    private final By uttarStateOption = By.xpath("//div[@id='react-select-3-option-1']");
    private final By haryanaStateOption = By.xpath("//div[@id='react-select-3-option-2']");
    private final By rajasthanStateOption = By.xpath("//div[@id='react-select-3-option-3']");
    private final By delhiCityOption = By.xpath("//div[@id='react-select-4-option-0']");
    private final By gurgaonCityOption = By.xpath("//div[@id='react-select-4-option-1']");
    private final By noidaCityOption = By.xpath("//div[@id='react-select-4-option-2']");
    private final By submitBtn = By.xpath("//button[@id='submit']");


    public FormsPage(WebDriver driver) {
        super(driver);
    }

    public FormsPage clickOnPracticeForm() {
        driver.findElement(practiceForm).click();
        return this;
    }

    public FormsPage clickOnDateOfBirth() {
        driver.findElement(dateOfBirthInput).click();
        return this;
    }

    public FormsPage fillFirstName(String firstName) {
        driver.findElement(firstNameInput).sendKeys(firstName);
        return this;
    }

    public FormsPage fillLastName(String lastName) {
        driver.findElement(lastNameInput).sendKeys(lastName);
        return this;
    }

    public FormsPage fillEmail(String email) {
        driver.findElement(userEmailInput).sendKeys(email);
        return this;
    }

    public FormsPage selectGender(Gender gender) {
        switch (gender) {
            case MALE -> {
                //clickByJs(maleCheckBox);
                driver.findElement(maleCheckBox).click();
            }
            case FEMALE -> {
                driver.findElement(femaleCheckBox).click();
            }
            case OTHER -> {
                driver.findElement(otherSexCheckBox).click();
            }
        }
        return this;
    }

    public FormsPage fillMobileNumber(String mobileNumber) {
        driver.findElement(mobileNumberInput).sendKeys(mobileNumber);
        return this;
    }

    public FormsPage selectOfMonth(Months months) {
        Select select = new Select(driver.findElement(selectMonth));
        switch (months) {
            case JANUARY -> {
                select.selectByValue("0");
            }
            case FEBRUARY -> {
                select.selectByValue("1");
            }
            case MARCH -> {
                select.selectByValue("2");
            }
            case APRIL -> {
                select.selectByValue("3");
            }
            case MAY -> {
                select.selectByValue("4");
            }
            case JUNE -> {
                select.selectByValue("5");
            }
            case JULY -> {
                select.selectByValue("6");
            }
            case AUGUST -> {
                select.selectByValue("7");
            }
            case SEPTEMBER -> {
                select.selectByValue("8");
            }
            case OCTOBER -> {
                select.selectByValue("9");
            }
            case NOVEMBER -> {
                select.selectByValue("10");
            }
            case DECEMBER -> {
                select.selectByValue("11");
            }
        }
        return this;
    }

    public FormsPage selectOfYear(int year) {
        Select select = new Select(driver.findElement(selectYear));
        if (year > 2100 || year < 1900) {
            throw new IllegalArgumentException("Year is out of range");
        }
        String yearStr = Integer.toString(year);
        select.selectByValue(yearStr);
        return this;
    }

    public FormsPage selectDay(int day) {
        By selectDay;
        if (day > 31 && day < 1) {
            throw new IllegalArgumentException("Day cant be less than 0 or more than 31");
        }
        if (day < 10) {
            selectDay = By.xpath(String.format("//div[@class='react-datepicker__day react-datepicker__day--00%d']", day));
        } else {
            selectDay = By.xpath(String.format("//div[@class='react-datepicker__day react-datepicker__day--0%d']", day));
        }
        driver.findElement(selectDay).click();
        return this;
    }

    public FormsPage fillSubjects(String subject) {
        driver.findElement(subjectInput).sendKeys(subject);
        driver.findElement(subjectChoice).click();
        return this;
    }

    public FormsPage selectHobbies(Hobbies...hobbie) {
        for (int i = 0; i < hobbie.length; i++) {
            switch (hobbie[i]) {
                case SPORTS -> {
                    driver.findElement(sportsCheckBox).click();
                }
                case READING -> {
                    driver.findElement(readingCheckBox).click();
                }
                case MUSIC -> {
                    driver.findElement(musicCheckBox).click();
                }
            }
        }
        return this;
    }

    public FormsPage uploadPicture() {
        driver.findElement(uploadFileBtn).sendKeys(FILEFORUPLOAD);
        return this;
    }

    public FormsPage fillCurrentAddress(String address) {
        driver.findElement(currentAddressArea).sendKeys(address);
        return this;
    }


    public FormsPage selectState(States state) {
        driver.findElement(selectStateInput).click();
        switch (state) {
            case NCR -> {
                driver.findElement(NCRStateOption).click();
            }
            case UTTAR_PRADESH -> {
                driver.findElement(uttarStateOption).click();
            }
            case HARYANA -> {
                driver.findElement(haryanaStateOption).click();
            }
            case RAJASTHAN -> {
                driver.findElement(rajasthanStateOption).click();
            }
        }
        return this;
    }

    public FormsPage selectCity(String city) {
        By cityOption = By.xpath(String.format("//div[contains(@id,'react-select-4-option-') and text()='%s']", city));
        driver.findElement(cityInput).click();
        driver.findElement(cityOption).click();
        return this;
    }

    public void clickOnSubmitBtn() {
        driver.findElement(submitBtn).click();
    }

}
