package tgits.datafaker.example.provider;

import net.datafaker.Faker;
import net.datafaker.providers.base.File;

import java.io.PrintStream;

public class FileProviderExample {

    private final Faker faker;
    private final PrintStream out;

    public FileProviderExample(final Faker faker, final PrintStream out) {
        this.faker = faker;
        this.out = out;
    }

    public FileProviderExample() {
        this(new Faker(), System.out);
    }

    public FileProviderExample(final Faker faker) {
        this(faker, System.out);
    }

    public void print() {
        final File file = this.faker.file();
        this.out.println("File name : " + file.fileName());
        this.out.println("File name : " + file.fileName("directory", "name", "extension", "/"));
        this.out.println("File name : " + file.fileName(null, "name", "extension", "\\"));
        this.out.println("File name : " + file.fileName("directory", null, "extension", "/"));
        this.out.println("File name : " + file.fileName("directory", "name", null, "/"));
        this.out.println("File name : " + file.fileName("directory", "name", "txt", null));
        this.out.println("File extension : " + file.extension());
        this.out.println("MimeType : " + file.mimeType());
    }
}
