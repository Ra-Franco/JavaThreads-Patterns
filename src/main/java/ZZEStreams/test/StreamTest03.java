package ZZEStreams.test;

import ZZEStreams.domain.LightNovel;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamTest03 {
    private static List<LightNovel> lightNovels = new ArrayList<>( List.of(
            new LightNovel("Boku No Hero", 34.33),
            new LightNovel("Overlord", 3.33),
            new LightNovel("Horimiya", 4.33),
            new LightNovel("Tower of God", 1.33),
            new LightNovel("No Game no Life", 9.31),
            new LightNovel("No Game no Life", 9.31),
            new LightNovel("Fullmetal Alchemist", 19.21)
    ));

    public static void main(String[] args) {
        Stream<LightNovel> stream = lightNovels.stream();
        lightNovels.forEach(System.out::println);

        long count = stream.filter(ln -> ln.getPrice() <= 10)
                .count();
        long count2 = lightNovels.stream()
                .distinct()
                .filter(ln -> ln.getPrice() <= 10)
                .count();
        System.out.println(count);
        System.out.println(count2);
    }
}
