package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

@Log4j2
public class LoginPage extends BasePage {

    private final By USER_INPUT = By.id("username");
    private final By PASSWORD = By.id("password");
    private final By LOGIN_BUTTON = By.id("Login");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public LoginPage isPageOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(LOGIN_BUTTON));
        } catch (TimeoutException e) {
            log.error(e.getMessage());
            Assert.fail("Login page did not open.");
        }
        return this;
    }

    @Step("Open login page")
    public LoginPage open() {
        log.info("Login page opening.");
        driver.get("https://tms9-dev-ed.develop.my.salesforce.com");
        return this;
    }

    //not void but homepage
    @Step("Login to website")
    public void login(String user, String password) {
        log.info("Login to system using credentials '{}' - '{}'", user, password);
        driver.findElement(USER_INPUT).sendKeys(user);
        driver.findElement(PASSWORD).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
        //return new NewAccountModal(driver);
    }
}
