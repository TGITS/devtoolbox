package tgits.datafaker.example.provider;

import net.datafaker.Code;
import net.datafaker.Faker;

import java.io.PrintStream;

public class CodeProviderExample {

    private final Faker faker;
    private final PrintStream out;

    public CodeProviderExample() {
        this.faker = new Faker();
        this.out = System.out;
    }

    public CodeProviderExample(final Faker faker) {
        this.faker = faker;
        this.out = System.out;
    }

    public CodeProviderExample(final Faker faker, final PrintStream out) {
        this.faker = faker;
        this.out = out;
    }

    public void print() {
        final Code code = this.faker.code();
        this.out.println("ISBN10 : " + code.isbn10());
        this.out.println("ISBN10 with separator: " + code.isbn10(true));
        this.out.println("ISBN13 : " + code.isbn13());
        this.out.println("ISBN13 with separator: " + code.isbn13(true));
        //Pour ASIN voir https://en.wikipedia.org/wiki/Amazon_Standard_Identification_Number
        this.out.println("ASIN (Amazon Standard Identification Number) : " + code.asin());

    }
}
