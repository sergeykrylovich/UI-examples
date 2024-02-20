package ui.pages.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ui.BasePage;

import java.util.List;
import java.util.stream.Collectors;

public class BrokenLinksImagesPage extends BasePage {

    private final By images = By.xpath("//div[@class='col-12 mt-4 col-md-6']//img");
    private final By validLink = By.xpath("//div[@class='col-12 mt-4 col-md-6']//a[text()='Click Here for Valid Link']");
    private final By brokenLink = By.xpath("//div[@class='col-12 mt-4 col-md-6']//a[text()='Click Here for Broken Link']");
    private final By googleImg = By.xpath("//img[@alt='Google']");
    private final By statusCodeText = By.xpath("//div[@class='example']//p");

    public BrokenLinksImagesPage(WebDriver driver) {
        super(driver);
    }

    public List<String> getSrcLinksFromImg() {
        List<String> srcList = driver.findElements(images)
                .stream()
                .map( img -> img.getAttribute("src"))
                .collect(Collectors.toList());

        return srcList;
    }

    public BrokenLinksImagesPage clickOnValidLink() {
        driver.findElement(validLink).click();
        return this;
    }

    public boolean isGoogleOpen() {
        List<WebElement> elements = driver.findElements(googleImg);
        if(elements.size() != 0) {
            return true;
        } else {
            return false;
        }
    }
}
