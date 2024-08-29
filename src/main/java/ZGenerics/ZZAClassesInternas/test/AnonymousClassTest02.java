package ZGenerics.ZZAClassesInternas.test;

import ZGenerics.domain.Barco;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AnonymousClassTest02 {
    public static void main(String[] args) {

        List<Barco> barcoList = new ArrayList<>(List.of(new Barco("Lancha"), new Barco("Canoa")));
        barcoList.sort((o1, o2) -> o1.getNome().compareTo(o2.getNome()));
        System.out.println(barcoList);
    }
}
