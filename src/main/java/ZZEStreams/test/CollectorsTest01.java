package ZZEStreams.test;

import ZZEStreams.domain.LightNovel;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

public class CollectorsTest01 {
    private static List<LightNovel> lightNovels = new ArrayList<>( List.of(
            new LightNovel("Boku No Hero", 34.33),
            new LightNovel("Overlord", 3.33),
            new LightNovel("Horimiya", 4.33),
            new LightNovel("Tower of God", 1.33),
            new LightNovel("No Game no Life", 9.31),
            new LightNovel("No Game no Life", 1.31),
            new LightNovel("Fullmetal Alchemist", 12.21)
    ));
    public static void main(String[] args) {
        System.out.println(lightNovels.stream().collect(Collectors.counting()));

        lightNovels.stream()
                .max(Comparator.comparing(LightNovel::getPrice))
                .ifPresent(System.out::println);

        lightNovels.stream()
                .collect(Collectors.maxBy(Comparator.comparing(LightNovel::getPrice)))
                .ifPresent(System.out::println);

        DoubleSummaryStatistics statistics = lightNovels.stream()
                .collect(Collectors.summarizingDouble(LightNovel::getPrice));
        System.out.println(statistics);

        String titles = lightNovels.stream()
                .map(LightNovel::getTitle)
                .collect(Collectors.joining(", "));
        System.out.println(titles);

    }
}
