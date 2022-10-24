package tgits.datafaker.example.model;

import net.datafaker.Faker;

import java.io.PrintStream;
import java.util.stream.IntStream;

public class BasicModelBasedGenerationExample {

    private final Faker faker;
    private final PrintStream out;

    public BasicModelBasedGenerationExample(final Faker faker, final PrintStream out) {
        this.faker = faker;
        this.out = out;
    }

    public BasicModelBasedGenerationExample() {
        this(new Faker(), System.out);
    }

    public BasicModelBasedGenerationExample(final Faker faker) {
        this(faker, System.out);
    }

    public void print() {
        //The model "_???" will tell Datafaker to print an underscore and three random lowercase letters : the '?' is replaced by a random letter
        out.println("Print the digits from 0 to 9, followed by an underscore and three random lowercase letters :");
        IntStream.range(0, 10).forEach(i -> out.println(faker.letterify(i + "_???")));

        out.println();
        out.println("---------");
        out.println();

        //The model "_???" will tell Datafaker to print an underscore and three random uppercase letters : the '?' is replaced by a random letter
        //The second boolean parameter tells the method to make the letter uppercase
        out.println("Print the digits from 0 to 9, followed by an underscore and three random uppercase letters :");
        IntStream.range(0, 10).forEach(i -> out.println(faker.letterify(i + "_???", true)));

        out.println();
        out.println("---------");
        out.println();

        //The model "_###" will tell Datafaker to print an underscore and three random digits : the '#' is replaced by a random digit
        out.println("Print the digits from 0 to 9, followed by an underscore and three random digits :");
        IntStream.range(0, 10).forEach(i -> out.println(faker.numerify(i + "_###")));

        out.println();
        out.println("---------");
        out.println();

        out.println(faker.letterify("Within letterify the question mark ? is a special character but the hash # is not"));
        out.println(faker.numerify("Within numerify the hash symbol # is a special character but the question mark ? is not"));

        out.println();
        out.println("---------");
        out.println();

        //We can mix letter and digit generation with the method 'bothify'
        out.println("Print the digits from 0 to 9, followed by an underscore, three random lowercase letters, another underscore and three random digits :");
        IntStream.range(0, 10).forEach(i -> out.println(faker.bothify(i + "_???_###")));
        out.println();
        out.println("Print the digits from 0 to 9, followed by an underscore, three random uppercase letters, another underscore and three random digits :");
        IntStream.range(0, 10).forEach(i -> out.println(faker.bothify(i + "_???_###", true)));

        out.println();
        out.println("---------");
        out.println();

        //And if we want to mix digit and letters both lower and upper case ?
        //We give an example of the String we want to generate
        //The uppercase letters will be replaced by a random uppercase letters
        //The lowercase letters will be replaced by a random lowercase letters
        //the digit will be replaced by a random digit
        //the non-alphanumeric characters are not replaced
        out.println("Print the digits from 0 to 9, followed by an underscore, three random lowercase letters, an underscore, three random uppercase letters, an underscore and three random digits");
        IntStream.range(0, 10).forEach(i -> out.println(faker.examplify(i + "_ABC_abc_123")));
        out.println();
        out.println("The non-alphanumeric symbol are not replaced in examplify ; an example with the model '0aA_?#!:;,*$'");
        out.println(faker.examplify("0aA_?#!:;,*$"));
    }
}
