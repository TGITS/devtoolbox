package tgits.datafaker.example.provider;

import java.io.PrintStream;
import net.datafaker.Faker;
import net.datafaker.providers.base.Address;

public class AddressProviderExample {

  private final Faker faker;
  private final PrintStream out;

  public AddressProviderExample(final Faker faker, final PrintStream out) {
    this.faker = faker;
    this.out = out;
  }

  public AddressProviderExample() {
    this(new Faker(), System.out);
  }

  public AddressProviderExample(final Faker faker) {
    this(faker, System.out);
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
