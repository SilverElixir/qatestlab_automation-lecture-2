package myprojects.automation.assignment2;

import myprojects.automation.assignment2.pages.LoginPage;
import myprojects.automation.assignment2.utils.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

/**
 * Base script functionality, can be used for all Selenium scripts.
 */
public abstract class BaseScript {

    private LoginPage loginPage;
    private static WebDriver driver = null;

    @BeforeTest
    public void setUp(){

    }

    @AfterTest(alwaysRun = true)
    public void tearDown(){
        getDriver().quit();
    }

    public LoginPage openLoginPage(){
        getDriver().get(Properties.getBaseAdminUrl());
        return new LoginPage();
    }

    /**
     *
     * @return New instance of {@link WebDriver} object.
     */
    public static WebDriver getDriver() {
        if(driver == null) {
            String path = System.getProperty("user.dir");
            System.setProperty("webdriver.chrome.driver", path + "/src/main/resources/win/chromedriver.exe");
//            System.setProperty("webdriver.chrome.driver", path + "/src/main/resources/mac/chromedriver");
//           I run the scripts on Mac, unfortunately, don't have a chance to check them on Windows
            driver = new ChromeDriver();
        }
        return driver;
    }
}
