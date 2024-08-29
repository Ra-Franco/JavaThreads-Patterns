package ZGenerics.test;

import Ycolocoes.dominio.Consumidor;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GenericTest01 {
    public static void main(String[] args) {

        List<String> lista = new ArrayList<>();
        lista.add("Midorya");
        lista.add("Midorya");

        for (String o : lista){
            System.out.println(o);
        }
        add(lista, new Consumidor("Midoriya"));

    }
    private static void add(List lista, Consumidor consumidor) {
            lista.add(consumidor);
    }
}
