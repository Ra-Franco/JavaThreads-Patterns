package Ycolocoes.test;

import Ycolocoes.dominio.Manga;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class IteratorTest01 {
    public static void main(String[] args) {
        List<Manga> mangas = new LinkedList<>();
        mangas.add(new Manga(5L,"SNK",19.99, 0));
        mangas.add(new Manga(1L,"Berserker", 13.99,5));
        mangas.add(new Manga(3L,"Pokemon", 10.99,0));
        mangas.add(new Manga(4L,"Dragon Ball Z",23.99, 2));

//        for (Manga manga : mangas) {
//            if (manga.getQuantidade() == 0){
//                mangas.remove(manga);
//            }
//        }
//
//        Iterator<Manga> mangaIterator = mangas.iterator();
//        while (mangaIterator.hasNext()){
//            if(mangaIterator.next().getQuantidade() == 0){
//                mangaIterator.remove();
//            }
//        }
        mangas.removeIf(manga -> manga.getQuantidade() == 0);
        System.out.println(mangas);
    }
}
