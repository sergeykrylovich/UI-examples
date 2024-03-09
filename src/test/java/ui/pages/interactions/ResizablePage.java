package ui.pages.interactions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ui.BasePage;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ResizablePage extends BasePage {

    private final By resizableBoxHandle = By.xpath("//div[@id='resizableBoxWithRestriction']/span[@class='react-resizable-handle react-resizable-handle-se']");
    private final By resizableHandle = By.xpath("//div[@id='resizable']/span[@class='react-resizable-handle react-resizable-handle-se']");
    private final By footer = By.xpath("//footer/a[text()='ThreadQa']");
    private final By resizableBoxWrapper = By.id("resizableBoxWithRestriction");
    private final By resizableWrapper = By.id("resizable");

    public ResizablePage(WebDriver driver) {
        super(driver);
    }

    public List<String> resizeBoxByOffset(int x, int y) {
        actions.pause(Duration.ofMillis(300))
                .clickAndHold(driver.findElement(resizableBoxHandle))
                .moveByOffset(x, y)
                .release()
                .perform();
        return getHeightAndWidthOfResizableElement(driver.findElement(resizableBoxWrapper));

    }

    public List<String> resizeByOffset(int x, int y) {
        actions.pause(Duration.ofMillis(300))
                .scrollToElement(driver.findElement(footer))
                .clickAndHold(driver.findElement(resizableHandle))
                .moveByOffset(x, y)
                .release()
                .perform();
        return getHeightAndWidthOfResizableElement(driver.findElement(resizableWrapper));

    }

    public List<String> getHeightAndWidthOfResizableElement(WebElement element) {
        String style = element.getAttribute("style");
        List<String> res = new ArrayList<>();
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(style);
        while(matcher.find()) {
            res.add(matcher.group());
        }
        return res;

    }

}
