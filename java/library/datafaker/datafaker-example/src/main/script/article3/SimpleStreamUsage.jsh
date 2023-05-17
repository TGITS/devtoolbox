//DEPS net.datafaker:datafaker:1.9.0

/** 
 * Pour executer avec JBang : jbang SimpleStreamUsage.jsh
 * <p>
 * Pour exécuter sous JShell :
 * jshell --class-path .;.\lib\datafaker-1.9.0.jar
 * /open SimpleStreamUsage.jsh
 */

import net.datafaker.Faker;
import java.util.stream.Stream;

// Instanciation d'un objet Faker pour pouvoir générer des valeurs aléatoires
Faker faker = new Faker();
 
// <String>stream() : Type de la séquence
// suppliers(() -> faker.code().isbn10(true)) : Création des éléments de la séquence
// len(5, 10) : Limites hautes et basses sur la taille de la séquence
// generate() : génération de la séquence
Stream<String> isbns = faker.<String>stream().suppliers(() -> faker.code().isbn10(true)).len(5, 10).generate();                                      

System.out.println("Printing some ISBNs (between 5 and 10):");
isbns.forEach(System.out::println);
