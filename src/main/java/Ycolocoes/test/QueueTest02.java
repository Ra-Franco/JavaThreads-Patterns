package Ycolocoes.test;

import Ycolocoes.dominio.Consumidor;
import Ycolocoes.dominio.Manga;

import java.util.PriorityQueue;
import java.util.Queue;

public class QueueTest02 {
    public static void main(String[] args) {
        Queue<Manga> mangas = new PriorityQueue<>(new MangaPrecoComparator().reversed());

        mangas.add(new Manga(5L,"SNK",19.99, 0));
        mangas.add(new Manga(1L,"Berserker", 13.99,5));
        mangas.add(new Manga(3L,"Pokemon", 10.99,0));
        mangas.add(new Manga(4L,"Dragon Ball Z",23.99, 2));
        mangas.add(new Manga(2L,"Dragon Ball Z",23.99, 2));

        while (!mangas.isEmpty()){
            System.out.println(mangas.poll());
        }
    }
}
