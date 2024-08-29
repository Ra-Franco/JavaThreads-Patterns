package Ycolocoes.test;

import Ycolocoes.dominio.Manga;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinarySearchTest02 {
    public static void main(String[] args) {
        List<Manga> mangas = new ArrayList<>();
        mangas.add(new Manga(5L,"SNK",19.99));
        mangas.add(new Manga(1L,"Berserker", 13.99));
        mangas.add(new Manga(3L,"Pokemon", 10.99));
        mangas.add(new Manga(4L,"Dragon Ball Z",23.99));

//        Collections.sort(mangas);

        mangas.sort(new MangaByIdComparator());
        for (Manga manga : mangas) {
            System.out.println(manga);
        }

        Manga mangaToSearch = new Manga(5L,"SNK",19.99);
        System.out.println(Collections.binarySearch(mangas, mangaToSearch, new MangaByIdComparator()));
    }
}
