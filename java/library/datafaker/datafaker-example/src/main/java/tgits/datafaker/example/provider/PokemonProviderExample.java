package tgits.datafaker.example.provider;

import net.datafaker.Faker;
import net.datafaker.providers.movie.Pokemon;

import java.io.PrintStream;

public class PokemonProviderExample {
    private final Faker faker;
    private final PrintStream out;

    public PokemonProviderExample() {
        this.faker = new Faker();
        this.out = System.out;
    }

    public PokemonProviderExample(final Faker faker) {
        this.faker = faker;
        this.out = System.out;
    }

    public PokemonProviderExample(final Faker faker, final PrintStream out) {
        this.faker = faker;
        this.out = out;
    }

    public void print() {
        final Pokemon code = this.faker.pokemon();
        this.out.println("Pokemon name : " + code.name());
        this.out.println("Pokemon location : " + code.location());
        this.out.println("Pokemon move : " + code.move());
    }
}
