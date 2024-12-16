package tests;

import dto.Account;
import dto.AccountFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AccountsTest extends BaseTest {

    AccountFactory accountFactory = new AccountFactory();
    //Account account = accountFactory.getAccount("testName9");
    Account accountWithReqFieldsOnly = accountFactory.getAccountWithRequiredFields();

    @Test(testName = "New account creation", description = "Filling out all fields in the account modal window, check that new account (new line) appeared")
    public void checkCreateAccount() {
        loginPage.open()
                .isPageOpened()
                .login(user, password);

        String result = newAccountModal.open()
                .isPageOpened()
                .fillAccountInfo(accountWithReqFieldsOnly)
                //.fillAddressInfo(account)
                //.fillAdditionalInfo(account)
                //.fillDescription(account)
                .createAccount()
                .getSuccessMessage();

        String expectedMessage = String.format("Account \"%s\" was created.", accountWithReqFieldsOnly.getAccountName());
        Assert.assertEquals(
                result,
                expectedMessage,
                "Message is not correct.");
    }
}
