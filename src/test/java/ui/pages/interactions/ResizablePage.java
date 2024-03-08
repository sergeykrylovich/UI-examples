package ui.pages.interactions;

import org.codehaus.groovy.ast.stmt.WhileStatement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ui.BasePage;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ResizablePage extends BasePage {

    private final By resizableHandle = By.xpath("//div[@id='resizableBoxWithRestriction']/span[@class='react-resizable-handle react-resizable-handle-se']");
    private final By resizableBoxWrapper = By.id("resizableBoxWithRestriction");

    public ResizablePage(WebDriver driver) {
        super(driver);
    }

    public List<String> resizeBoxByOffset(int x, int y) {
        actions.pause(Duration.ofMillis(300))
                .clickAndHold(driver.findElement(resizableHandle))
                .moveByOffset(x, y)
                .release()
                .perform();
        return getHeightAndWidthOfResizableElement(driver.findElement(resizableBoxWrapper));

    }

    public List<String> getHeightAndWidthOfResizableElement(WebElement element) {
        String style = element.getAttribute("style");
        return getSize(style);
    }

    public List<String> getSize(String stringWithSize) {
        List<String> res = new ArrayList<>();
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(stringWithSize);
        while(matcher.find()) {
            res.add(matcher.group());
        }
        return res;
    }
}
