//DEPS net.datafaker:datafaker:1.9.0

/** 
 * Pour executer avec JBang :
 * <p>
 * jbang DataFakerLocalizedPokemonDataProvider.jsh
 * <p>
 * La ligne //DEPS net.datafaker:datafaker:1.9.0 au début du script est pour le lancement avec JBang.
 * Elle est ignorée si on lance directement avec JShell
 * <p>
 * A exécuter sous JShell :
 * 
 * Il faut avoir lancé JShell en précisant un classpath contenant la bibliothèque DataFaker.
 * par exemple : jshell --class-path .;.\lib\datafaker-1.9.0.jar
 * Ensuite, une fois sous jshell ouvrez et exécuter le script avec :
 * /open DataFakerLocalizedPokemonDataProvider.jsh
 * 
 * Afin de pouvoir voir correctement les caractères accentués sous une invite de commande Windows, avant de lancer JShell, il faut au préalable :
 * - Définir la variable d'environnement JAVA_TOOL_OPTIONS à la valeur -Dfile.encoding par exemple en saisissant dans l'invite de commande :
 *   SET JAVA_TOOL_OPTIONS=-Dfile.encoding=UTF8
 * - Il faut également définir l'encodage UTF-8 pour l'invite de commande en saisissant la commande suivante :
 *   chcp 65001
 */
import net.datafaker.Faker;
import net.datafaker.providers.movie.Pokemon
import java.util.Locale;

// Faker est l'objet à instancier pour pouvoir générer des valeurs aléatoires
// Il est créer avec une locale par défaut
Faker defaultFaker = new Faker();
//On peut préciser une locale spécifique au moment de la création
Faker frenchLocalizedFaker = new Faker(Locale.FRANCE);

Pokemon pokemon = defaultFaker.pokemon();

System.out.println("Pokemon related random values");
System.out.println("Pokemon name : " + pokemon.name());
System.out.println("Location in the Pokemon universe : " + pokemon.location());
System.out.println("Pokemon type : " + pokemon.type());

System.out.println("\n-------------\n")

pokemon = frenchLocalizedFaker.pokemon();
System.out.println("Valeurs aléatoires pour les Pokémons (utilisation de la locale 'FRANCE')");
System.out.println("Nom d'un Pokémon : " + pokemon.name());
System.out.println("Localisation dans l'univers de Pokemon : " + pokemon.location());
System.out.println("Type de Pokemon : " + pokemon.type());
