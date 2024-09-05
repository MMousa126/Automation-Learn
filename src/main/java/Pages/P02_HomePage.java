package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P02_HomePage {

    private final WebDriver driver;

    private final By logoutlocator = By.xpath("");
    public P02_HomePage(WebDriver driver){
        this.driver = driver;
    }
}
