package dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class Account {

    private final String accountName;
    @Builder.Default
    private final String parentAccount = "testName9";
    @Builder.Default
    private final String accountNumber = "";
    @Builder.Default
    private final String accountSite = "";
    @Builder.Default
    private final String type = "--None--";
    @Builder.Default
    private final String industry = "--None--";
    @Builder.Default
    private final String annualRevenue = "";
    @Builder.Default
    private final String rating = "--None--";
    @Builder.Default
    private final String phone = "";
    @Builder.Default
    private final String fax = "";
    @Builder.Default
    private final String website = "";
    @Builder.Default
    private final String tickerSymbol = "";
    @Builder.Default
    private final String ownership = "--None--";
    @Builder.Default
    private final String employees = "";
    @Builder.Default
    private final String sicCode = "";
    @Builder.Default
    private final String billingStreet = "";
    @Builder.Default
    private final String billingCity = "";
    @Builder.Default
    private final String billingProvince = "";
    @Builder.Default
    private final String billingZipcode = "";
    @Builder.Default
    private final String billingCountry = "";
    @Builder.Default
    private final String shippingStreet = "";
    @Builder.Default
    private final String shippingCity = "";
    @Builder.Default
    private final String shippingProvince = "";
    @Builder.Default
    private final String shippingZipcode = "";
    @Builder.Default
    private final String shippingCountry = "";
    @Builder.Default
    private final String customerPriority = "--None--";
    @Builder.Default
    private final String slaExpirationDate = "";
    @Builder.Default
    private final String numberOfLocations = "";
    @Builder.Default
    private final String active = "--None--";
    @Builder.Default
    private final String sla = "--None--";
    @Builder.Default
    private final String slaSerialNumber = "";
    @Builder.Default
    private final String upsellOpportunity = "--None--";
    @Builder.Default
    private final String description = "";
}
