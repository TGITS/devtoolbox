package tgits.datafaker.example.provider;

import net.datafaker.Faker;
import net.datafaker.Hashing;

import java.io.PrintStream;

public class HashingProviderExample {

    private final Faker faker;
    private final PrintStream out;

    public HashingProviderExample() {
        this.faker = new Faker();
        this.out = System.out;
    }

    public HashingProviderExample(final Faker faker) {
        this.faker = faker;
        this.out = System.out;
    }

    public HashingProviderExample(final Faker faker, final PrintStream out) {
        this.faker = faker;
        this.out = out;
    }

    public void print() {
        final Hashing hashing = this.faker.hashing();
    }
}
