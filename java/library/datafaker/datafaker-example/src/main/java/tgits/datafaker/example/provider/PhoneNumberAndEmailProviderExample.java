package tgits.datafaker.example.provider;

import net.datafaker.Faker;
import net.datafaker.providers.base.Internet;
import net.datafaker.providers.base.PhoneNumber;

import java.io.PrintStream;

public class PhoneNumberAndEmailProviderExample {

    private final Faker faker;
    private final PrintStream out;

    public PhoneNumberAndEmailProviderExample(final Faker faker, final PrintStream out) {
        this.faker = faker;
        this.out = out;
    }

    public PhoneNumberAndEmailProviderExample() {
        this(new Faker(), System.out);
    }

    public PhoneNumberAndEmailProviderExample(final Faker faker) {
        this(faker, System.out);
    }

    public void print() {
        final PhoneNumber phoneNumber = this.faker.phoneNumber();
        final Internet internet = this.faker.internet();

        this.out.println("Phone Number : " + phoneNumber.phoneNumber());
        this.out.println("CellPhone Number : " + phoneNumber.cellPhone());

        this.out.println("Email address : " + internet.emailAddress());
        this.out.println("(Safe) Email address : " + internet.safeEmailAddress());
        this.out.println("IPV6 address : " + internet.ipV6Address());
        this.out.println("URL : " + internet.url());
        this.out.println("User Agent : " + internet.userAgent());
        this.out.println("Slug : " + internet.slug());
        this.out.println("UUID : " + internet.uuid());
    }
}
