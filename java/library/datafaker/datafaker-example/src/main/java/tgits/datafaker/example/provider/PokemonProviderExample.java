package tgits.datafaker.example.provider;

import net.datafaker.Faker;
import net.datafaker.providers.movie.Pokemon;

import java.io.PrintStream;

public class PokemonProviderExample {
    private final Faker faker;
    private final PrintStream out;

    public PokemonProviderExample(final Faker faker, final PrintStream out) {
        this.faker = faker;
        this.out = out;
    }

    public PokemonProviderExample() {
        this(new Faker(), System.out);
    }

    public PokemonProviderExample(final Faker faker) {
        this(faker, System.out);
    }

    public void print() {
        final Pokemon pokemon = this.faker.pokemon();
        this.out.println("Pokemon name : " + pokemon.name());
        this.out.println("Pokemon location : " + pokemon.location());
        this.out.println("Pokemon move : " + pokemon.move());
        this.out.println("Pokemon type : " + pokemon.type());
    }
}
