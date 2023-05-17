//DEPS net.datafaker:datafaker:1.9.0

/** 
 * Pour executer avec JBang : jbang SeveralSuppliersStreamExample.jsh
 * <p>
 * Pour exécuter sous JShell :
 * jshell --class-path .;.\lib\datafaker-1.9.0.jar
 * /open SeveralSuppliersStreamExample.jsh
 */

import net.datafaker.Faker;
import java.util.stream.Stream;

Faker faker = new Faker();

System.out.println("Printing some fake objects from several sources (minimum 5, maximum 10):");
Stream<Object> fakeStringsFromSeveralSources = faker.<Object>stream().suppliers(() -> faker.number().numberBetween(10, 30), () -> faker.bothify("0A???_###")).minLen(5).maxLen(10).generate();
fakeStringsFromSeveralSources.forEach(System.out::println);
