//DEPS net.datafaker:datafaker:1.8.1

/** 
 * Pour executer avec JBang :
 * <p>
 * jbang DataFakerBasicUsage.jsh
 * <p>
 * La ligne //DEPS net.datafaker:datafaker:1.8.1 au début du script est pour le lancement avec JBang.
 * Elle est ignorée si on lance directement avec JShell
 * <p>
 * Pour exécuter avec JShell :
 * <p>
 * Il faut avoir lancé JShell en précisant un classpath contenant la bibliothèque DataFaker.
 * <p>
 * Si vous avez récupéré datafaker-1.8.1.jar (sur https://mvnrepository.com/artifact/net.datafaker/datafaker/1.8.1 par exemple).
 * et que vous l'avez placé dans le sous-répertoire <code>lib</code> par rapport au répertoire courant dans lequel se trouvent les scripts 
 * et dans lequel vous allez exécuter JShell, il faut lancer JShell de la manière suivante : 
 * jshell --class-path .;.\lib\datafaker-1.8.1.jar
 * <p>
 * Ensuite, une fois sous jshell ouvrez et exécuter le script avec :
 * /open DataFakerBasicUsage.jsh
 */

/**
 * 
 */
import net.datafaker.Faker;
import net.datafaker.providers.base.Name;
import net.datafaker.providers.base.Address;

// Faker est l'objet à instancier pour pouvoir générer des valeurs aléatoires
Faker faker = new Faker();

// Utilisation d'un des fournisseurs de données (data providers) de Datafaker
// Ici ce fournisseur permet d'avoir des valeurs aléatoires pour l'état civil d'une personne
Name name = faker.name();
System.out.println("Name related random values");
System.out.println("Name : " + name.name());
System.out.println("Full name : " + name.fullName());
System.out.println("First name : " + name.firstName());
System.out.println("Last name : " + name.lastName());
System.out.println("Name with middle name : " + name.nameWithMiddle());
System.out.println("Name Prefix : " + name.prefix());
System.out.println("Name Suffix : " + name.suffix());
System.out.println("Title : " + name.title());

System.out.println("\n-------------\n")

// L'instance de Faker est bien sûr réutilisable
// Ici avec un fournisseur de données pour les adresses
Address address = faker.address();
System.out.println("Address related random values");
System.out.println("Full address : " + address.fullAddress());
System.out.println("Country : " + address.country());
System.out.println("City : " + address.city());
System.out.println("City name : " + address.cityName());
System.out.println("ZIP Code : " + address.zipCode());