package tgits.datafaker;

import net.datafaker.Faker;
import tgits.datafaker.example.collection.CollectionExample;
import tgits.datafaker.example.provider.AddressProviderExample;
import tgits.datafaker.example.provider.NameProviderExample;

import java.util.Locale;

public class Main {

    public static void main(String... args) {
        Faker defaultFaker = new Faker();
        Faker frenchLocalizedFaker = new Faker(Locale.FRANCE);
        Faker japaneseLocalizedFaker = new Faker(Locale.JAPANESE);

        System.out.println("### Datafaker Examples ###");
        System.out.println();
        System.out.println("#### Name Provider ####");
        System.out.println();
        NameProviderExample.print(defaultFaker);
        System.out.println();
        System.out.println("#### Address Provider ####");
        System.out.println();
        AddressProviderExample.print(defaultFaker);
        System.out.println();
        System.out.println("#### French Localized Name Provider ####");
        System.out.println();
        NameProviderExample.print(frenchLocalizedFaker);
        System.out.println();
        System.out.println("#### Japanese Localized Name Provider ####");
        System.out.println();
        NameProviderExample.print(japaneseLocalizedFaker);
        System.out.println();
        System.out.println("#### Examples with Collections ####");
        System.out.println();
        CollectionExample.printRandomCharactersFromTVShow(defaultFaker);
        System.out.println();
        CollectionExample.printISBNs(defaultFaker);
        System.out.println();
        System.out.println("####################");
    }
}