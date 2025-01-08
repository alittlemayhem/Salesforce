package tests;

import dto.Contact;
import dto.ContactFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactsTest extends BaseTest {

    ContactFactory contactFactory = new ContactFactory();
    Contact contact = contactFactory.getContactWithAllFields("ToReport To", "testName9");
    Contact contactWithLastNameOnly = contactFactory.getContactWithRequiredFields();

    @Test(testName = "New contact creation", description = "Filling out all fields in the contact modal window, check that message about successful creation appeared.")
    public void checkCreateContact() {
        loginPage.open()
                .isPageOpened()
                .login(user, password);

        String result = newContactModal.open()
                .isPageOpened()
                .fillContactInfo(contact)
                .fillAddressInfo(contact)
                .fillAdditionalInfo(contact)
                .fillDescription(contact)
                .createContact()
                .getSuccessMessage();

        String contactFullName = "";
        if (contact.getSalutation().equals("--None--")) {
            contactFullName = contact.getFirstName() + " " + contact.getLastName();
        } else {
            contactFullName = contact.getSalutation() + " " + contact.getFirstName() + " " + contact.getLastName();
        }
        String expectedMessage = String.format("Contact \"%s\" was created.", contactFullName);
        Assert.assertEquals(
                result,
                expectedMessage,
                "Message is not correct.");
    }

    @Test(testName = "Contact creation with required fields only", description = "Filling out only required fields in the contact modal window, check that message about successful creation appeared.")
    public void checkCreateContactWithRequiredField() {
        loginPage.open()
                .isPageOpened()
                .login(user, password);

        String result = newContactModal.open()
                .isPageOpened()
                .fillContactInfo(contactWithLastNameOnly)
                .createContact()
                .getSuccessMessage();

        String contactFullName = contactWithLastNameOnly.getLastName();
        String expectedMessage = String.format("Contact \"%s\" was created.", contactFullName);
        Assert.assertEquals(
                result,
                expectedMessage,
                "Message is not correct.");
    }
}
