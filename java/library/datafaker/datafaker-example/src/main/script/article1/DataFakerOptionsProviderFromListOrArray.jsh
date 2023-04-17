//DEPS net.datafaker:datafaker:1.8.0

/** 
 * Pour executer avec JBang :
 * <p>
 * jbang DataFakerOptionsProviderFromListOrArray.jsh
 * <p>
 * La ligne //DEPS net.datafaker:datafaker:1.8.0 au début du script est pour le lancement avec JBang.
 * Elle est ignorée si on lance directement avec JShell
 * <p>
 * A exécuter sous JShell :
 * <p>
 * Il faut avoir lancé JShell en précisant un classpath contenant la bibliothèque DataFaker.
 * <p>
 * Si vous avez récupéré datafaker-1.8.0.jar (sur https://mvnrepository.com/artifact/net.datafaker/datafaker/1.8.0 par exemple).
 * et que vous l'avez placé dans le sous-répertoire <code>lib</code> par rapport au répertoire courant dans lequel se trouvent les scripts 
 * et dans lequel vous allez exécuter JShell, il faut lancer JShell de la manière suivante : 
 * jshell --class-path .;.\lib\datafaker-1.8.0.jar
 * <p>
 * Ensuite, une fois sous jshell ouvrez et exécuter le script avec :
 * /open DataFakerOptionsProviderFromListOrArray.jsh
 */
import net.datafaker.Faker;
import net.datafaker.providers.base.Options;

import java.util.List;
import java.util.stream.IntStream;

enum DaysOfWeek {
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    FRIDAY,
    SATURDAY,
    SUNDAY
};

// Instanciation d'un objet Faker pour pouvoir générer des valeurs aléatoires
Faker faker = new Faker();

Options options = faker.options();
System.out.println("Choosing randomly an option from a List or an Array");
List<String> daysOfWeekAsList = List.of("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday");
IntStream.range(0, 10).forEach(i -> System.out.println("My Favorite day is (iteration #" + i + ") : " + options.nextElement(daysOfWeekAsList)));
System.out.println();

DaysOfWeek[] daysOfWeekAsArray = DaysOfWeek.values();
IntStream.range(0, 10).forEach(i -> System.out.println("My Favorite day is (iteration #" + i + ") : " + options.nextElement(daysOfWeekAsArray)));
