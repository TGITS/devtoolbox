package tgits.datafaker.example.expression;

import net.datafaker.Faker;

import java.io.PrintStream;

public class BasicExpressionExample {

    private final Faker faker;
    private final PrintStream out;

    public BasicExpressionExample() {
        this.faker = new Faker();
        this.out = System.out;
    }

    public BasicExpressionExample(final Faker faker) {
        this.faker = faker;
        this.out = System.out;
    }

    public BasicExpressionExample(final Faker faker, final PrintStream out) {
        this.faker = faker;
        this.out = out;
    }

    public void print() {

    }
}
