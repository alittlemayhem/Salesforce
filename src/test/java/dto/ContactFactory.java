package dto;

import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class ContactFactory {

    private static final Map<String, String[]> PICKLISTS = new HashMap<>();

    static {
        PICKLISTS.put("Salutation", new String[]{"--None--", "Mr.", "Ms.", "Mrs.", "Dr.", "Prof.", "Mx."});
        PICKLISTS.put("Lead Source", new String[]{"--None--", "Web", "Phone Inquiry", "Partner Referral", "Purchased List", "Other"});
        PICKLISTS.put("Level", new String[]{"--None--", "Secondary", "Tertiary", "Primary"});
    }

    Random random;
    Faker faker;
    SimpleDateFormat sdf;

    public ContactFactory() {
        random = new Random();
        faker = new Faker();
        sdf = new SimpleDateFormat("dd.MM.yyyy");
    }

    public String getRandomPicklistItem(String label) {
        if (label == null || !PICKLISTS.containsKey(label)) {
            throw new IllegalArgumentException("Invalid label: " + label);
        }

        String[] items = PICKLISTS.get(label);
        return items[random.nextInt(items.length)];
    }

    public Contact getContact(String reportsTo, String accountName) {
        return new Contact(
                getRandomPicklistItem("Salutation"),
                faker.name().firstName(),
                faker.name().lastName(),
                accountName,
                faker.job().title(),
                faker.job().field(),
                sdf.format(faker.date().birthday()),
                reportsTo,
                getRandomPicklistItem("Lead Source"),
                faker.phoneNumber().phoneNumber(),
                faker.phoneNumber().cellPhone(),
                faker.phoneNumber().phoneNumber(),
                faker.phoneNumber().phoneNumber(),
                faker.phoneNumber().phoneNumber(),
                faker.internet().emailAddress(),
                faker.name().name(),
                faker.phoneNumber().phoneNumber(),
                faker.address().streetAddress(),
                faker.address().cityName(),
                faker.address().state(),
                faker.address().zipCode(),
                faker.address().country(),
                faker.address().streetAddress(),
                faker.address().cityName(),
                faker.address().state(),
                faker.address().zipCode(),
                faker.address().country(),
                faker.programmingLanguage().name(),
                getRandomPicklistItem("Level"),
                faker.lorem().paragraph()
        );
    }
}
