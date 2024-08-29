package Ycolocoes.test;

import Ycolocoes.dominio.Manga;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class SetTeste01 {
    public static void main(String[] args) {
        Set<Manga> mangas = new LinkedHashSet<>();
        mangas.add(new Manga(5L,"SNK",19.99, 0));
        mangas.add(new Manga(1L,"Berserker", 13.99,5));
        mangas.add(new Manga(3L,"Pokemon", 10.99,0));
        mangas.add(new Manga(4L,"Dragon Ball Z",23.99, 2));
        mangas.add(new Manga(4L,"Dragon Ball Z",23.99, 2));

        for (Manga manga : mangas) {
            System.out.println(manga);
        }
    }
}
