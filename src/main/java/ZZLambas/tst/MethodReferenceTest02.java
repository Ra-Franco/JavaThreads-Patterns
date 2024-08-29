package ZZLambas.tst;

import ZZLambas.dominio.Anime;
import ZZLambas.service.AnimeComparators;

import java.util.ArrayList;
import java.util.List;

public class MethodReferenceTest02 {
    public static void main(String[] args) {

        AnimeComparators comparator = new AnimeComparators();
        List<Anime> animeList = new ArrayList<>(List.of(new Anime("Berserk", 43), new Anime("Helsing", 900), new Anime("Naruto",500)));
        animeList.sort(comparator::compareByEpisodesNonStatic);
//        animeList.sort((a1,a2) -> comparator.compareByEpisodesNonStatic(a1,a2));
        System.out.println(animeList);


    }
}
