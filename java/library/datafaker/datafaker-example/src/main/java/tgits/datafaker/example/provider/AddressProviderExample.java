package tgits.datafaker.example.provider;

import net.datafaker.Address;
import net.datafaker.Faker;

import java.io.PrintStream;

public class AddressProviderExample {

    private final Faker faker;
    private final PrintStream out;

    public AddressProviderExample() {
        this.faker = new Faker();
        this.out = System.out;
    }

    public AddressProviderExample(final Faker faker) {
        this.faker = faker;
        this.out = System.out;
    }

    public AddressProviderExample(final Faker faker, final PrintStream out) {
        this.faker = faker;
        this.out = out;
    }

    public void print() {
        final Address address = this.faker.address();
        this.out.println("Full address : " + address.fullAddress());
        this.out.println("Country : " + address.country());
        this.out.println("City : " + address.city());
        this.out.println("City name : " + address.cityName());
        this.out.println("ZIP Code : " + address.zipCode());
    }
}
