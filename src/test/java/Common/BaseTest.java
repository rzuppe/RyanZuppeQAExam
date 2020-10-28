package Common;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    private static final WebDriver driver = new ChromeDriver();



    //Access
    public WebDriver getDriver() {
        return driver;
    }



    //Methods
    @BeforeClass(alwaysRun = true)
    public void startBrowser() {
        driver.manage().window().setSize(new Dimension(1026, 768));
        driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.MINUTES);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @AfterClass(alwaysRun = true)
    public void closeBrowser() {
        driver.manage().deleteAllCookies();
        driver.quit();
    }

}