package tgits.datafaker.example.sequence;

import java.io.PrintStream;
import java.util.List;
import net.datafaker.Faker;

public class CollectionExample {

  private final Faker faker;
  private final PrintStream out;

  public CollectionExample(final Faker faker, final PrintStream out) {
    this.faker = faker;
    this.out = out;
  }

  public CollectionExample() {
    this(new Faker(), System.out);
  }

  public CollectionExample(final Faker faker) {
    this(faker, System.out);
  }

  public void printRandomCharactersFromTVShow() {
    List<String> charactersFromTVShows =
        faker
            .<String>collection()
            .suppliers(() -> faker.gameOfThrones().character(), () -> faker.babylon5().character())
            .minLen(5) // Minimum length of the collection
            .maxLen(10) // Maximum length of the collection
            .generate();
    this.out.println(charactersFromTVShows.size() + " random characters from TV Show");
    charactersFromTVShows.forEach(this.out::println);
  }

  public void printISBNs() {
    List<String> isbns =
        faker
            .<String>collection()
            .suppliers(() -> faker.code().isbn10(true), () -> faker.code().isbn13(true))
            .nullRate(0.4) // Null values occurrences frequency in the collection
            .minLen(8)
            .maxLen(12)
            .generate();
    this.out.println(isbns.size() + " ISBN (possible null value)");
    isbns.forEach(this.out::println);
  }
}
