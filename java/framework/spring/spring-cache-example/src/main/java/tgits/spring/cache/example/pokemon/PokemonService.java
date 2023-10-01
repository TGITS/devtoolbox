package tgits.spring.cache.example.pokemon;

import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PokemonService {

    private final Cache pokemonCache;

    public PokemonService(final CacheManager cacheManager){
        this.pokemonCache = cacheManager.getCache("pokemons");
    }

    public void storePokemon(final Pokemon pokemon){
        pokemonCache.putIfAbsent(pokemon.name(), pokemon);
    }

    public Optional<Pokemon> retrievePokemon(final String pokemonName){
        return Optional.ofNullable(pokemonCache.get(pokemonName, Pokemon.class));
    }

    public void clearCache() {
        pokemonCache.clear();
    }

    public void deletePokemon(final String pokemonName) {
        pokemonCache.evictIfPresent(pokemonName);
    }

}
