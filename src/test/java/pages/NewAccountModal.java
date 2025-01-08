package pages;

import dto.Account;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import wrappers.Input;
import wrappers.PickList;
import wrappers.Textarea;

@Log4j2
public class NewAccountModal extends BasePage {

    private final String MODAL_HEADER = "//h2//parent::div[@class='slds-modal__header']";
    private final String NEW_ACCOUNT_BUTTON = "//div[@title='New']";
    private final String SAVE_ACCOUNT_BUTTON = "//*[@name='SaveEdit']";

    public NewAccountModal(WebDriver driver) {
        super(driver);
    }

    @Override
    public NewAccountModal isPageOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(MODAL_HEADER)));
        return this;
    }

    @Override
    public NewAccountModal open() {
        driver.get("https://tms9-dev-ed.develop.lightning.force.com/lightning/o/Account/list?filterName=AllAccounts");
        driver.findElement(By.xpath(NEW_ACCOUNT_BUTTON)).click();
        return this;
    }

    @Step("Fill only account part of window.")
    public NewAccountModal fillAccountInfo(Account account) {
        log.info("Filling out 'Account' part of modal window.");
        new Input(driver, "Account Name").write(account.getAccountName());
        new PickList(driver, "Parent Account").searchResultOption(account.getParentAccount());
        new Input(driver, "Account Number").write(account.getAccountNumber());
        new Input(driver, "Account Site").write(account.getAccountSite());
        new PickList(driver, "Type").select(account.getType());
        new PickList(driver, "Industry").select(account.getIndustry());
        new Input(driver, "Annual Revenue").write(account.getAnnualRevenue());
        new PickList(driver, "Rating").select(account.getRating());
        new Input(driver, "Phone").write(account.getPhone());
        new Input(driver, "Fax").write(account.getFax());
        new Input(driver, "Website").write(account.getWebsite());
        new Input(driver, "Ticker Symbol").write(account.getTickerSymbol());
        new PickList(driver, "Ownership").select(account.getOwnership());
        new Input(driver, "Employees").write(account.getEmployees());
        new Input(driver, "SIC Code").write(account.getSicCode());
        return this;
    }

    @Step("Fill address part of window.")
    public NewAccountModal fillAddressInfo(Account account) {
        log.info("Filling out 'Address Information' part of modal window.");
        new Textarea(driver, "Billing Street").write(account.getBillingStreet());
        new Input(driver, "Billing City").write(account.getBillingCity());
        new Input(driver, "Billing State/Province").write(account.getBillingProvince());
        new Input(driver, "Billing Zip/Postal Code").write(account.getBillingZipcode());
        new Input(driver, "Billing Country").write(account.getBillingCountry());
        new Textarea(driver, "Shipping Street").write(account.getShippingStreet());
        new Input(driver, "Shipping City").write(account.getShippingCity());
        new Input(driver, "Shipping State/Province").write(account.getShippingProvince());
        new Input(driver, "Shipping Zip/Postal Code").write(account.getShippingZipcode());
        new Input(driver, "Shipping Country").write(account.getShippingCountry());
        return this;
    }

    @Step("Fill additional info part of window.")
    public NewAccountModal fillAdditionalInfo(Account account) {
        log.info("Filling out 'Additional Information' part of modal window.");
        new PickList(driver, "Customer Priority").select(account.getCustomerPriority());
        new Input(driver, "SLA Expiration Date").write(account.getSlaExpirationDate());
        new Input(driver, "Number of Locations").write(account.getNumberOfLocations());
        new PickList(driver, "Active").select(account.getActive());
        new PickList(driver, "SLA").select(account.getSla());
        new Input(driver, "SLA Serial Number").write(account.getSlaSerialNumber());
        new PickList(driver, "Upsell Opportunity").select(account.getUpsellOpportunity());
        return this;
    }

    @Step("Fill description part of window.")
    public NewAccountModal fillDescription(Account account) {
        log.info("Filling out 'Description' part of modal window.");
        new Textarea(driver, "Description").write(account.getDescription());
        return this;
    }

    @Step("Create new account.")
    public AccountPage createAccount() {
        log.info("New account saving.");
        driver.findElement(By.xpath(SAVE_ACCOUNT_BUTTON)).click();
        return new AccountPage(driver);
    }
}
