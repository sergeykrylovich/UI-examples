package ui.utils;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestInstancePostProcessor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.lang.reflect.Field;
import java.time.Duration;

public class SetupChromeDriver implements TestInstancePostProcessor {


    @Override
    public void postProcessTestInstance(Object testInstance, ExtensionContext context) throws Exception {
        WebDriver driver = new ChromeDriver();
        driver.get("http://85.192.34.140:8081");
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Field driverField = testInstance.getClass().getDeclaredField("driver");
        driverField.setAccessible(true);
        driverField.set(testInstance, driver);
    }
}
