// A exécuter avec JBang : jbang RandomGenerationExampleScript.jsh
//Penser à configurer la console en UTF-8 avec chcp 65001 avant de lancer jshell

import java.util.random.RandomGenerator;
import java.util.random.RandomGeneratorFactory;

//Utilisation du générateur par défaut
var randomGeneratorDefault = RandomGenerator.getDefault();

System.out.println("Génération d'une valeur aléatoire booléenne : " + randomGeneratorDefault.nextBoolean());
System.out.println("Génération d'une valeur aléatoire entière de type 'int' : " + randomGeneratorDefault.nextInt());
System.out.println("Génération d'une valeur aléatoire entière de type 'long' : " + randomGeneratorDefault.nextLong());
System.out.println("Génération d'une valeur aléatoire réelle de type 'double' : " + randomGeneratorDefault.nextDouble());
System.out.println("Génération d'une flux de 5 valeurs entières : ");
randomGeneratorDefault.ints(5).forEach(System.out::println);
System.out.println("Génération d'une flux de 5 valeurs réelles : ");
randomGeneratorDefault.doubles(5).forEach(System.out::println);
