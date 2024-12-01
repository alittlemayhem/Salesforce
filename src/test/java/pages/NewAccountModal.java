package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import wrappers.Input;
import wrappers.PickList;
import wrappers.Textarea;

public class NewAccountModal extends BasePage {

    public NewAccountModal(WebDriver driver) {
        super(driver);
    }

    public void openNewAccountModal() {
        driver.get("https://tms9-dev-ed.develop.lightning.force.com/lightning/o/Account/list?filterName=AllAccounts");
        driver.findElement(By.xpath("//div[@title='New']")).click();
    }

    public void fillAccountInfo(String name, String parName, String accNum, String accSite, String type, String industry, String rating, String aRevenue, String phone, String fax, String website, String tickerSymbol, String ownership, String employees, String sicCode) {
        new Input(driver, "Account Name").write(name);
        new PickList(driver, "Parent Account").searchResultOption(parName);
        new Input(driver, "Account Number").write(accNum);
        new Input(driver, "Account Site").write(accSite);
        new PickList(driver, "Type").select(type);
        new PickList(driver, "Industry").select(industry); // waits
        new Input(driver, "Annual Revenue").write(aRevenue);
        new PickList(driver, "Rating").select(rating);
        new Input(driver, "Phone").write(phone);
        new Input(driver, "Fax").write(fax);
        new Input(driver, "Website").write(website);
        new Input(driver, "Ticker Symbol").write(tickerSymbol);
        new PickList(driver, "Ownership").select(ownership);
        new Input(driver, "Employees").write(employees);
        new Input(driver, "SIC Code").write(sicCode);
    }

    public void fillAddressInfo(String bStreet, String bCity, String bProvince, String bZipcode, String bCountry, String sStreet, String sCity, String sProvince, String sZipcode, String sCountry) {
        new Textarea(driver, "Billing Street").write(bStreet);
        new Input(driver, "Billing City").write(bCity);
        new Input(driver, "Billing State/Province").write(bProvince);
        new Input(driver, "Billing Zip/Postal Code").write(bZipcode);
        new Input(driver, "Billing Country").write(bCountry);
        new Textarea(driver, "Shipping Street").write(sStreet);
        new Input(driver, "Shipping City").write(sCity);
        new Input(driver, "Shipping State/Province").write(sProvince);
        new Input(driver, "Shipping Zip/Postal Code").write(sZipcode);
        new Input(driver, "Shipping Country").write(sCountry);
    }

    public void fillAdditionalInfo(String customerPriority, String slaExpDate, String numOfLocations, String active, String sla, String slaSerNumber, String upsellOpp) {
        new PickList(driver, "Customer Priority").select(customerPriority);
        new Input(driver, "SLA Expiration Date").write(slaExpDate);
        new Input(driver, "Number of Locations").write(numOfLocations);
        new PickList(driver, "Active").select(active);
        new PickList(driver, "SLA").select(sla);
        new Input(driver, "SLA Serial Number").write(slaSerNumber);
        new PickList(driver, "Upsell Opportunity").select(upsellOpp);
    }

    public void fillDescription(String description) {
        new Textarea(driver, "Description").write(description);
    }

    public void createAccount() {
        driver.findElement(By.xpath("//*[@name='SaveEdit']")).click();
    }
}
