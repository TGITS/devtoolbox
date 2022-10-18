package tgits.datafaker.example.provider;

import net.datafaker.Faker;
import net.datafaker.providers.base.Name;

import java.io.PrintStream;

public class NameProviderExample {

    private final Faker faker;
    private final PrintStream out;

    public NameProviderExample() {
        this.faker = new Faker();
        this.out = System.out;
    }

    public NameProviderExample(final Faker faker) {
        this.faker = faker;
        this.out = System.out;
    }

    public NameProviderExample(final Faker faker, final PrintStream out) {
        this.faker = faker;
        this.out = out;
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
