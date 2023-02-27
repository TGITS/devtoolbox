//DEPS net.datafaker:datafaker:1.8.0

/** 
 * Pour executer avec JBang :
 * <p>
 * jbang LetterifyNumerifyAndBothifySpecialChar.jsh
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
 * /open LetterifyNumerifyAndBothifySpecialChar.jsh
 */
import net.datafaker.Faker;

// Instanciation d'un objet Faker pour pouvoir générer des valeurs aléatoires
Faker faker = new Faker();

//Le symbole "#" n'a pas de rôle spécial pour 'letterify'
System.out.println(faker.letterify("Within letterify the question mark ? is a special character but the hash # is not"));
//Le symbole "?" n'a pas de rôle spécial pour 'numerify'
System.out.println(faker.numerify("Within numerify the hash symbol # is a special character but the question mark ? is not"));
//Les symbole "?" et "#" ont par contre un rôle spécial pour bothify
System.out.println(faker.bothify("Within bothify both the hash symbol # and the question mark ? are special characters"));