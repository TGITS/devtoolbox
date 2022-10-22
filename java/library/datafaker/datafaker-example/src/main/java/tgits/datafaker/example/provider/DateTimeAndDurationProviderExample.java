package tgits.datafaker.example.provider;

import net.datafaker.providers.base.DateAndTime;
import net.datafaker.Faker;

import java.io.PrintStream;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.TimeUnit;

public class DateTimeAndDurationProviderExample {

    private final Faker faker;
    private final PrintStream out;

    public DateTimeAndDurationProviderExample(final Faker faker, final PrintStream out) {
        this.faker = faker;
        this.out = out;
    }

    public DateTimeAndDurationProviderExample() {
        this(new Faker(),System.out);
    }

    public DateTimeAndDurationProviderExample(final Faker faker) {
        this(faker, System.out);
    }

    public void print() {
        final DateAndTime dateAndTime = this.faker.date();
        this.out.println("Birthday : " + dateAndTime.birthday());
        this.out.println("Birthday : " + dateAndTime.birthday(10, 25));
        //SimpleDateFormat pattern
        this.out.println("Birthday : " + dateAndTime.birthday("dd/MM/yyyy"));
        this.out.println("Birthday : " + dateAndTime.birthday(10, 25, "dd/MM/yyyy"));
        this.out.println("Birthday : " + dateAndTime.birthday(10, 25, "yyyy-MM-dd'T'HH:mm:ss.SSSXXX"));

        this.out.println("Duration : " + dateAndTime.duration(10, 60, ChronoUnit.SECONDS));
        this.out.println("Duration : " + dateAndTime.duration(10, 60, "SECONDS"));
        this.out.println("Duration : " + dateAndTime.duration(24, ChronoUnit.HOURS));

        this.out.println("Date between 2 timestamps : " + dateAndTime.between(Timestamp.from(Instant.EPOCH), Timestamp.from(Instant.now())));
        this.out.println("Date between 2 timestamps : " + dateAndTime.between(Timestamp.from(Instant.EPOCH), Timestamp.from(Instant.now()), "dd/MM/yyyy"));

        this.out.println("A date between 10 and 50 days in the future : " + dateAndTime.future(50, 10, TimeUnit.DAYS, "dd/MM/yyyy"));
        this.out.println("A date between 10 and 50 days in the past : " + dateAndTime.past(50, 10, TimeUnit.DAYS, "dd/MM/yyyy"));

        this.out.println("A period between an lower and an upper period : " + dateAndTime.period(Period.ofYears(5), Period.ofYears(10)));
    }
}
