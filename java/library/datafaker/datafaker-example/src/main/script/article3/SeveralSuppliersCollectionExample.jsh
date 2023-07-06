//DEPS net.datafaker:datafaker:1.9.0

/** 
 * Pour executer avec JBang : jbang SeveralSuppliersCollectionExample.jsh
 * <p>
 * Pour exécuter sous JShell :
 * jshell --class-path .;.\lib\datafaker-1.9.0.jar
 * /open SeveralSuppliersCollectionExample.jsh
 */

import net.datafaker.Faker;
import java.util.List;

Faker faker = new Faker();
 
List<String> isbns = faker.<String>collection().suppliers(() -> faker.code().isbn10(true), () -> faker.code().isbn13(true)).len(10).generate();                                      

System.out.println("Printing ISBNs with 10 or 13 characters:");
isbns.forEach(System.out::println);
