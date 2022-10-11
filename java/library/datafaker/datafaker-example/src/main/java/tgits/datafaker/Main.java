package tgits.datafaker;

import net.datafaker.Faker;
import tgits.datafaker.example.collection.CollectionExample;
import tgits.datafaker.example.provider.AddressProviderExample;
import tgits.datafaker.example.provider.BusinessAndFinanceProviderExample;
import tgits.datafaker.example.provider.ChuckNorrisProviderExample;
import tgits.datafaker.example.provider.CodeProviderExample;
import tgits.datafaker.example.provider.NameProviderExample;
import tgits.datafaker.example.provider.PokemonProviderExample;

import java.io.PrintStream;
import java.util.Locale;
import java.util.stream.IntStream;

public class Main {

    public static void main(String... args) {
        final Faker defaultFaker = new Faker();
        final Faker frenchLocalizedFaker = new Faker(Locale.FRANCE);
        final PrintStream defaultPrintStream = System.out;

        defaultPrintStream.println("### Datafaker Examples ###");
        defaultPrintStream.println();
        defaultPrintStream.println("#### Name Provider ####");
        defaultPrintStream.println();
        final NameProviderExample defaultNameProviderExample = new NameProviderExample(defaultFaker, defaultPrintStream);
        defaultNameProviderExample.print();

        defaultPrintStream.println();
        defaultPrintStream.println("#### Address Provider ####");
        defaultPrintStream.println();
        final AddressProviderExample defaultAddressProviderExample = new AddressProviderExample(defaultFaker, defaultPrintStream);
        defaultAddressProviderExample.print();

        defaultPrintStream.println();
        defaultPrintStream.println("#### French Localized Name Provider ####");
        defaultPrintStream.println();
        final NameProviderExample frenchNameProviderExample = new NameProviderExample(frenchLocalizedFaker, defaultPrintStream);
        frenchNameProviderExample.print();
        defaultPrintStream.println();

        defaultPrintStream.println();
        defaultPrintStream.println("#### Business and Finance Provider ####");
        defaultPrintStream.println();
        final BusinessAndFinanceProviderExample defaultBusinessAndFinanceProviderExample = new BusinessAndFinanceProviderExample(defaultFaker, defaultPrintStream);
        defaultBusinessAndFinanceProviderExample.print();

        defaultPrintStream.println();
        defaultPrintStream.println("#### Chuck Norris Facts Provider ####");
        defaultPrintStream.println();
        final ChuckNorrisProviderExample defaultChuckNorrisProviderExample = new ChuckNorrisProviderExample(defaultFaker, defaultPrintStream);
        IntStream.range(0, 10).forEach(i -> defaultChuckNorrisProviderExample.print());

        defaultPrintStream.println();
        defaultPrintStream.println("#### Code Provider ####");
        defaultPrintStream.println();
        final CodeProviderExample defaultCodeProviderExample = new CodeProviderExample(defaultFaker, defaultPrintStream);
        defaultCodeProviderExample.print();

        defaultPrintStream.println();
        defaultPrintStream.println("#### Pokemon Provider ####");
        defaultPrintStream.println();
        final PokemonProviderExample defaultPokemonProviderExample = new PokemonProviderExample(defaultFaker, defaultPrintStream);
        defaultPokemonProviderExample.print();

        defaultPrintStream.println();
        defaultPrintStream.println("#### Collection generation ####");
        defaultPrintStream.println();
        final CollectionExample collectionExample = new CollectionExample(defaultFaker, defaultPrintStream);
        collectionExample.printRandomCharactersFromTVShow();
        defaultPrintStream.println("------------------");
        collectionExample.printISBNs();
        defaultPrintStream.println();
        defaultPrintStream.println("####################");
    }
}