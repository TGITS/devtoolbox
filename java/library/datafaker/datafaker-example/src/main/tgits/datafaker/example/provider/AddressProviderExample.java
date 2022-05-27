package tgits.datafaker.example.provider;

import net.datafaker.Address;
import net.datafaker.Faker;

public class AddressProviderExample {

    public static void print(Faker faker) {
        Address address = faker.address();
        System.out.println("Full address : " + address.fullAddress());
        System.out.println("Country : " + address.country());
        System.out.println("City : " + address.city());
        System.out.println("City name : " + address.cityName());
        System.out.println("ZIP Code : " + address.zipCode());
    }
}
