package tgits.datafaker.example.provider;

import net.datafaker.ChuckNorris;
import net.datafaker.Faker;

import java.io.PrintStream;

public class ChuckNorrisProviderExample {

    private final Faker faker;
    private final PrintStream out;

    public ChuckNorrisProviderExample() {
        this.faker = new Faker();
        this.out = System.out;
    }

    public ChuckNorrisProviderExample(final Faker faker) {
        this.faker = faker;
        this.out = System.out;
    }

    public ChuckNorrisProviderExample(final Faker faker, final PrintStream out) {
        this.faker = faker;
        this.out = out;
    }

    public void print() {
        final ChuckNorris chuckNorris = this.faker.chuckNorris();
        this.out.println("Chuck Norris Fact : " + chuckNorris.fact());
    }
}
