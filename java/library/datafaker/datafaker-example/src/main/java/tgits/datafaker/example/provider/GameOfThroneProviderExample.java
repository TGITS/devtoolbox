package tgits.datafaker.example.provider;

import java.io.PrintStream;
import net.datafaker.Faker;
import net.datafaker.providers.movie.GameOfThrones;

public class GameOfThroneProviderExample {

  private final Faker faker;
  private final PrintStream out;

  public GameOfThroneProviderExample(final Faker faker, final PrintStream out) {
    this.faker = faker;
    this.out = out;
  }

  public GameOfThroneProviderExample() {
    this(new Faker(), System.out);
  }

  public GameOfThroneProviderExample(final Faker faker) {
    this(faker, System.out);
  }

  public void print() {
    final GameOfThrones got = this.faker.gameOfThrones();
    this.out.println("A city of GoT : " + got.city());
    this.out.println("A dragon name of GoT : " + got.dragon());
    this.out.println("A character of GoT : " + got.character());
    this.out.println("A House of GoT : " + got.house());
    this.out.println("A quote from GoT : " + got.quote());
  }
}
