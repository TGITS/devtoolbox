package tgits.datafaker.example.provider.options;

import java.io.PrintStream;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import net.datafaker.Faker;
import net.datafaker.providers.base.Options;

public class OptionsProviderExample {

  private final Faker faker;
  private final PrintStream out;

  public OptionsProviderExample(final Faker faker, final PrintStream out) {
    this.faker = faker;
    this.out = out;
  }

  public OptionsProviderExample() {
    this(new Faker(), System.out);
  }

  public OptionsProviderExample(final Faker faker) {
    this(faker, System.out);
  }

  public void print() {
    final Options options = faker.options();
    out.println("Choosing randomly between several options specified as a String");
    IntStream.range(0, 10)
        .forEach(
            i ->
                out.println(
                    "My Favorite day is (iteration #"
                        + i
                        + ") : "
                        + options.option(
                            "Monday",
                            "Tuesday",
                            "Wednesday",
                            "Thursday",
                            "Friday",
                            "Saturday",
                            "Sunday")));
    out.println();
    out.println("Choosing randomly between several options specified by an Enumeration");
    IntStream.range(0, 10)
        .forEach(
            i ->
                out.println(
                    "My Favorite day is (iteration #"
                        + i
                        + ") : "
                        + options.option(DaysOfWeek.class)));
    out.println();
    out.println("Choosing randomly an option from a List or an Array");
    final List<String> daysOfWeekAsList =
        List.of("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday");
    IntStream.range(0, 10)
        .forEach(
            i ->
                out.println(
                    "My Favorite day is (iteration #"
                        + i
                        + ") : "
                        + options.nextElement(daysOfWeekAsList)));
    out.println();
    final DaysOfWeek[] daysOfWeekAsArray = DaysOfWeek.values();
    IntStream.range(0, 10)
        .forEach(
            i ->
                out.println(
                    "My Favorite day is (iteration #"
                        + i
                        + ") : "
                        + options.nextElement(daysOfWeekAsArray)));
    out.println();
    final Set<DaysOfWeek> fourDaysOfWeek = options.subset(4, daysOfWeekAsArray);
    out.println(
        "A set of four random days among seven : "
            + fourDaysOfWeek.stream().map(DaysOfWeek::toString).collect(Collectors.joining(", ")));
  }
}
