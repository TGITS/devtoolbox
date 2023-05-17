//DEPS net.datafaker:datafaker:1.9.0

/** 
 * Pour executer avec JBang : jbang NullRateExample.jsh
 * <p>
 * Pour exécuter sous JShell :
 * jshell --class-path .;.\lib\datafaker-1.9.0.jar
 * /open NullRateExample.jsh
 */

import net.datafaker.Faker;
import java.util.List;
import java.util.stream.Stream;

Faker faker = new Faker();
 
List<String> isbns = faker.<String>collection().suppliers(() -> faker.code().isbn10(true)).nullRate(0.4).len(10).generate();                                      

System.out.println("Printing some ISBNs - Possibly some null values :");
isbns.forEach(System.out::println);

// With a null rate of 1, only null values
Stream<String> nulls = faker.<String>stream().suppliers(() -> faker.code().isbn10(true)).nullRate(1.0).len(10).generate();
System.out.println("\nSome much null values !");
nulls.forEach(System.out::println);
