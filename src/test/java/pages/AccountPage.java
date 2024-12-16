package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

@Log4j2
public class AccountPage extends BasePage {

    private final String HEADER = "//span[@class='slds-var-p-right_x-small']";
    private final String SUCCESS_MESSAGE = "//div[contains(@class, 'forceToastMessage')]//span[contains(@class, 'toastMessage')]";

    public AccountPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public AccountPage isPageOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(HEADER)));
        } catch (TimeoutException e) {
            log.error(e.getMessage());
            Assert.fail("Contact page did not open.");
        }
        return this;
    }

    @Override
    @Step("Open 'new Account' modal window.")
    public NewAccountModal open() {
        log.info("Opening of 'New Account' modal window.");
        driver.get("https://tms9-dev-ed.develop.lightning.force.com/lightning/o/Account/list?filterName=__Recent");
        return new NewAccountModal(driver);
    }

    public String getSuccessMessage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SUCCESS_MESSAGE))).getText();
    }
}
