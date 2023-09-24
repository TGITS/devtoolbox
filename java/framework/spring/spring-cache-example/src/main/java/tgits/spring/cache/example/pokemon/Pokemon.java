package tgits.spring.cache.example.pokemon;

import java.util.List;

public record Pokemon(int number, String name, List<String> types, int hp, int attack, int defense, int specialAttack, int specialDefense, int speed, int generation, boolean legendary) {
}
