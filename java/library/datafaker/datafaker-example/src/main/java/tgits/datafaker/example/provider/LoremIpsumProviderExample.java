package tgits.datafaker.example.provider;

import net.datafaker.Faker;
import net.datafaker.providers.base.Lorem;

import java.io.PrintStream;

public class LoremIpsumProviderExample {

    private final Faker faker;
    private final PrintStream out;

    public LoremIpsumProviderExample(final Faker faker, final PrintStream out) {
        this.faker = faker;
        this.out = out;
    }

    public LoremIpsumProviderExample() {
        this(new Faker(), System.out);
    }

    public LoremIpsumProviderExample(final Faker faker) {
        this(faker, System.out);
    }

    public void print() {
        final Lorem lorem = this.faker.lorem();
    }
}
