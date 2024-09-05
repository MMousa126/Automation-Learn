package Pages;

import Utilities.utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P01_LoginPage {

    WebDriver driver;
    private final By username = By.id("email");
    private final By password = By.id("pass");
    private final By logInbutton = By.xpath("//button[@name = 'login']");


    public P01_LoginPage(WebDriver driver){

        this.driver = driver;
    }

    // using fluent pattern
    public P01_LoginPage enterUsername(String usernametext,int noOfSecondToWait){

        utility.sendData(driver,username,noOfSecondToWait,usernametext);
        return this;
    }

    public P01_LoginPage enterPassword(String passtext,int noOfSecondToWait){

        utility.sendData(driver,password,noOfSecondToWait,passtext);
        return this;
    }
    public void clickOnLogin(int noOfSecondToWait){

        utility.clickOnElement(driver,logInbutton,noOfSecondToWait);
//        new P02_HomePage(driver);
    }
//
//    public void clickOnLogin(int noOfSecondToWait) {
//    }
}
