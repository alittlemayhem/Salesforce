package tests;

import dto.Contact;
import dto.ContactFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactsTest extends BaseTest{

    ContactFactory contactFactory = new ContactFactory();
    Contact contact = contactFactory.getContact("ToReport To", "testName9");

    @Test(testName = "New contact creation", description = "Filling out all fields in the contact modal window, check that message about successful creation appeared.")
    public void checkCreateContact() {
        loginPage.open()
                .isPageOpened()
                .login("tborodich@tms.sandbox", "Password001");

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
        }
        else {
            contactFullName = contact.getSalutation() + " " + contact.getFirstName() + " " + contact.getLastName();
        }
        String expectedMessage = String.format("Contact \"%s\" was created.", contactFullName);
        Assert.assertEquals(
                result,
                expectedMessage,
                "Message is not correct.");
    }
}
