package Ycolocoes.test;

import Ycolocoes.dominio.Consumidor;
import Ycolocoes.dominio.Manga;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapTest03 {
    public static void main(String[] args) {

        Consumidor consumidor1 = new Consumidor("Ramon");
        Consumidor consumidor2 = new Consumidor("José");

        Manga manga1 = new Manga(5L,"SNK",19.99);
        Manga manga2 = new Manga(1L,"Berserker", 13.99);
        Manga manga3 = new Manga(3L,"Pokemon", 10.99);
        Manga manga4 = new Manga(4L,"Dragon Ball Z",23.99);

        List<Manga> mangaConsumidorList = List.of(manga1, manga2, manga3);
        List<Manga> mangaConsumidorList2 = List.of(manga4, manga2, manga3);
        Map<Consumidor, List<Manga>> consumidorMangaMap = new HashMap<>();
        consumidorMangaMap.put(consumidor1, mangaConsumidorList);
        consumidorMangaMap.put(consumidor2, mangaConsumidorList2);

        for (Map.Entry<Consumidor, List<Manga>> entry : consumidorMangaMap.entrySet()){
            System.out.println(entry.getKey());
            for (Manga manga : entry.getValue()){
                System.out.println(manga.getTitulo());
            }
        }



    }
}
