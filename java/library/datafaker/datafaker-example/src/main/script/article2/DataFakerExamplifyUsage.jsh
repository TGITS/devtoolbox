//DEPS net.datafaker:datafaker:1.9.0

/** 
 * Pour executer avec JBang : jbang DataFakerExamplifyUsage.jsh
 * <p>
 * Pour exécuter sous JShell :
 * jshell --class-path .;.\lib\datafaker-1.9.0.jar
 * /open DataFakerExamplifyUsage.jsh
 */
import net.datafaker.Faker;
import java.util.stream.IntStream;

// Instanciation d'un objet Faker pour pouvoir générer des valeurs aléatoires
Faker faker = new Faker();

//Chaque occurence du caractère est remplacée par une valeur aléatoire parmi l'ensemble des valeurs possibles
IntStream.range(0, 10).forEach(i -> System.out.println(faker.examplify("abc_ABC-123")));