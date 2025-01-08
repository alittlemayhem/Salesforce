package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import pages.*;
import steps.AccountStep;
import steps.LoginStep;
import utils.PropertyReader;

import java.time.Duration;

public class BaseTest {

    WebDriver driver;
    LoginPage loginPage;
    NewAccountModal newAccountModal;
    LoginStep loginStep;
    AccountStep accountStep;
    NewContactModal newContactModal;
    AccountPage accountPage;
    ContactPage contactPage;

    String user = System.getProperty("user", PropertyReader.getProperty("user"));
    String password = System.getProperty("password", PropertyReader.getProperty("password"));

    @Parameters({"browser"})
    @BeforeMethod
    public void setup(@Optional("chrome") String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("start-maximized");
            options.addArguments("--disable-notifications");
            driver = new ChromeDriver(options);
        } else if (browser.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        loginPage = new LoginPage(driver);
        newAccountModal = new NewAccountModal(driver);
        loginStep = new LoginStep(driver);
        accountStep = new AccountStep(driver);
        newContactModal = new NewContactModal(driver);
        accountPage = new AccountPage(driver);
        contactPage = new ContactPage(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}
