package ZZLambas.tst;

import ZZLambas.dominio.Anime;
import ZZLambas.service.AnimeComparators;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Supplier;

public class MethodReferencTest04 {
    public static void main(String[] args) {

        Supplier<AnimeComparators> newAnimeComparators = AnimeComparators::new;
        AnimeComparators comparator = newAnimeComparators.get();
        List<Anime> animeList = new ArrayList<>(List.of(new Anime("Berserk", 43), new Anime("Helsing", 900), new Anime("Naruto",500)));

        animeList.sort(comparator::compareByEpisodesNonStatic);

        System.out.println(animeList);

        BiFunction<String, Integer, Anime> animeBiFunction = (title,episodes) -> new Anime(title,episodes);
        BiFunction<String, Integer, Anime> animeBiFunction2 = Anime::new;

        System.out.println(animeBiFunction2.apply("Death Note", 59));


    }
}
