package steps;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import pages.NewAccountModal;

@Log4j2
public class AccountStep {

    NewAccountModal newAccountModal;

    public AccountStep(WebDriver driver) {
        newAccountModal = new NewAccountModal(driver);
    }

    public void create() {
        log.info("Account creation step.");
        newAccountModal.createAccount();
    }
}
