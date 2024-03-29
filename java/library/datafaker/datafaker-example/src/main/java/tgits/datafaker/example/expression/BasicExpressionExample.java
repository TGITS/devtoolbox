package tgits.datafaker.example.expression;

import java.io.PrintStream;
import net.datafaker.Faker;

public class BasicExpressionExample {

  private final Faker faker;
  private final PrintStream out;

  public BasicExpressionExample(final Faker faker, final PrintStream out) {
    this.faker = faker;
    this.out = out;
  }

  public BasicExpressionExample() {
    this(new Faker(), System.out);
  }

  public BasicExpressionExample(final Faker faker) {
    this(faker, System.out);
  }

  public void print() {}
}
