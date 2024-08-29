package ZZEStreams.test;

import ZZEStreams.domain.Category;
import ZZEStreams.domain.LightNovel;
import ZZEStreams.domain.Promotion;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class CollectorsTest04 {
    private static List<LightNovel> lightNovels = new ArrayList<>(List.of(
            new LightNovel("Boku No Hero", 34.33, Category.FANTASY),
            new LightNovel("Overlord", 3.33, Category.FANTASY),
            new LightNovel("Horimiya", 4.33, Category.ROMANCE),
            new LightNovel("Tower of God", 1.33, Category.FANTASY),
            new LightNovel("No Game no Life", 9.31, Category.ROMANCE),
            new LightNovel("No Game no Life", 1.31, Category.DRAMA),
            new LightNovel("Fullmetal Alchemist", 12.21, Category.DRAMA)
    ));

    public static void main(String[] args) {
        Map<Category, Long> map = lightNovels.stream()
                .collect(Collectors.groupingBy(LightNovel::getCategory, Collectors.counting()));
        System.out.println(map);

        Map<Category, Optional<LightNovel>> collect = lightNovels.stream()
                .collect(groupingBy(LightNovel::getCategory, Collectors.maxBy(Comparator.comparing(LightNovel::getPrice))));
        System.out.println(collect);

        Map<Category, LightNovel> collect1 = lightNovels.stream()
                .collect(groupingBy(LightNovel::getCategory, Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparing(LightNovel::getPrice)), Optional::get)));
        System.out.println(collect1);
    }
}
