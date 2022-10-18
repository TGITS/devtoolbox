package tgits.datafaker.example.provider;

import net.datafaker.Faker;
import net.datafaker.providers.base.Internet;
import net.datafaker.providers.base.PhoneNumber;

import java.io.PrintStream;

public class PhoneNumberAndEmailProviderExample {

    private final Faker faker;
    private final PrintStream out;

    public PhoneNumberAndEmailProviderExample() {
        this.faker = new Faker();
        this.out = System.out;
    }

    public PhoneNumberAndEmailProviderExample(final Faker faker) {
        this.faker = faker;
        this.out = System.out;
    }

    public PhoneNumberAndEmailProviderExample(final Faker faker, final PrintStream out) {
        this.faker = faker;
        this.out = out;
    }

    public void print() {
        final PhoneNumber phoneNumber = this.faker.phoneNumber();
        final Internet internet = this.faker.internet();
    }
}
