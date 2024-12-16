package dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class Contact {

    @Builder.Default
    private final String salutation = "--None--";
    @Builder.Default
    private final String firstName = "";
    private final String lastName;
    @Builder.Default
    private final String accountName = "testName9";
    @Builder.Default
    private final String title = "";
    @Builder.Default
    private final String department = "";
    @Builder.Default
    private final String birthdate = "";
    @Builder.Default
    private final String reportsTo = "ToReport To";
    @Builder.Default
    private final String leadSource = "--None--";
    @Builder.Default
    private final String phone = "";
    @Builder.Default
    private final String homePhone = "";
    @Builder.Default
    private final String mobile = "";
    @Builder.Default
    private final String otherPhone = "";
    @Builder.Default
    private final String fax = "";
    @Builder.Default
    private final String email = "";
    @Builder.Default
    private final String assistant = "";
    @Builder.Default
    private final String asstPhone = "";
    @Builder.Default
    private final String mailingStreet = "";
    @Builder.Default
    private final String mailingCity = "";
    @Builder.Default
    private final String mailingProvince = "";
    @Builder.Default
    private final String mailingZipcode = "";
    @Builder.Default
    private final String mailingCountry = "";
    @Builder.Default
    private final String otherStreet = "";
    @Builder.Default
    private final String otherCity = "";
    @Builder.Default
    private final String otherProvince = "";
    @Builder.Default
    private final String otherZipcode = "";
    @Builder.Default
    private final String otherCountry = "";
    @Builder.Default
    private final String languages = "";
    @Builder.Default
    private final String level = "--None--";
    @Builder.Default
    private final String description = "";
}
