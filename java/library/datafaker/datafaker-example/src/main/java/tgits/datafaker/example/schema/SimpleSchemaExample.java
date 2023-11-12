package tgits.datafaker.example.schema;

import net.datafaker.Faker;
import net.datafaker.transformations.*;

import java.io.PrintStream;

import static net.datafaker.transformations.Field.field;

public class SimpleSchemaExample {

    private final Faker faker;
    private final PrintStream out;

    private final Schema schema;

    public SimpleSchemaExample(final Faker faker, final PrintStream out) {
        this.faker = faker;
        this.out = out;
        this.schema = Schema.of(
                field("pokemon name", () -> faker.pokemon().name()),
                field("pokemon type", () -> faker.pokemon().type()),
                field("Location", () -> faker.pokemon().location())
        );
    }

    public SimpleSchemaExample() {
        this(new Faker(), System.out);
    }

    public SimpleSchemaExample(final Faker faker) {
        this(faker, System.out);
    }

    public void printCsvFromSchema() {
        CsvTransformer<String> transformer =
                CsvTransformer.<String>builder().header(true).separator(";").quote('"').build();

        String csv = transformer.generate(schema, 10);
        this.out.println(csv);
    }

    public void printJsonFromSchema() {
        JsonTransformer<Object> transformer = JsonTransformer.builder().build();
        String json = transformer.generate(schema, 5);
        this.out.println(json);
    }

    public void printYamlFromSchema() {
        YamlTransformer<Object> transformer = new YamlTransformer<>();
        String yaml = transformer.generate(schema, 5);
        this.out.println(yaml);
    }

    public void printXmlFromSchema() {
        XmlTransformer<Object> transformer = new XmlTransformer.XmlTransformerBuilder().pretty(true).build();
        CharSequence xml = transformer.generate(schema, 5);
        this.out.println(xml);
    }
}
