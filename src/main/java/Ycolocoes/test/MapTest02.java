package Ycolocoes.test;

import Ycolocoes.dominio.Consumidor;
import Ycolocoes.dominio.Manga;

import java.util.HashMap;
import java.util.Map;

public class MapTest02 {
    public static void main(String[] args) {

        Consumidor consumidor1 = new Consumidor("Ramon");
        Consumidor consumidor2 = new Consumidor("José");

        Manga manga1 = new Manga(5L,"SNK",19.99);
        Manga manga2 = new Manga(1L,"Berserker", 13.99);
        Manga manga3 = new Manga(3L,"Pokemon", 10.99);
        Manga manga4 = new Manga(4L,"Dragon Ball Z",23.99);

        Map<Consumidor, Manga> consumidorManga = new HashMap<>();
        consumidorManga.put(consumidor1, manga1);
        consumidorManga.put(consumidor2, manga3);

        for (Map.Entry<Consumidor, Manga> entry : consumidorManga.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

    }
}
