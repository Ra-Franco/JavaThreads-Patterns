package ZZEStreams.test;

import ZZEStreams.domain.LightNovel;

import java.util.ArrayList;
import java.util.List;

public class ReduceTest02 {
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
        lightNovels.stream()
                .map(LightNovel::getPrice)
                .filter(price -> price >3)
                .reduce(Double::sum)
                .ifPresent(System.out::println);

        double sum = lightNovels.stream()
                .mapToDouble(LightNovel::getPrice)
                .filter(p -> p > 3)
                .sum();

        System.out.println(sum);

    }
}
