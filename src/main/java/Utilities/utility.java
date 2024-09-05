package Utilities;

import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;

public class utility {

    public static String ScreenShoots_Path = "Test-Outputs/screenShoots/";

    // TODO: taking screen shoot
    public static void takingScreenShoot(WebDriver driver, String screenshootname) throws IOException {

        File screenSrc = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        File screenDestination = new File(ScreenShoots_Path+screenshootname+".png");
        FileUtils.copyFile(screenSrc,screenDestination);
        Allure.addAttachment(screenshootname, Files.newInputStream(Path.of(screenDestination.getPath())));
    }


    public static void clickOnElement(WebDriver driver, By locator, int numberOfSecondToWait){

        new WebDriverWait(driver, Duration.ofSeconds(numberOfSecondToWait))
                .until(ExpectedConditions.elementToBeClickable(locator));

        driver.findElement(locator).click();
    }

    public static void sendData(WebDriver driver, By locator, int numberOfSecondToWait, String text){

        new WebDriverWait(driver, Duration.ofSeconds(numberOfSecondToWait))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
        driver.findElement(locator).sendKeys(text);
    }




}
