package tgits.datafaker.example.provider;

import net.datafaker.Faker;
import net.datafaker.File;

import java.io.PrintStream;

public class FileProviderExample {

    private final Faker faker;
    private final PrintStream out;

    public FileProviderExample() {
        this.faker = new Faker();
        this.out = System.out;
    }

    public FileProviderExample(final Faker faker) {
        this.faker = faker;
        this.out = System.out;
    }

    public FileProviderExample(final Faker faker, final PrintStream out) {
        this.faker = faker;
        this.out = out;
    }

    public void print() {
        final File file = this.faker.file();
    }
}
