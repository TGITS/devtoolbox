//DEPS net.datafaker:datafaker:1.8.0

/** 
 * Pour executer avec JBang :
 * <p>
 * jbang DataFakerBasicCollectionUsage.jsh
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
 * /open DataFakerBasicCollectionUsage.jsh
 */
import net.datafaker.Faker;
import java.util.List;
import java.util.stream.Stream;
import java.util.stream.IntStream;

// Instanciation d'un objet Faker pour pouvoir générer des valeurs aléatoires
Faker faker = new Faker();
 
// <String>collection() : Type de séquence factice
// suppliers(() -> faker.code().isbn10(true)) : Fournisseur de données
// len(5, 10) : Limite de taille de la séquence
// build() : Construction de la séquence factice
// get() : Récupération de la séquence sous la forme d'une liste de String
List<String> isbns = faker.<String>collection().suppliers(() -> faker.code().isbn10(true)).len(5, 10).build().get();                                      

System.out.println("Printing some ISBNs (between 5 and 10):");
isbns.forEach(System.out::println);