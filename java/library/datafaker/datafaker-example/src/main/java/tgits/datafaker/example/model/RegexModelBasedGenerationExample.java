package tgits.datafaker.example.model;

import net.datafaker.Faker;

import java.io.PrintStream;
import java.util.stream.IntStream;

public class RegexModelBasedGenerationExample {

    private final Faker faker;
    private final PrintStream out;

    public RegexModelBasedGenerationExample(final Faker faker, final PrintStream out) {
        this.faker = faker;
        this.out = out;
    }

    public RegexModelBasedGenerationExample() {
        this(new Faker(), System.out);
    }

    public RegexModelBasedGenerationExample(final Faker faker) {
        this(faker, System.out);
    }

    public void print() {
        out.println("Print between 3 and 5 letters (upper or lowercase), followed by a symbol between '$','#','_' and '-', and then three digits :");
        IntStream.range(0, 10).forEach(i -> out.println(faker.regexify("[a-zA-Z]{3,5}[$#_\\-]\\d{3}")));
        //'(M|F)'
        out.println("Gender abbreviations Male/Female/Non-Binary :");
        IntStream.range(0, 10).forEach(i -> out.println(faker.regexify("(M|F|NB)")));
    }
}
