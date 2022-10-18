package tgits.datafaker.example.provider;

import net.datafaker.Faker;
import net.datafaker.providers.base.Number;

import java.io.PrintStream;

public class NumberProviderExample {

    private final Faker faker;
    private final PrintStream out;

    public NumberProviderExample() {
        this.faker = new Faker();
        this.out = System.out;
    }

    public NumberProviderExample(final Faker faker) {
        this.faker = faker;
        this.out = System.out;
    }

    public NumberProviderExample(final Faker faker, final PrintStream out) {
        this.faker = faker;
        this.out = out;
    }

    public void print() {
        final Number number = this.faker.number();
    }
}
