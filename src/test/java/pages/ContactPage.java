package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

@Log4j2
public class ContactPage extends BasePage {

    private final String HEADER = "//p[@class='slds-page-header__name-meta']";
    private final String SUCCESS_MESSAGE = "//div[contains(@class, 'forceToastMessage')]//span[contains(@class, 'toastMessage')]";

    public ContactPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public ContactPage isPageOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(HEADER)));
        } catch (TimeoutException e) {
            log.error(e.getMessage());
            Assert.fail("Contact page did not open.");
        }
        return this;
    }

    @Override
    @Step("Open 'New Contact' modal window")
    public NewContactModal open() {
        log.info("Opening of 'New Contact' modal window.");
        driver.get("https://tms9-dev-ed.develop.lightning.force.com/lightning/o/Contact/pipelineInspection?filterName=00BWU00000Gou2b2AB");
        return new NewContactModal(driver);
    }

    public String getSuccessMessage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SUCCESS_MESSAGE))).getText();
    }
}
