package tgits.datafaker.example.provider;

import java.io.PrintStream;
import net.datafaker.Faker;
import net.datafaker.providers.base.Business;
import net.datafaker.providers.base.Finance;

public class BusinessAndFinanceProviderExample {
  private final Faker faker;
  private final PrintStream out;

  public BusinessAndFinanceProviderExample(final Faker faker, final PrintStream out) {
    this.faker = faker;
    this.out = out;
  }

  public BusinessAndFinanceProviderExample() {
    this(new Faker(), System.out);
  }

  public BusinessAndFinanceProviderExample(final Faker faker) {
    this(faker, System.out);
  }

  public void print() {
    final Business business = this.faker.business();
    this.out.println("Credit card number : " + business.creditCardNumber());
    this.out.println("Credit card type : " + business.creditCardType());
    this.out.println("Credit card expiry date : " + business.creditCardExpiry());

    final Finance finance = this.faker.finance();
    this.out.println("Credit card : " + finance.creditCard());
    this.out.println("Credit card : " + finance.creditCard(Finance.CreditCardType.MASTERCARD));
    this.out.println("BIC (Business Identifier Code): " + finance.bic());
    this.out.println("IBAN (International Bank Account Number): " + finance.iban());
    this.out.println("French IBAN (International Bank Account Number): " + finance.iban("FR"));
    this.out.println(
        "Stock Market: "
            + finance.stockMarket()
            + " - "
            + finance.nasdaqTicker()
            + " - "
            + finance.nyseTicker());
  }
}
