package tgits.datafaker.example.expression;

import net.datafaker.Faker;

import java.io.PrintStream;

public class CsvExpressionExample {

    private final Faker faker;
    private final PrintStream out;

    public CsvExpressionExample(final Faker faker, final PrintStream out) {
        this.faker = faker;
        this.out = out;
    }

    public CsvExpressionExample() {
        this(new Faker(), System.out);
    }

    public CsvExpressionExample(final Faker faker) {
        this(faker, System.out);
    }

    public void print() {

    }
}
