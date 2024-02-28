package ui.pages.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ui.BasePage;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DownloadUploadPage extends BasePage {

    private final By downloadBtn = By.xpath("//a[@id='downloadButton']");
    private final By uploadBtn = By.xpath("//input[@id='uploadFile']");
    private final By uploadFilePath = By.xpath("//p[@id='uploadedFilePath']");
    public static final String DOWNLOADFILEPATH = System.getProperty("user.dir") + File.separator + "build" + File.separator + "downloadFiles";



    public DownloadUploadPage(WebDriver driver) {
        super(driver);
    }

    public DownloadUploadPage uploadFile(String filePath) {
        driver.findElement(uploadBtn).sendKeys(System.getProperty("user.dir") + File.separator + filePath);
        return this;
    }

    public void downloadFile() {
        driver.findElement(downloadBtn).click();
        wait.until(x -> Paths.get(DOWNLOADFILEPATH, "sticker.png").toFile().exists());
    }
    
    public String getUploadedPathFromPage() {
        waitForElementAppear(uploadFilePath);
        String path = driver.findElement(uploadFilePath).getText();
        int index = path.lastIndexOf("\\");
        String fileName = path.substring(index + 1);
        return fileName;
    }
}
