package tgits.datafaker.example.model;

import net.datafaker.Faker;

import java.io.PrintStream;
import java.util.stream.IntStream;

public class TemplateModelBasedGenerationExample {

    private final Faker faker;
    private final PrintStream out;

    public TemplateModelBasedGenerationExample(final Faker faker, final PrintStream out) {
        this.faker = faker;
        this.out = out;
    }

    public TemplateModelBasedGenerationExample() {
        this(new Faker(), System.out);
    }

    public TemplateModelBasedGenerationExample(final Faker faker) {
        this(faker, System.out);
    }

    public void print() {
        //A specific character (here the x) is replaced by one of several proposed Strings
        out.println("Print days of week ; the 'x' in 'xday' is replaced with 'Mon', 'Tues', etc.");
        IntStream.range(0, 10).forEach(i -> out.println(faker.templatify("xday", 'x', "Mon", "Tues", "Wednes", "Thurs", "Fri", "Satur", "Sun")));
        out.println();
        //Each occurrence of the character is replaced by a random values between the possible ones
        IntStream.range(0, 10).forEach(i -> out.println(faker.templatify("x versus x", 'x', "Jon", "Aemon", "Eddard", "Samwell", "Rhaegar", "Arya", "Brienne")));
    }
}
