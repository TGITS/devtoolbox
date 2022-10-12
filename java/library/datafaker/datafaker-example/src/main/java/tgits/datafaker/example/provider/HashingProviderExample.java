package tgits.datafaker.example.provider;

import net.datafaker.Faker;
import net.datafaker.Hashing;

import java.io.PrintStream;

public class HashingProviderExample {

    private final Faker faker;
    private final PrintStream out;

    public HashingProviderExample() {
        this.faker = new Faker();
        this.out = System.out;
    }

    public HashingProviderExample(final Faker faker) {
        this.faker = faker;
        this.out = System.out;
    }

    public HashingProviderExample(final Faker faker, final PrintStream out) {
        this.faker = faker;
        this.out = out;
    }

    public void print() {
        final Hashing hashing = this.faker.hashing();
        out.println("md2 hash : " + hashing.md2());
        out.println("md5 hash : " + hashing.md5());
        out.println("sha1 hash : " + hashing.sha1());
        out.println("sha256 hash : " + hashing.sha256());
        out.println("sha384 hash : " + hashing.sha384());
        out.println("sha512 hash : " + hashing.sha512());
    }
}
