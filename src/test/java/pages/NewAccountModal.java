package pages;

import dto.Account;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import wrappers.Input;
import wrappers.PickList;
import wrappers.Textarea;

public class NewAccountModal extends BasePage {

    public NewAccountModal(WebDriver driver) {
        super(driver);
    }

    @Override
    public NewAccountModal isPageOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2//parent::div[@class='slds-modal__header']")));
        return this;
    }

    public NewAccountModal open() {
        driver.get("https://tms9-dev-ed.develop.lightning.force.com/lightning/o/Account/list?filterName=__Recent");
        driver.findElement(By.xpath("//div[@title='New']")).click();
        return this;
    }

    public NewAccountModal fillAccountInfo(Account account) {
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

    public NewAccountModal fillAddressInfo(Account account) {
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

    public NewAccountModal fillAdditionalInfo(Account account) {
        new PickList(driver, "Customer Priority").select(account.getCustomerPriority());
        new Input(driver, "SLA Expiration Date").write(account.getSlaExpirationDate());
        new Input(driver, "Number of Locations").write(account.getNumberOfLocations());
        new PickList(driver, "Active").select(account.getActive());
        new PickList(driver, "SLA").select(account.getSla());
        new Input(driver, "SLA Serial Number").write(account.getSlaSerialNumber());
        new PickList(driver, "Upsell Opportunity").select(account.getUpsellOpportunity());
        return this;
    }

    public NewAccountModal fillDescription(Account account) {
        new Textarea(driver, "Description").write(account.getDescription());
        return this;
    }

    public AccountPage createAccount() {
        driver.findElement(By.xpath("//*[@name='SaveEdit']")).click();
        return new AccountPage(driver);
    }
}
