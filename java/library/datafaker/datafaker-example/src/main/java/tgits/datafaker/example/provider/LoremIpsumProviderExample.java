package tgits.datafaker.example.provider;

import net.datafaker.Faker;
import net.datafaker.Lorem;

import java.io.PrintStream;

public class LoremIpsumProviderExample {

    private final Faker faker;
    private final PrintStream out;

    public LoremIpsumProviderExample() {
        this.faker = new Faker();
        this.out = System.out;
    }

    public LoremIpsumProviderExample(final Faker faker) {
        this.faker = faker;
        this.out = System.out;
    }

    public LoremIpsumProviderExample(final Faker faker, final PrintStream out) {
        this.faker = faker;
        this.out = out;
    }

    public void print() {
        final Lorem lorem = this.faker.lorem();
    }
}
