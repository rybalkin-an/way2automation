package helpers;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.ITestResult;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * Helper class for page objects.
 */
public final class Utils {

    /**
     * Not called.
     */
    private Utils() {
    }

    /**
     * Add screenshot data if test result is FAILURE
     *
     * @param driver  browser driver
     * @param testResult test result
     * @return is screenshot in byte format
     * @throws IOException when config file is not available
     */
    public static byte[] getScreenshotData(final ITestResult testResult, WebDriver driver) throws IOException {
        if (testResult.getStatus() == ITestResult.FAILURE) {
            BufferedImage screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(100))
                    .takeScreenshot(driver).getImage();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(screenshot, "jpg", baos);
            return baos.toByteArray();
        }
        return new byte[0];
    }

}