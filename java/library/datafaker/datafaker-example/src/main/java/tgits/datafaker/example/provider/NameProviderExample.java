package tgits.datafaker.example.provider;

import net.datafaker.Faker;
import net.datafaker.Name;

public class NameProviderExample {

    public static void print(Faker faker) {
        Name name = faker.name();
        System.out.println("Name : " + name.name());
        System.out.println("Full name : " + name.fullName());
        System.out.println("First name : " + name.firstName());
        System.out.println("Last name : " + name.lastName());
        System.out.println("Name with middle name : " + name.nameWithMiddle());
        System.out.println("Name Prefix : " + name.prefix());
        System.out.println("Name Suffix : " + name.suffix());
        System.out.println("Title : " + name.title());
    }
}
