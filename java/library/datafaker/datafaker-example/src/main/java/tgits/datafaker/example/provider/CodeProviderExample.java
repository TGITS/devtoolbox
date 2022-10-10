package tgits.datafaker.example.provider;

import net.datafaker.Code;
import net.datafaker.Faker;

import java.io.PrintStream;

public class CodeProviderExample {

    private final Faker faker;
    private final PrintStream out;

    public CodeProviderExample() {
        this.faker = new Faker();
        this.out = System.out;
    }

    public CodeProviderExample(final Faker faker) {
        this.faker = faker;
        this.out = System.out;
    }

    public CodeProviderExample(final Faker faker, final PrintStream out) {
        this.faker = faker;
        this.out = out;
    }

    public void print() {
        final Code code = this.faker.code();
    }
}
