//DEPS net.datafaker:datafaker:1.9.0

/** 
 * Pour executer avec JBang : jbang DataFakerNumerifyUsage.jsh
 * <p>
 * Pour exécuter sous JShell :
 * jshell --class-path .;.\lib\datafaker-1.9.0.jar
 * /open DataFakerNumerifyUsage.jsh
 */
import net.datafaker.Faker;
import java.util.stream.IntStream;

// Instanciation d'un objet Faker pour pouvoir générer des valeurs aléatoires
Faker faker = new Faker();

//La chaine modèle "_###" indique à la méthode 'numerify' de retourner une chaine commençant par un blanc souligné suivi de 3 chiffres.
//Ainsi le point d'iterrogation '#' est remplacé par un chiffre
System.out.println("Print the digits from 0 to 9, followed by an underscore and three random digits :");
IntStream.range(0, 10).forEach(i -> System.out.println(faker.numerify(i + "_###")));