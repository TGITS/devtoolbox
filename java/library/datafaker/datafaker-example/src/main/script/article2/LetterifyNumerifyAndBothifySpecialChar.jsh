//DEPS net.datafaker:datafaker:1.9.0

/** 
 * Pour executer avec JBang : jbang LetterifyNumerifyAndBothifySpecialChar.jsh
 * Pour exécuter sous JShell :
 * jshell --class-path .;.\lib\datafaker-1.9.0.jar
 * /open LetterifyNumerifyAndBothifySpecialChar.jsh
 */
import net.datafaker.Faker;

// Instanciation d'un objet Faker pour pouvoir générer des valeurs aléatoires
Faker faker = new Faker();

//Le symbole "#" n'a pas de rôle spécial pour 'letterify'
System.out.println(faker.letterify("Within letterify the question mark ? is a special character but the hash # is not"));
//Le symbole "?" n'a pas de rôle spécial pour 'numerify'
System.out.println(faker.numerify("Within numerify the hash symbol # is a special character but the question mark ? is not"));
//Les symboles "?" et "#" ont par contre un rôle spécial pour bothify
System.out.println(faker.bothify("Within bothify both the hash symbol # and the question mark ? are special characters"));