//DEPS net.datafaker:datafaker:1.9.0

/** 
 * Pour executer avec JBang : jbang SimpleCollectionUsage.jsh
 * <p>
 * Pour exécuter sous JShell :
 * jshell --class-path .;.\lib\datafaker-1.9.0.jar
 * /open SimpleCollectionUsage.jsh
 */

import net.datafaker.Faker;
import java.util.List;

// Instanciation d'un objet Faker pour pouvoir générer des valeurs aléatoires
Faker faker = new Faker();
 
// <String>collection() : Type de la séquence
// suppliers(() -> faker.code().isbn10(true)) : Création des éléments de la séquence
// len(5, 10) : Limites hautes et basses sur la taille de la séquence
// generate() : génération de la séquence
List<String> isbns = faker.<String>collection().suppliers(() -> faker.code().isbn10(true)).len(5, 10).generate();                                      

System.out.println("Printing some ISBNs (between 5 and 10):");
isbns.forEach(System.out::println);
