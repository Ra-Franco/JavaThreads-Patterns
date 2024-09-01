package ZZH.padroesdeprojetos.test;

import ZZH.padroesdeprojetos.dominio.Person;

public class BuilderPatternTest01 {
    public static void main(String[] args) {
        new Person.PersonBuilder().builder()
                .firstName("Ramon")
                .lastName("Franco")
                .email("ramon@gmail.com")
                .username("rfccastro")
                .build();
    }
}
