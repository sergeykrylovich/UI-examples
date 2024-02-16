package ui.pages.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import ui.BasePage;

import java.util.List;
import java.util.stream.Collectors;

public class WebTablesPage extends BasePage {

    private final By addBtn = By.xpath("//button[@id='addNewRecordButton']");
    private final By firstNameInput = By.xpath("//input[@id='firstName']");

    private final By lastNameInput = By.xpath("//input[@id='lastName']");
    private final By userEmailInput = By.xpath("//input[@id='userEmail']");
    private final By ageInput = By.xpath("//input[@id='age']");
    private final By salaryInput = By.xpath("//input[@id='salary']");
    private final By departmentInput = By.xpath("//input[@id='department']");
    private final By submitBtn = By.xpath("//button[@id='submit']");
    private final By searchInput = By.xpath("//input[@id='searchBox']");
    private final By resultRecords = By.xpath("//div[@class='ReactTable -striped -highlight']//div[@class='rt-td']");
    private final By jumpToPageInput = By.xpath("//input[@aria-label='jump to page']");

    public WebTablesPage(WebDriver driver) {
        super(driver);
    }

    public WebTablesPage clickAddBtn() {
        driver.findElement(addBtn).click();
        return this;
    }

    public WebTablesPage setFirstNameInput(String firstName) {
        driver.findElement(firstNameInput).sendKeys(firstName);
        return this;
    }

    public WebTablesPage setLastNameInput(String lastName) {
        driver.findElement(lastNameInput).sendKeys(lastName);
        return this;
    }

    public WebTablesPage setEmail(String email) {
        driver.findElement(userEmailInput).sendKeys(email);
        return this;
    }

    public WebTablesPage setAgeInput(String age) {
        driver.findElement(ageInput).sendKeys(age);
        return this;
    }

    public WebTablesPage setSalaryInput(String salary) {
        driver.findElement(salaryInput).sendKeys(salary);
        return this;
    }

    public WebTablesPage setDepartmentInput(String department) {
        driver.findElement(departmentInput).sendKeys(department);
        return this;
    }

    public WebTablesPage clickSubmitBtn() {
        driver.findElement(submitBtn).click();
        return this;
    }

    public WebTablesPage searchRecord(String searchString) {
        driver.findElement(searchInput).sendKeys(searchString);
        return this;
    }

    public List<String> findResultInTable() {
        List<String> resultList= driver.findElements(resultRecords)
                .stream().map(x -> x.getText())
                .filter(x -> x.trim().length() > 0)
                .collect(Collectors.toList());
        return resultList;
    }

    public WebTablesPage goToPageNumber(int pageNumber) {
        Actions actions = new Actions(driver);
        actions.doubleClick(driver.findElement(jumpToPageInput))
                .sendKeys(Integer.toString(pageNumber))
                .sendKeys(Keys.ENTER)
                .perform();

        return this;
    }


}
