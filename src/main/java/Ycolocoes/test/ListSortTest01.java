package Ycolocoes.test;

import Ycolocoes.dominio.Manga;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListSortTest01 {
    public static void main(String[] args) {
        List<String> mangas = new ArrayList<String>();
        mangas.add("SNK");
        mangas.add("Berserker");
        mangas.add("Pokemon");
        mangas.add("Dragon Ball Z");
        Collections.sort(mangas);

        List<Double> dinheiros = new ArrayList<>();

        dinheiros.add(100.12);
        dinheiros.add(11230.12);
        dinheiros.add(120.12);
        dinheiros.add(30.12);

        Collections.sort(dinheiros);

        for (String manga : mangas) {
            System.out.println(manga);
        }

        System.out.println(dinheiros);
    }
}
