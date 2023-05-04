//DEPS net.datafaker:datafaker:1.9.0

/** 
 * Pour executer avec JBang : jbang DataFakerTemplateUsage_2.jsh
 * <p>
 * Pour exécuter sous JShell :
 * jshell --class-path .;.\lib\datafaker-1.9.0.jar
 * /open DataFakerTemplateUsage_2.jsh
 */
import net.datafaker.Faker;
import java.util.stream.IntStream;

// Instanciation d'un objet Faker pour pouvoir générer des valeurs aléatoires
Faker faker = new Faker();

//Chaque occurence du caractère est remplacée par une valeur aléatoire parmi l'ensemble des valeurs possibles
IntStream.range(0, 10).forEach(i -> System.out.println(faker.templatify("x versus x", 'x', "Jon", "Aemon", "Eddard", "Samwell", "Rhaegar", "Arya", "Brienne")));