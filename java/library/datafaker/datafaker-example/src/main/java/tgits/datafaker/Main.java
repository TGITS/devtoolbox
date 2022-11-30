package tgits.datafaker;

import static java.nio.charset.StandardCharsets.UTF_8;

import java.io.PrintStream;
import java.util.Locale;
import java.util.stream.IntStream;
import net.datafaker.Faker;
import tgits.datafaker.example.collection.CollectionExample;
import tgits.datafaker.example.model.BasicModelBasedGenerationExample;
import tgits.datafaker.example.model.RegexModelBasedGenerationExample;
import tgits.datafaker.example.model.TemplateModelBasedGenerationExample;
import tgits.datafaker.example.provider.*;
import tgits.datafaker.example.provider.options.OptionsProviderExample;

public class Main {

  public static void main(String... args) {
    final Faker defaultFaker = new Faker();
    final Faker frenchLocalizedFaker = new Faker(Locale.FRANCE);
    final PrintStream defaultPrintStream = new PrintStream(System.out, true, UTF_8);

    defaultPrintStream.println("### Datafaker Examples ###");
    defaultPrintStream.println();
    defaultPrintStream.println("#### Name Provider ####");
    defaultPrintStream.println();
    final NameProviderExample defaultNameProviderExample =
        new NameProviderExample(defaultFaker, defaultPrintStream);
    defaultNameProviderExample.print();

    defaultPrintStream.println();
    defaultPrintStream.println("#### Address Provider ####");
    defaultPrintStream.println();
    final AddressProviderExample defaultAddressProviderExample =
        new AddressProviderExample(defaultFaker, defaultPrintStream);
    defaultAddressProviderExample.print();

    defaultPrintStream.println();
    defaultPrintStream.println("#### French Localized Name Provider ####");
    defaultPrintStream.println();
    final NameProviderExample frenchNameProviderExample =
        new NameProviderExample(frenchLocalizedFaker, defaultPrintStream);
    frenchNameProviderExample.print();
    defaultPrintStream.println();

    defaultPrintStream.println();
    defaultPrintStream.println("#### Business and Finance Provider ####");
    defaultPrintStream.println();
    final BusinessAndFinanceProviderExample defaultBusinessAndFinanceProviderExample =
        new BusinessAndFinanceProviderExample(defaultFaker, defaultPrintStream);
    defaultBusinessAndFinanceProviderExample.print();

    defaultPrintStream.println();
    defaultPrintStream.println("#### Chuck Norris Facts Provider ####");
    defaultPrintStream.println();
    final ChuckNorrisProviderExample defaultChuckNorrisProviderExample =
        new ChuckNorrisProviderExample(defaultFaker, defaultPrintStream);
    IntStream.range(0, 10).forEach(i -> defaultChuckNorrisProviderExample.print());

    defaultPrintStream.println();
    defaultPrintStream.println("#### Code Provider ####");
    defaultPrintStream.println();
    final CodeProviderExample defaultCodeProviderExample =
        new CodeProviderExample(defaultFaker, defaultPrintStream);
    defaultCodeProviderExample.print();

    defaultPrintStream.println();
    defaultPrintStream.println("#### Date & Time Provider ####");
    defaultPrintStream.println();
    final DateTimeAndDurationProviderExample defaultDateAndTimeProviderExample =
        new DateTimeAndDurationProviderExample(defaultFaker, defaultPrintStream);
    defaultDateAndTimeProviderExample.print();

    defaultPrintStream.println();
    defaultPrintStream.println("#### File Provider ####");
    defaultPrintStream.println();
    final FileProviderExample defaultFileProviderExample =
        new FileProviderExample(defaultFaker, defaultPrintStream);
    defaultFileProviderExample.print();

    defaultPrintStream.println();
    defaultPrintStream.println("#### a Game of Thrones Provider ####");
    defaultPrintStream.println();
    final GameOfThroneProviderExample defaultGotProviderExample =
        new GameOfThroneProviderExample(defaultFaker, defaultPrintStream);
    defaultGotProviderExample.print();

    defaultPrintStream.println();
    defaultPrintStream.println("#### a Hash Provider ####");
    defaultPrintStream.println();
    final HashingProviderExample defaultHashingProviderExample =
        new HashingProviderExample(defaultFaker, defaultPrintStream);
    defaultHashingProviderExample.print();

    defaultPrintStream.println();
    defaultPrintStream.println("#### Pokemon Provider ####");
    defaultPrintStream.println();
    final PokemonProviderExample defaultPokemonProviderExample =
        new PokemonProviderExample(defaultFaker, defaultPrintStream);
    defaultPokemonProviderExample.print();

    defaultPrintStream.println();
    defaultPrintStream.println("#### French Localized Pokemon Provider ####");
    defaultPrintStream.println();
    final PokemonProviderExample frenchPokemonProviderExample =
        new PokemonProviderExample(frenchLocalizedFaker, defaultPrintStream);
    frenchPokemonProviderExample.print();
    defaultPrintStream.println();

    defaultPrintStream.println();
    defaultPrintStream.println("#### Phone Numbers and Internet Related Data Provider ####");
    defaultPrintStream.println();
    final PhoneNumberAndEmailProviderExample phoneNumberAndEmailProviderExample =
        new PhoneNumberAndEmailProviderExample(defaultFaker, defaultPrintStream);
    phoneNumberAndEmailProviderExample.print();
    defaultPrintStream.println();

    defaultPrintStream.println();
    defaultPrintStream.println("#### Numbers Provider ####");
    defaultPrintStream.println();
    final NumberProviderExample numberProviderExample =
        new NumberProviderExample(defaultFaker, defaultPrintStream);
    numberProviderExample.print();
    defaultPrintStream.println();
    defaultPrintStream.println("####################");

    defaultPrintStream.println();
    defaultPrintStream.println("#### Generation of Data based on some options ####");
    defaultPrintStream.println();
    final OptionsProviderExample optionsProviderExample =
        new OptionsProviderExample(defaultFaker, defaultPrintStream);
    optionsProviderExample.print();
    defaultPrintStream.println();
    defaultPrintStream.println("####################");

    defaultPrintStream.println();
    defaultPrintStream.println("#### Generation of a String based on a model ####");
    defaultPrintStream.println();
    final BasicModelBasedGenerationExample basicModelBasedGenerationExample =
        new BasicModelBasedGenerationExample(defaultFaker, defaultPrintStream);
    basicModelBasedGenerationExample.print();
    defaultPrintStream.println();
    defaultPrintStream.println("####################");

    defaultPrintStream.println();
    defaultPrintStream.println("#### Generation of a String based on a regular expression ####");
    defaultPrintStream.println();
    final RegexModelBasedGenerationExample regexModelBasedGenerationExample =
        new RegexModelBasedGenerationExample(defaultFaker, defaultPrintStream);
    regexModelBasedGenerationExample.print();
    defaultPrintStream.println();
    defaultPrintStream.println("####################");

    // TemplateModelBasedGenerationExample
    defaultPrintStream.println();
    defaultPrintStream.println("#### Generation of a String based on a template ####");
    defaultPrintStream.println();
    final TemplateModelBasedGenerationExample templateModelBasedGenerationExample =
        new TemplateModelBasedGenerationExample(defaultFaker, defaultPrintStream);
    templateModelBasedGenerationExample.print();
    defaultPrintStream.println();
    defaultPrintStream.println("####################");

    defaultPrintStream.println();
    defaultPrintStream.println("#### Collection generation ####");
    defaultPrintStream.println();
    final CollectionExample collectionExample =
        new CollectionExample(defaultFaker, defaultPrintStream);
    collectionExample.printRandomCharactersFromTVShow();
    defaultPrintStream.println("------------------");
    collectionExample.printISBNs();
    defaultPrintStream.println();
    defaultPrintStream.println("####################");
  }
}
