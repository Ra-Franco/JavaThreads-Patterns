package Ycolocoes.test;

import Ycolocoes.dominio.Manga;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class MangaByIdComparator implements Comparator<Manga> {

    @Override
    public int compare(Manga o1, Manga o2) {
        return o1.getId().compareTo(o2.getId());
    }
}

public class MangaSortTest01 {
    public static void main(String[] args) {
        List<Manga> mangas = new ArrayList<>();
        mangas.add(new Manga(5L,"SNK",19.99));
        mangas.add(new Manga(1L,"Berserker", 13.99));
        mangas.add(new Manga(3L,"Pokemon", 10.99));
        mangas.add(new Manga(4L,"Dragon Ball Z",23.99));

        Collections.sort(mangas);
        System.out.println(mangas);

        System.out.println("--------------");

//        Collections.sort(mangas, new MangaByIdComparator());
        mangas.sort(new MangaByIdComparator());
        System.out.println(mangas);

    }
}
