package dto;

import com.github.javafaker.Faker;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class AccountFactory {

    private static final Map<String, String[]> PICKLISTS = new HashMap<>();

    static {
        PICKLISTS.put("Type", new String[]{"--None--", "Prospect", "Customer - Direct", "Customer - Channel", "Channel Partner / Reseller", "Installation Partner", "Technology Partner", "Other"});
        PICKLISTS.put("Industry", new String[]{"--None--", "Agriculture", "Apparel", "Banking", "Biotechnology", "Chemicals", "Communications", "Construction", "Consulting", "Education", "Electronics", "Energy", "Engineering", "Entertainment", "Environmental", "Finance", "Food & Beverage", "Government", "Healthcare", "Hospitality", "Insurance", "Machinery", "Manufacturing", "Media", "Not For Profit", "Recreation", "Retail", "Shipping", "Technology", "Telecommunications", "Transportation", "Utilities", "Other"});
        PICKLISTS.put("Rating", new String[]{"--None--", "Hot", "Warm", "Cold"});
        PICKLISTS.put("Ownership", new String[]{"--None--", "Public", "Private", "Subsidiary", "Other"});
        PICKLISTS.put("Customer Priority", new String[]{"--None--", "High", "Low", "Medium"});
        PICKLISTS.put("Active", new String[]{"--None--", "No", "Yes"});
        PICKLISTS.put("SLA", new String[]{"--None--", "Gold", "Silver", "Platinum", "Bronze"});
        PICKLISTS.put("Upsell Opportunity", new String[]{"--None--", "No", "Yes", "Maybe"});
    }

    Random random;
    Faker faker;

    public AccountFactory() {
        random = new Random();
        faker = new Faker();
    }

    public String getRandomPicklistItem(String label) {

        if (label == null || !PICKLISTS.containsKey(label)) {
            throw new IllegalArgumentException("Invalid label: " + label);
        }

        String[] items = PICKLISTS.get(label);
        return items[random.nextInt(items.length)];
    }

    public Account getAccount(String parentAcc) {
        return new Account(
                faker.company().name(),
                parentAcc,
                faker.number().digits(4),
                faker.company().url(),
                getRandomPicklistItem("Type"),
                getRandomPicklistItem("Industry"),
                faker.number().digits(7),
                getRandomPicklistItem("Rating"),
                faker.phoneNumber().phoneNumber(),
                faker.phoneNumber().cellPhone(),
                faker.company().url(),
                faker.company().bs(),
                getRandomPicklistItem("Ownership"),
                faker.number().digits(3),
                faker.number().digits(4),
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
                getRandomPicklistItem("Customer Priority"),
                faker.date().toString(),
                faker.number().digit(),
                getRandomPicklistItem("Active"),
                getRandomPicklistItem("SLA"),
                faker.number().digits(6),
                getRandomPicklistItem("Upsell Opportunity"),
                faker.lorem().paragraph()
        );
    }
}
