package tgits.datafaker.example.expression;

import net.datafaker.Faker;

import java.io.PrintStream;

public class CsvExpressionExample {

    private final Faker faker;
    private final PrintStream out;

    public CsvExpressionExample() {
        this.faker = new Faker();
        this.out = System.out;
    }

    public CsvExpressionExample(final Faker faker) {
        this.faker = faker;
        this.out = System.out;
    }

    public CsvExpressionExample(final Faker faker, final PrintStream out) {
        this.faker = faker;
        this.out = out;
    }

    public void print() {

    }
}
