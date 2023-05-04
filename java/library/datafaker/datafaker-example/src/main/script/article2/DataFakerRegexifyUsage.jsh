//DEPS net.datafaker:datafaker:1.9.0

/** 
 * Pour executer avec JBang : jbang DataFakerRegexifyUsage.jsh
 * <p>
 * Les lignes commençant par //DEPS xxx au début du script sont pour le lancement avec JBang.
 * Elle est ignorée si on lance directement avec JShell
 * <p>
 * Pour exécuter sous JShell :
 * <p>
 * Il faut avoir lancé JShell en précisant un classpath contenant la bibliothèque DataFaker 
 * et dans le cas particulier de ce shell de 2 autres bibliothèques dont Datafaker a besoin dans le classpath.
 * <p>
 * Il faut donc récupérer : 
 * <ul>
 *  <li>datafaker-1.9.0.jar (https://mvnrepository.com/artifact/net.datafaker/datafaker/1.9.0 par exemple)
 *  <li>generex-1.0.2.jar (https://mvnrepository.com/artifact/com.github.mifmif/generex/1.0.2 par exemple)
 *  <li>automaton-1.11-8.jar (https://mvnrepository.com/artifact/dk.brics/automaton/1.11-8 par exemple)
 * </ul>
 * <p>
 * Il faut placer les jar récupérés dans le sous-répertoire <code>lib</code> par rapport au répertoire courant dans lequel se trouvent les scripts 
 * et dans lequel vous allez exécuter JShell, il faut lancer JShell de la manière suivante : 
 * jshell --class-path .;.\lib\datafaker-1.9.0.jar;.\lib\generex-1.0.2.jar;.\lib\automaton-1.11-8.jar
 * <p>
 * Ensuite, une fois sous jshell ouvrez et exécuter le script avec :
 * /open DataFakerRegexifyUsage.jsh
 */
import net.datafaker.Faker;
import java.util.stream.IntStream;

// Instanciation d'un objet Faker pour pouvoir générer des valeurs aléatoires
Faker faker = new Faker();

// On souhaite qu'une chaine aléatoire ayant de 4 à 10 lettres 
IntStream.range(0, 10).forEach(i -> System.out.println(faker.regexify("[a-zA-Z]{4,10}")));

System.out.println()
// On souhaite qu'une chaine aléatoire soit générée avec 2 à 5 lettres, 
// 2 caractères parmi '_', '?', '!', '*', '-'
// et 3 chiffres 
IntStream.range(0, 10).forEach(i -> System.out.println(faker.regexify("[a-zA-Z]{2,5}[_?!*-]{2}\\d{3}")));
