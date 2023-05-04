//DEPS net.datafaker:datafaker:1.9.0

/** 
 * Pour executer avec JBang : jbang DataFakerTemplateUsage_1.jsh
 * Pour exécuter sous JShell :
 * jshell --class-path .;.\lib\datafaker-1.9.0.jar
 * /open DataFakerTemplateUsage_1.jsh
 */
import net.datafaker.Faker;
import java.util.stream.IntStream;

// Instanciation d'un objet Faker pour pouvoir générer des valeurs aléatoires
Faker faker = new Faker();

//Un caractère spécifique (ici le caractère 'x') est remplacé par une chaine de caractère parmi plusieurs valeurs de chaînes possibles
System.out.println("Print days of week ; the 'x' in 'xday' is replaced with 'Mon', 'Tues', etc.");
IntStream.range(0, 10).forEach(i -> System.out.println(faker.templatify("xday", 'x', "Mon", "Tues", "Wednes", "Thurs", "Fri", "Satur", "Sun")));