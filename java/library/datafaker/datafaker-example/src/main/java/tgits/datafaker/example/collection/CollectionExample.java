package tgits.datafaker.example.collection;

import net.datafaker.Faker;

import java.util.List;

public class CollectionExample {

    public static void printRandomCharactersFromTVShow(Faker faker) {
        List<String> charactersFromTVShows = faker.<String>collection()
                .suppliers(
                        () -> faker.gameOfThrones().character(),
                        () -> faker.babylon5().character()
                )
                .minLen(5)
                .maxLen(10)
                .build()
                .get();
        System.out.println(charactersFromTVShows.size() + " random characters from TV Show");
        charactersFromTVShows.forEach(System.out::println);
    }

    public static void printISBNs(Faker faker) {
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
        System.out.println(isbns.size() + " ISBN (possible null value)");
        isbns.forEach(System.out::println);
    }
}
