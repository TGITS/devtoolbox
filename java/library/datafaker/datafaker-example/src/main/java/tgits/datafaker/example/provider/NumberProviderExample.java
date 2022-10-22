package tgits.datafaker.example.provider;

import net.datafaker.Faker;
import net.datafaker.providers.base.Number;

import java.io.PrintStream;

public class NumberProviderExample {

    private final Faker faker;
    private final PrintStream out;

    public NumberProviderExample(final Faker faker, final PrintStream out) {
        this.faker = faker;
        this.out = out;
    }

    public NumberProviderExample() {
        this(new Faker(), System.out);
    }

    public NumberProviderExample(final Faker faker) {
        this(faker,System.out);
    }

    public void print() {
        final Number number = this.faker.number();
        this.out.println("Random integral number between 10 and 30: " + number.numberBetween(10,30));
        this.out.println("Random real number between 10 and 30 with max 3 decimals: " + number.randomDouble(3,10,30));
        this.out.println("Random digit : " + number.digit());
        this.out.println("Random digits : " + number.digits(5));
        this.out.println("Random positive integral number : " + number.positive());
        this.out.println("Random negative integral number : " + number.negative());
    }
}
