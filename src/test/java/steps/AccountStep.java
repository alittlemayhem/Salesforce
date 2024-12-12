package steps;

import org.openqa.selenium.WebDriver;
import pages.NewAccountModal;

public class AccountStep {

    NewAccountModal newAccountModal;

    public AccountStep(WebDriver driver) {
        newAccountModal = new NewAccountModal(driver);
    }

    public void create() {
        newAccountModal.createAccount();
    }
}
