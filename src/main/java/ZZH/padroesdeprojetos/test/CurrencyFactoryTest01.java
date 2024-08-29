package ZZH.padroesdeprojetos.test;

import ZZH.padroesdeprojetos.dominio.Country;
import ZZH.padroesdeprojetos.dominio.Currency;
import ZZH.padroesdeprojetos.dominio.CurrencyFactory;

public class CurrencyFactoryTest01 {
    public static void main(String[] args) {
        Currency currency = CurrencyFactory.newCurrency(Country.BRAZIL);
        System.out.println(currency.getSymbol());
    }
}
