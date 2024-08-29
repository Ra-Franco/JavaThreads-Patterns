package ZZEStreams.test;

import ZZEStreams.domain.LightNovel;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SteamTest02 {
    private static List<LightNovel> lightNovels = new ArrayList<>( List.of(
            new LightNovel("Boku No Hero", 34.33),
            new LightNovel("Overlord", 3.33),
            new LightNovel("Horimiya", 4.33),
            new LightNovel("Tower of God", 1.33),
            new LightNovel("No Game no Life", 9.31),
            new LightNovel("Fullmetal Alchemist", 19.21)
    ));

    public static void main(String[] args) {
        List<String> lista = lightNovels.stream()
                .sorted(Comparator.comparing(LightNovel::getTitle))
                .filter(l -> l.getPrice() <= 4)
                .limit(3)
                .map(LightNovel::getTitle)
                .toList();

        System.out.println(lista);
    }
}
