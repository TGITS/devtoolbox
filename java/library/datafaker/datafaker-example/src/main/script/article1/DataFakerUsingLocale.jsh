//DEPS net.datafaker:datafaker:1.9.0

/** 
 * Afin de pouvoir voir correctement les caractères accentués sous une invite de commande Windows,
 * avant de lancer JShell ou JBang, il faut au préalable :
 * <ul>
 *   <li>Définir la variable d'environnement JAVA_TOOL_OPTIONS à la valeur -Dfile.encoding
 *   par exemple en saisissant dans l'invite de commande : SET JAVA_TOOL_OPTIONS=-Dfile.encoding=UTF8</li>
 *   <li>Il faut également définir l'encodage UTF-8 pour l'invite de commande en saisissant
 *   la commande suivante : chcp 65001</li>
 * </ul>
 * <p>
 * Pour exécuter avec JBang : jbang DataFakerUsingLocale.jsh
 * <p>
 * La ligne //DEPS net.datafaker:datafaker:1.9.0 au début du script est pour le lancement avec JBang.
 * Elle est ignorée si on lance directement avec JShell
 * <p>
 *
 * Ensuite, pour exécuter sous JShell :
 * <p>
 * Il faut avoir lancé JShell en précisant un classpath contenant la bibliothèque DataFaker.
 * par exemple : jshell --class-path .;.\lib\datafaker-1.9.0.jar
 * Ensuite, une fois sous jshell ouvrez et exécuter le script avec :
 * /open DataFakerUsingLocale.jsh
 * 
 */
import net.datafaker.Faker;
import net.datafaker.providers.base.Name;
import net.datafaker.providers.base.Address;
import java.util.Locale;

// Faker est l'objet à instancier pour pouvoir générer des valeurs aléatoires
// Il est créer avec une locale par défaut
Faker defaultFaker = new Faker();
//On peut préciser une locale spécifique au moment de la création
Faker frenchLocalizedFaker = new Faker(Locale.FRANCE);

// Utilisation d'un des fournisseurs de données (data providers) de Datafaker
// Ici ce forunisseur permet d'avoir des valeurs aléatoires pour l'état civil d'une personne
Name name = defaultFaker.name();
System.out.println("Name related random values (default locale)");
System.out.println("Name : " + name.name());
System.out.println("Full name : " + name.fullName());
System.out.println("First name : " + name.firstName());
System.out.println("Last name : " + name.lastName());
System.out.println("Name with middle name : " + name.nameWithMiddle());
System.out.println("Name Prefix : " + name.prefix());
System.out.println("Name Suffix : " + name.suffix());
System.out.println("Title : " + name.title());
System.out.println("");
Address address = defaultFaker.address();
System.out.println("Address related random values (default locale)");
System.out.println("Full address : " + address.fullAddress());
System.out.println("Country : " + address.country());
System.out.println("City : " + address.city());
System.out.println("ZIP Code : " + address.zipCode());

System.out.println("\n-------------\n")

name =  frenchLocalizedFaker.name();
System.out.println("Valeurs aléatoires pour des noms (utilisation de la locale 'FRANCE')");
System.out.println("Nom : " + name.name());
System.out.println("Nom complet : " + name.fullName());
System.out.println("Prénom : " + name.firstName());
System.out.println("Nom de famille : " + name.lastName());
System.out.println("Nom complet avec le deuxième prénom : " + name.nameWithMiddle());
System.out.println("Préfixe au nom : " + name.prefix());
System.out.println("Suffixe au nom : " + name.suffix());
System.out.println("Titre : " + name.title());
System.out.println("");
address = frenchLocalizedFaker.address();
System.out.println("Valeurs aléatoires pour des adresses (utilisation de la locale 'FRANCE')");
System.out.println("Adresse complète : " + address.fullAddress());
System.out.println("Pays : " + address.country());
System.out.println("Ville : " + address.city());
System.out.println("ZIP : " + address.zipCode());