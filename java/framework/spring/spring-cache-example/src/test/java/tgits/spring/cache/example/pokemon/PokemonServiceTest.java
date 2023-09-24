package tgits.spring.cache.example.pokemon;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class PokemonServiceTest {

    @Autowired
    private PokemonService pokemonService;

    private Pokemon bulbasaur() {
        return new Pokemon(1, "Bulbasaur", List.of("Grass", "Poison"), 45, 49, 49, 65, 65, 45, 1, false);
    }

    private Pokemon ivysaur() { return new Pokemon(2, "Ivysaur", List.of("Grass", "Poison"), 60, 62, 63, 80, 80, 60, 1, false); }

    private Pokemon venusaur() {
        return new Pokemon(3, "Venusaur", List.of("Grass", "Poison"), 80, 82, 83, 100, 100, 80, 1, false);
    }

    private List<Pokemon> listOfPokemons() {
        return List.of(
                bulbasaur(),
                ivysaur(),
                venusaur());
    }

    @Test
    void shouldStoreAndRetrievePokemon() {
        pokemonService.clearCache();
        for(String pokemonName:List.of("Bulbasaur", "Ivysaur", "Venusaur")) {
            assertThat(pokemonService.retrievePokemon(pokemonName)).isNotNull().isEmpty();
        }

        for(Pokemon pokemon:listOfPokemons()){
            pokemonService.storePokemon(pokemon);
        }

        for(String pokemonName:List.of("Bulbasaur", "Ivysaur", "Venusaur")) {
            assertThat(pokemonService.retrievePokemon(pokemonName)).isNotNull().isNotEmpty();
        }

        assertThat(pokemonService.retrievePokemon("Bulbasaur")).isNotEmpty().contains(bulbasaur());
        assertThat(pokemonService.retrievePokemon("Ivysaur")).isNotEmpty().contains(ivysaur());
        assertThat(pokemonService.retrievePokemon("Venusaur")).isNotEmpty().contains(venusaur());
    }

    @Test
    void shouldDeletePokemonByName() {

        pokemonService.clearCache();
        for(String pokemonName:List.of("Bulbasaur", "Ivysaur", "Venusaur")) {
            assertThat(pokemonService.retrievePokemon(pokemonName)).isNotNull().isEmpty();
        }

        for(Pokemon pokemon:listOfPokemons()){
            pokemonService.storePokemon(pokemon);
        }

        for(String pokemonName:List.of("Bulbasaur", "Ivysaur", "Venusaur")) {
            assertThat(pokemonService.retrievePokemon(pokemonName)).isNotNull().isNotEmpty();
        }

        pokemonService.deletePokemon("Bulbasaur");
        assertThat(pokemonService.retrievePokemon("Bulbasaur")).isNotNull().isEmpty();

        pokemonService.deletePokemon("Ivysaur");
        assertThat(pokemonService.retrievePokemon("Ivysaur")).isNotNull().isEmpty();

        pokemonService.deletePokemon("Venusaur");
        assertThat(pokemonService.retrievePokemon("Venusaur")).isNotNull().isEmpty();
    }
}
