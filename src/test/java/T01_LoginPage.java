import Pages.P01_LoginPage;
import Utilities.DataUtility;
import Utilities.utility;
import io.qameta.allure.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

public class T01_LoginPage {

    private WebDriver driver;

    @Parameters(value = {"browser","URL"})
    @BeforeTest
    public void setUp(@Optional("chrome") String browser,@Optional("https://www.facebook.com/") String URL){
        switch (browser){
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "safari":
                driver = new SafariDriver();
                break;
        }
        driver.manage().window().maximize();
        driver.get(URL);
        driver.manage().timeouts()
                .implicitlyWait(Duration.ofSeconds(10));
    }

    Logger logger = LogManager.getLogger();


    //@Parameters(value = {"valid_username","valid_password","actual_URL","noOfSeconds"})
    @Test
    public void validLogin(@Optional("admain") String username,@Optional("admain") String pass,
                           @Optional("https://www.facebook.com/") String actualURL,
                           @Optional("4") int noOfSeconds) throws IOException {

        logger.info("Test Case is Running");

        new P01_LoginPage(driver).enterUsername(username,noOfSeconds)
                .enterPassword(pass,noOfSeconds)
                .clickOnLogin(noOfSeconds);
        utility.takingScreenShoot(driver,"ValidLoginTC");
        Assert.assertEquals(driver.getCurrentUrl(),actualURL);
    }

    @Description("This is a valid login Test Case")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Mohamed Mousa")
    @TmsLink("www.jira.com/zephyr/TC50") //the position of the test case
    @Test
    public void validLoginusingjsonfile() throws FileNotFoundException {

        new P01_LoginPage(driver).enterUsername(DataUtility.getJSONData("JsonData","username"),5)
                .enterPassword(DataUtility.getJSONData("JsonData","password"),5)
                .clickOnLogin(5);
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.facebook.com/");
    }

    @AfterTest
    public void closeWindow(){

        driver.quit();
    }

}
