package tgits.datafaker.example.provider;

import net.datafaker.DateAndTime;
import net.datafaker.Faker;

import java.io.PrintStream;

public class DateTimeAndDurationProviderExample {

    private final Faker faker;
    private final PrintStream out;

    public DateTimeAndDurationProviderExample() {
        this.faker = new Faker();
        this.out = System.out;
    }

    public DateTimeAndDurationProviderExample(final Faker faker) {
        this.faker = faker;
        this.out = System.out;
    }

    public DateTimeAndDurationProviderExample(final Faker faker, final PrintStream out) {
        this.faker = faker;
        this.out = out;
    }

    public void print() {
        final DateAndTime dateAndTime = this.faker.date();
    }
}
