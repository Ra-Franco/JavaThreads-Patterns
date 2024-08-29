package ZZEStreams.test;

import ZZEStreams.domain.LightNovel;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class FindingAndMatchTest01 {
    private static List<LightNovel> lightNovels = new ArrayList<>( List.of(
            new LightNovel("Boku No Hero", 34.33),
            new LightNovel("Overlord", 3.33),
            new LightNovel("Horimiya", 4.33),
            new LightNovel("Tower of God", 1.33),
            new LightNovel("No Game no Life", 9.31),
            new LightNovel("Fullmetal Alchemist", 19.21)
    ));

    public static void main(String[] args) {
        System.out.println(lightNovels.stream().anyMatch(ln -> ln.getPrice() > 43));
        System.out.println(lightNovels.stream().allMatch(ln -> ln.getPrice() > 0));
        System.out.println(lightNovels.stream().noneMatch(ln -> ln.getPrice() > 0));
        lightNovels.stream()
                .filter(ln -> ln.getPrice() > 3)
                .findAny()
                .ifPresent(System.out::println);

        lightNovels.stream()
                .filter(ln -> ln.getPrice() > 3)
                .sorted(Comparator.comparing(LightNovel::getPrice))
                .findFirst()
                .ifPresent(System.out::println);

    }

}
