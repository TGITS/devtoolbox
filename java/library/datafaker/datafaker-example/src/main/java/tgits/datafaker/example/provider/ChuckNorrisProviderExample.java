package tgits.datafaker.example.provider;

import java.io.PrintStream;
import net.datafaker.Faker;
import net.datafaker.providers.entertainment.ChuckNorris;

public class ChuckNorrisProviderExample {

  private final Faker faker;
  private final PrintStream out;

  public ChuckNorrisProviderExample(final Faker faker, final PrintStream out) {
    this.faker = faker;
    this.out = out;
  }

  public ChuckNorrisProviderExample() {
    this(new Faker(), System.out);
  }

  public ChuckNorrisProviderExample(final Faker faker) {
    this(faker, System.out);
  }

  public void print() {
    final ChuckNorris chuckNorris = this.faker.chuckNorris();
    this.out.println("Chuck Norris Fact : " + chuckNorris.fact());
  }
}
