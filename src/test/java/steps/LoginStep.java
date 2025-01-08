package steps;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import utils.PropertyReader;

@Log4j2
public class LoginStep {

    LoginPage loginPage;
    String user = System.getProperty("user", PropertyReader.getProperty("user"));
    String password = System.getProperty("password", PropertyReader.getProperty("password"));

    public LoginStep(WebDriver driver) {
        loginPage = new LoginPage(driver);
    }

    public void login() {
        log.info("Login to Salesforce project.");
        loginPage.open()
                .isPageOpened()
                .login(user, password);
    }
}
