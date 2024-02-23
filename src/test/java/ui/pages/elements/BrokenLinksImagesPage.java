package ui.pages.elements;

import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;
import ru.yandex.qatools.ashot.coordinates.WebDriverCoordsProvider;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;
import ui.BasePage;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.List;
import java.util.stream.Collectors;

public class BrokenLinksImagesPage extends BasePage {

    private final By images = By.xpath("//div[@class='col-12 mt-4 col-md-6']//img");
    private final By validImage = By.xpath("//p[text()='Valid image']/following-sibling::img[1]");
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


    public void assertPictures(String testName) throws IOException {
       String pathOfScreenshots = createFileForPicture();
       // + "/" + testName + ".png"
        Screenshot screenshot = new AShot()
                .coordsProvider(new WebDriverCoordsProvider())
                .takeScreenshot(driver, driver.findElement(validImage));
        File actualScreen = new File(pathOfScreenshots + "/" + testName + ".png");
        //File actualScreen1 = new File(pathOfScreenshots + "/" + testName + "1.png");
        File actualScreen1 = driver.findElement(validImage).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(actualScreen1, new File(pathOfScreenshots + "/" + testName + "1.png"));
        //BufferedImage image1 = ImageIO.read(actualScreen1);
        //ImageIO.write(image1, )

        ImageIO.write(screenshot.getImage(), "png", actualScreen);


        File expectedScreen = new File("src/test/resources/references/expectedImage1.png");
        compareScreenshots(actualScreen, expectedScreen);

    }

    private void compareScreenshots(File actualFile, File expectedFile) throws IOException {
        ImageDiff imageDiff = new ImageDiffer()
                .makeDiff(ImageIO.read(expectedFile), ImageIO.read(actualFile));
                // .withDiffSizeTrigger(5);
        if (imageDiff.hasDiff()) {
            BufferedImage diffImage = imageDiff.getMarkedImage();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ImageIO.write(diffImage, "png", byteArrayOutputStream);
            byte[] image = byteArrayOutputStream.toByteArray();
            Allure.getLifecycle().addAttachment("diff", "image/png", "png", image);
        }
    }

    private String createFileForPicture() {
        File outputDir = new File("build/screenshots");
        if (!outputDir.exists()) {
            outputDir.mkdirs();
        }
        return outputDir.getAbsolutePath();
    }
}
