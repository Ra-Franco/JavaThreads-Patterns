package Ycolocoes.test;

import Ycolocoes.dominio.Manga;
import Ycolocoes.dominio.Smartphone;

import java.util.Comparator;
import java.util.NavigableSet;
import java.util.TreeSet;

class SmartphoneMarcaComparator implements Comparator<Smartphone> {

    @Override
    public int compare(Smartphone o1, Smartphone o2) {
        return o1.getMarca().compareTo(o2.getMarca());
    }
}

class MangaPrecoComparator implements Comparator<Manga> {

    @Override
    public int compare(Manga o1, Manga o2) {
        return Double.compare(o1.getPreco(), o2.getPreco());
    }
}

public class NavigableSetTest01 {
    public static void main(String[] args) {

        NavigableSet<Smartphone> set = new TreeSet<>(new SmartphoneMarcaComparator());
        Smartphone smartphone = new Smartphone("123", "Nokia");
        set.add(smartphone);

        NavigableSet<Manga> mangas = new TreeSet<>(new MangaPrecoComparator());
        mangas.add(new Manga(5L,"SNK",19.99, 0));
        mangas.add(new Manga(1L,"Berserker", 13.99,5));
        mangas.add(new Manga(3L,"Pokemon", 10.99,0));
        mangas.add(new Manga(4L,"Dragon Ball Z",23.99, 2));
        mangas.add(new Manga(2L,"Dragon Ball Z",23.99, 2));

        for (Manga manga : mangas) {
            System.out.println(manga);
        }

        Manga yuyu = new Manga(21L, "Yuyu HJaksuho", 12.99, 45);

        System.out.println("-------------------");
        System.out.println(mangas.lower(yuyu));
        System.out.println(mangas.floor(yuyu));
        System.out.println(mangas.higher(yuyu));
        System.out.println(mangas.ceiling(yuyu));


        // Metodos de comparação
        // lower <
        // floor <=
        // higher >
        // ceiling >=

        System.out.println(mangas.size());
        System.out.println(mangas.pollFirst());
        System.out.println(mangas.pollLast());

    }
}
