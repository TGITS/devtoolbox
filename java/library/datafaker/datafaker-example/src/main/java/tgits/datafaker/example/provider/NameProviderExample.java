package tgits.datafaker.example.provider;

import java.io.PrintStream;
import net.datafaker.Faker;
import net.datafaker.providers.base.Name;

public class NameProviderExample {

  private final Faker faker;
  private final PrintStream out;

  public NameProviderExample(final Faker faker, final PrintStream out) {
    this.faker = faker;
    this.out = out;
  }

  public NameProviderExample() {
    this(new Faker(), System.out);
  }

  public NameProviderExample(final Faker faker) {
    this(faker, System.out);
  }

  public void print() {
    final Name name = faker.name();
    out.println("Name : " + name.name());
    out.println("Full name : " + name.fullName());
    out.println("First name : " + name.firstName());
    out.println("Last name : " + name.lastName());
    out.println("Name with middle name : " + name.nameWithMiddle());
    out.println("Name Prefix : " + name.prefix());
    out.println("Name Suffix : " + name.suffix());
    out.println("Title : " + name.title());
  }
}
