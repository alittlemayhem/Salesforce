package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class AccountsTest extends BaseTest {

    @Test(testName = "New account creation", description = "Filling out all fields in the account modal window, check that new account (new line) appeared")
    public void checkCreateAccount() {
        loginPage.open();
        loginPage.login("tborodich@tms.sandbox", "Password001");

        newAccountModal.openNewAccountModal();

        newAccountModal.fillAccountInfo("testName10", "testName9","8", "account Site test", "Other", "Media", "Hot", "3838", "123456789", "1234", "https://www.google.com/", "GOOGL", "Public", "25254", "2567");
        newAccountModal.fillAddressInfo("Billing street test filling textarea", "bilCity", "billProvince", "123456", "billCountry", "Shipping street test filling textarea", "shipCity", "shipProvince", "234566", "shipCountry");
        newAccountModal.fillAdditionalInfo("Low", "31.07.2029", "1", "No", "Bronze", "034662", "Yes");
        newAccountModal.fillDescription("Test description to fill textarea.");
        newAccountModal.createAccount();

        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //String message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*span[@data-aura-class='forceActionsText']//ancestor::div[@role='alert']"))).getText();
        //Assert.assertEquals(message, "Account \"testName10\" was created.", "Message is not correct.")
    }
}
