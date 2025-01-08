package pages;

import dto.Contact;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import wrappers.Input;
import wrappers.PickList;
import wrappers.Textarea;

public class NewContactModal extends BasePage {

    private final String NEW_CONTACT_HEADER = "//h2//parent::div[@class='slds-modal__header']";
    private final String NEW_CONTACT_BUTTON = "//div[@title='New']";
    private final String SAVE_BUTTON = "//button[@name='SaveEdit']";

    public NewContactModal(WebDriver driver) {
        super(driver);
    }

    @Override
    public NewContactModal isPageOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(NEW_CONTACT_HEADER)));
        return this;
    }

    @Override
    public NewContactModal open() {
        driver.get("https://tms9-dev-ed.develop.lightning.force.com/lightning/o/Contact/list?filterName=__Recent");
        driver.findElement(By.xpath(NEW_CONTACT_BUTTON)).click();
        return this;
    }

    @Step("Fill only first part of window.")
    public NewContactModal fillContactInfo(Contact contact) {
        new PickList(driver, "Salutation").select(contact.getSalutation());
        new Input(driver, "First Name").write(contact.getFirstName());
        new Input(driver, "Last Name").write(contact.getLastName());
        new PickList(driver, "Account Name").searchResultOption(contact.getAccountName());
        new Input(driver, "Title").write(contact.getTitle());
        new Input(driver, "Department").write(contact.getDepartment());
        new Input(driver, "Birthdate").write(contact.getBirthdate());
        new PickList(driver, "Reports To").searchResultOption(contact.getReportsTo());
        new PickList(driver, "Lead Source").select(contact.getLeadSource());
        new Input(driver, "Phone").write(contact.getPhone());
        new Input(driver, "Home Phone").write(contact.getHomePhone());
        new Input(driver, "Mobile").write(contact.getMobile());
        new Input(driver, "Other Phone").write(contact.getOtherPhone());
        new Input(driver, "Fax").write(contact.getFax());
        new Input(driver, "Email").write(contact.getEmail());
        new Input(driver, "Assistant").write(contact.getPhone());
        new Input(driver, "Asst. Phone").write(contact.getAsstPhone());
        return this;
    }

    @Step("Fill address part of window.")
    public NewContactModal fillAddressInfo(Contact contact) {
        new Textarea(driver, "Mailing Street").write(contact.getMailingStreet());
        new Input(driver, "Mailing City").write(contact.getMailingCity());
        new Input(driver, "Mailing State/Province").write(contact.getMailingProvince());
        new Input(driver, "Mailing Zip/Postal Code").write(contact.getMailingZipcode());
        new Input(driver, "Mailing Country").write(contact.getMailingCountry());
        new Textarea(driver, "Other Street").write(contact.getOtherStreet());
        new Input(driver, "Other City").write(contact.getOtherCity());
        new Input(driver, "Other State/Province").write(contact.getOtherProvince());
        new Input(driver, "Other Zip/Postal Code").write(contact.getOtherZipcode());
        new Input(driver, "Other Country").write(contact.getOtherCountry());
        return this;
    }

    @Step("Fill additional info part of window.")
    public NewContactModal fillAdditionalInfo(Contact contact) {
        new Input(driver, "Languages").write(contact.getLanguages());
        new PickList(driver, "Level").select(contact.getLevel());
        return this;
    }

    @Step("Fill description part of window.")
    public NewContactModal fillDescription(Contact contact) {
        new Textarea(driver, "Description").write(contact.getDescription());
        return this;
    }

    @Step("Create new contact.")
    public ContactPage createContact() {
        driver.findElement(By.xpath(SAVE_BUTTON)).click();
        return new ContactPage(driver);
    }
}
