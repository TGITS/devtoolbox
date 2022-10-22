package tgits.datafaker.example.collection;

import net.datafaker.Faker;

import java.io.PrintStream;
import java.util.List;

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
        List<String> charactersFromTVShows = faker.<String>collection()
                .suppliers(
                        () -> faker.gameOfThrones().character(),
                        () -> faker.babylon5().character()
                )
                .minLen(5)
                .maxLen(10)
                .build()
                .get();
        this.out.println(charactersFromTVShows.size() + " random characters from TV Show");
        charactersFromTVShows.forEach(this.out::println);
    }

    public void printISBNs() {
        List<String> isbns = faker.<String>collection()
                .suppliers(
                        () -> faker.code().isbn10(true),
                        () -> faker.code().isbn13(true)
                )
                .nullRate(0.4)
                .minLen(8)
                .maxLen(12)
                .build()
                .get();
        this.out.println(isbns.size() + " ISBN (possible null value)");
        isbns.forEach(this.out::println);
    }
}
