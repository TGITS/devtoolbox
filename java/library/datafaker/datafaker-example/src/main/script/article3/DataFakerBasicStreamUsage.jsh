//DEPS net.datafaker:datafaker:1.9.0

/** 
 * Pour executer avec JBang : jbang DataFakerBasicStreamUsage.jsh
 * <p>
 * Pour exécuter sous JShell :
 * jshell --class-path .;.\lib\datafaker-1.9.0.jar
 * /open DataFakerBasicStreamUsage.jsh
 */

import net.datafaker.Faker;
import java.util.stream.Stream;

// Instanciation d'un objet Faker pour pouvoir générer des valeurs aléatoires
Faker faker = new Faker();
 
// <String>stream() : Type des items de la stream factice
// suppliers(() -> faker.code().isbn10(true)) : Fournisseur de données
// On peut mettre à profit la large collection de fornisseur de données factices de Datafaker
// len(5, 10) : Limites hautes et basses sur la taille de la séquence
// generate() : génération de la stream
Stream<String> isbns = faker.<String>stream().suppliers(() -> faker.code().isbn10(true)).len(5, 10).generate();                                      

System.out.println("Printing some ISBNs (between 5 and 10):");
isbns.forEach(System.out::println);

isbns = faker.<String>stream().suppliers(() -> faker.code().isbn10(true), () -> faker.code().isbn13(true)).len(7).generate();                                      

System.out.println("Printing more ISBNs :");
isbns.forEach(System.out::println);

Stream<String> pokemons = faker.<String>stream(() -> faker.pokemon().name()).len(8).generate();                                      

System.out.println("\nPrinting 8 random Pokemons:");
pokemons.forEach(System.out::println);

System.out.println("\nPrinting some fake strings (maximum 7):");
// alternative à generate()
// build() : Construction de la séquence factice
// get() : Récupération de la séquence sous la forme d'une stream de String
Stream<String> fakeStrings = faker.<String>stream(() -> faker.bothify("0A???_###")).maxLen(7).build().get();
fakeStrings.forEach(System.out::println);

System.out.println("\nPrinting some fake strings from several sources (minimum 5, maximum 10):");
Stream<Object> fakeStringsFromSeveralSources = faker.<Object>stream().suppliers(() -> faker.number().numberBetween(10, 30), () -> faker.bothify("0A???_###")).minLen(5).maxLen(10).generate();
fakeStringsFromSeveralSources.forEach(System.out::println);
