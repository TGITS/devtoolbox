//DEPS net.datafaker:datafaker:1.9.0

/** 
 * Pour executer avec JBang :
 * <p>
 * jbang DataFakerTemplateUsage_1.jsh
 * <p>
 * La ligne //DEPS net.datafaker:datafaker:1.9.0 au début du script est pour le lancement avec JBang.
 * Elle est ignorée si on lance directement avec JShell
 * <p> 
 * A exécuter sous JShell :
 * <p>
 * Il faut avoir lancé JShell en précisant un classpath contenant la bibliothèque DataFaker.
 * <p>
 * Si vous avez récupéré datafaker-1.9.0.jar (sur https://mvnrepository.com/artifact/net.datafaker/datafaker/1.8.0 par exemple).
 * et que vous l'avez placé dans le sous-répertoire <code>lib</code> par rapport au répertoire courant dans lequel se trouvent les scripts 
 * et dans lequel vous allez exécuter JShell, il faut lancer JShell de la manière suivante : 
 * jshell --class-path .;.\lib\datafaker-1.9.0.jar
 * <p>
 * Ensuite, une fois sous jshell ouvrez et exécuter le script avec :
 * /open DataFakerTemplateUsage_1.jsh
 */
import net.datafaker.Faker;
import java.util.stream.IntStream;

// Instanciation d'un objet Faker pour pouvoir générer des valeurs aléatoires
Faker faker = new Faker();

//Un caractère spécifique (ici le caractère 'x') est remplacé par une chaine de caractère parmi plusieurs valeurs de chaînes possibles
System.out.println("Print days of week ; the 'x' in 'xday' is replaced with 'Mon', 'Tues', etc.");
IntStream.range(0, 10).forEach(i -> System.out.println(faker.templatify("xday", 'x', "Mon", "Tues", "Wednes", "Thurs", "Fri", "Satur", "Sun")));