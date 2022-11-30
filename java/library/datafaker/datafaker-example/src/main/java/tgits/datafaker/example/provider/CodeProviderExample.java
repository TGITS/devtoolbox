package tgits.datafaker.example.provider;

import java.io.PrintStream;
import net.datafaker.Faker;
import net.datafaker.providers.base.Code;

public class CodeProviderExample {

  private final Faker faker;
  private final PrintStream out;

  public CodeProviderExample(final Faker faker, final PrintStream out) {
    this.faker = faker;
    this.out = out;
  }

  public CodeProviderExample() {
    this(new Faker(), System.out);
  }

  public CodeProviderExample(final Faker faker) {
    this(faker, System.out);
  }

  public void print() {
    final Code code = this.faker.code();
    this.out.println("ISBN10 : " + code.isbn10());
    this.out.println("ISBN10 with separator: " + code.isbn10(true));
    this.out.println("ISBN13 : " + code.isbn13());
    this.out.println("ISBN13 with separator: " + code.isbn13(true));
    // Pour ASIN voir https://en.wikipedia.org/wiki/Amazon_Standard_Identification_Number
    this.out.println("ASIN (Amazon Standard Identification Number) : " + code.asin());
    // Pour EAN voir https://fr.wikipedia.org/wiki/Code-barres_EAN
    this.out.println("EAN8 (European Article Numbering) : " + code.ean8());
    this.out.println("EAN13 : " + code.ean13());
    // Pour GTIN voir https://fr.wikipedia.org/wiki/Global_Trade_Item_Number
    this.out.println("GTIN8 (Global Trade Item Number) : " + code.gtin8());
    this.out.println("GTIN13 : " + code.gtin13());
    // Pour IMEI voir https://fr.wikipedia.org/wiki/International_Mobile_Equipment_Identity
    this.out.println("IMEI (International Mobile Equipment Identity) : " + code.imei());
  }
}
