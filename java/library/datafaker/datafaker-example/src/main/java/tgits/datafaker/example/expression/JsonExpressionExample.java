package tgits.datafaker.example.expression;

import net.datafaker.Faker;

import java.io.PrintStream;

public class JsonExpressionExample {

    private final Faker faker;
    private final PrintStream out;

    public JsonExpressionExample(final Faker faker, final PrintStream out) {
        this.faker = faker;
        this.out = out;
    }

    public JsonExpressionExample() {
        this(new Faker(), System.out);
    }

    public JsonExpressionExample(final Faker faker) {
        this(faker, System.out);
    }

    public void print() {

    }
}
