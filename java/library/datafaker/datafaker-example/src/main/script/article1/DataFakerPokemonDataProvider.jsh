//DEPS net.datafaker:datafaker:1.9.0

/** 
 * Pour executer avec JBang :
 * <p>
 * jbang DataFakerPokemonDataProvider.jsh
 * <p>
 * La ligne //DEPS net.datafaker:datafaker:1.9.0 au début du script est pour le lancement avec JBang.
 * Elle est ignorée si on lance directement avec JShell
 * <p>
 * A exécuter sous JShell :
 * 
 * Il faut avoir lancé JShell en précisant un classpath contenant la bibliothèque DataFaker.
 * par exemple : jshell --class-path .;.\lib\datafaker-1.9.0.jar
 * Ensuite, une fois sous jshell ouvrez et exécuter le script avec :
 * /open DataFakerPokemonDataProvider.jsh
 */
import net.datafaker.Faker;
import net.datafaker.providers.entertainment.Pokemon;

// Faker est l'objet à instancier pour pouvoir générer des valeurs aléatoires
Faker faker = new Faker();

Pokemon pokemon = faker.pokemon();

System.out.println("Pokemon related random values");
System.out.println("Pokemon name : " + pokemon.name());
System.out.println("Location in the Pokemon universe : " + pokemon.location());
System.out.println("Pokemon type : " + pokemon.type());
