package ZZH.padroesdeprojetos.test;

import ZZH.padroesdeprojetos.dominio.*;

public class DataTransferObjectTest01 {
    public static void main(String[] args) {
        Aircraft aircraft = new Aircraft("tes");
        Country country = Country.BRAZIL;
        Currency currency = CurrencyFactory.newCurrency(country);
        Person person = Person.PersonBuilder.builder()
                .firstName("Ramon")
                .lastName("Franco")
                .username("Fcccastro")
                .build();

        ReportDto report = ReportDto.ReportDtoBuilder.aReportDto()
                .aircraftName(aircraft.getName())
                .country(country)
                .currency(currency)
                .personName(person.getName())
                .build();
        System.out.println(report);
    }
}
