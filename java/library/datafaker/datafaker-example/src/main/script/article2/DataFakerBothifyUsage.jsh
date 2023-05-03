//DEPS net.datafaker:datafaker:1.9.0

/** 
 * Pour executer avec JBang :
 * <p>
 * jbang DataFakerBothifyUsage.jsh
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