package tgits.datafaker.example.provider;

import net.datafaker.Faker;

import java.io.PrintStream;

public class MiscProviderExample {

    private final Faker faker;
    private final PrintStream out;

    public MiscProviderExample() {
        this.faker = new Faker();
        this.out = System.out;
    }

    public MiscProviderExample(final Faker faker) {
        this.faker = faker;
        this.out = System.out;
    }

    public MiscProviderExample(final Faker faker, final PrintStream out) {
        this.faker = faker;
        this.out = out;
    }

    public void print() {

    }
}
