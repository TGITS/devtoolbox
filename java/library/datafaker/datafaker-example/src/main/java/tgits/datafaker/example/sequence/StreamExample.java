package tgits.datafaker.example.sequence;

import java.io.PrintStream;
import java.util.stream.Stream;
import net.datafaker.Faker;

public class StreamExample {

  private final Faker faker;
  private final PrintStream out;

  public StreamExample(final Faker faker, final PrintStream out) {
    this.faker = faker;
    this.out = out;
  }

  public StreamExample() {
    this(new Faker(), System.out);
  }

  public StreamExample(final Faker faker) {
    this(faker, System.out);
  }

  public void printRandomCharactersFromTVShow() {
    Stream<String> charactersFromTVShows =
        faker.<String>stream()
            .suppliers(() -> faker.gameOfThrones().character(), () -> faker.babylon5().character())
            .minLen(5) // Minimum length of the collection
            .maxLen(10) // Maximun length of the collection
            .build()
            .get();
    this.out.println("Random characters from TV Show");
    charactersFromTVShows.forEach(this.out::println);
  }

  public void printISBNs() {
    Stream<String> isbns =
        faker.<String>stream()
            .suppliers(() -> faker.code().isbn10(true), () -> faker.code().isbn13(true))
            .nullRate(0.4) // Null values occurrences frequency in the collection - about 40% of null values here
            .minLen(8)
            .maxLen(12)
            .build()
            .get();
    this.out.println("ISBN (possible null value)");
    isbns.forEach(this.out::println);
  }
}
