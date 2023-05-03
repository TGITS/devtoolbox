//DEPS net.datafaker:datafaker:1.9.0

/** 
 * Pour executer avec JBang :
 * <p>
 * jbang DataFakerOptionsProviderSubset.jsh
 * <p>
 * La ligne //DEPS net.datafaker:datafaker:1.9.0 au début du script est pour le lancement avec JBang.
 * Elle est ignorée si on lance directement avec JShell
 * <p>
 * A exécuter sous JShell :
 * <p>
 * Il faut avoir lancé JShell en précisant un classpath contenant la bibliothèque DataFaker.
 * <p>
 * Si vous avez récupéré datafaker-1.9.0.jar (sur https://mvnrepository.com/artifact/net.datafaker/datafaker/1.8.1 par exemple).
 * et que vous l'avez placé dans le sous-répertoire <code>lib</code> par rapport au répertoire courant dans lequel se trouvent les scripts 
 * et dans lequel vous allez exécuter JShell, il faut lancer JShell de la manière suivante : 
 * jshell --class-path .;.\lib\datafaker-1.9.0.jar
 * <p>
 * Ensuite, une fois sous jshell ouvrez et exécuter le script avec :
 * /open DataFakerOptionsProviderSubset.jsh
 */
import net.datafaker.Faker;
import net.datafaker.providers.base.Options;

import java.util.Set;
import java.util.stream.Collectors;
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

for(int i = 0 ; i < 4 ; i++) {
    System.out.println();
    Set<DaysOfWeek> fourDaysOfWeek = options.subset(4,daysOfWeekAsArray);
    System.out.println("A set of four random days among seven : " + fourDaysOfWeek.stream().map(DaysOfWeek::toString).collect(Collectors.joining(", ")));
}
