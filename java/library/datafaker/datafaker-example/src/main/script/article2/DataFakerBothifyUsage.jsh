//DEPS net.datafaker:datafaker:1.9.0

/** 
 * Pour executer avec JBang : jbang DataFakerBothifyUsage.jsh
 * <p>
 * Pour exécuter sous JShell :
 * jshell --class-path .;.\lib\datafaker-1.9.0.jar
 * /open DataFakerBothifyUsage.jsh
 */
import net.datafaker.Faker;
import java.util.stream.IntStream;

// Instanciation d'un objet Faker pour pouvoir générer des valeurs aléatoires
Faker faker = new Faker();

//Avec la méthode 'bothify', "?" est remplacé par une lettre et par un nombre "#"
//Un paramètre booléen optionel (si absent équivaut à la valeur 'false') indique s'il faut que les lettres soient minuscules ou majuscules
System.out.println("Print the digits from 0 to 9, followed by an underscore, three random lowercase letters, another underscore and three random digits :");
IntStream.range(0, 10).forEach(i -> System.out.println(faker.bothify(i + "_???_###")));
System.out.println();
System.out.println("Print the digits from 0 to 9, followed by an underscore, three random uppercase letters, another underscore and three random digits :");
IntStream.range(0, 10).forEach(i -> System.out.println(faker.bothify(i + "_???_###", true)));