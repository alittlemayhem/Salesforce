package tests;

import dto.Account;
import dto.AccountFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

//import static dto.AccountFactory.getAccount;

public class AccountsTest extends BaseTest {

    AccountFactory accountFactory = new AccountFactory();
    Account account = accountFactory.getAccount("testName9");

    @Test(testName = "New account creation", description = "Filling out all fields in the account modal window, check that new account (new line) appeared")
    public void checkCreateAccount() {
        loginPage.open()
                .isPageOpened()
                .login("tborodich@tms.sandbox", "Password001");

        String result = accountPage.open()
                .isPageOpened()
                .open()
                .isPageOpened()
                .fillAccountInfo(account)
                .fillAccountInfo(account)
                .fillAddressInfo(account)
                .fillAdditionalInfo(account)
                .fillDescription(account)
                .createAccount()
                .getSuccessMessage();

        String expectedMessage = String.format("Account \"%s\" was created.", account.getAccountName());
        Assert.assertEquals(
                result,
                expectedMessage,
                "Message is not correct.");
    }
}
