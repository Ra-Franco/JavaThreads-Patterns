package ZZEStreams.test;

import ZZEStreams.domain.LightNovel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

//1. Ordene LightNovel by title
//2. Retrive the first 3 titles light novels with price less than 5
public class SteamsTest01 {

    private static List<LightNovel> lightNovels = new ArrayList<>( List.of(
            new LightNovel("Boku No Hero", 34.33),
            new LightNovel("Overlord", 3.33),
            new LightNovel("Horimiya", 4.33),
            new LightNovel("Tower of God", 1.33),
            new LightNovel("No Game no Life", 9.31),
            new LightNovel("Fullmetal Alchemist", 19.21)
    ));

    public static void main(String[] args) {

        lightNovels.sort(Comparator.comparing(LightNovel::getTitle));
        List<String> titles = new ArrayList<>();
        for (LightNovel lightNovel : lightNovels) {
            if (lightNovel.getPrice() <= 5) {
                titles.add(lightNovel.getTitle());
            }
            if (titles.size() >= 3){
                break;
            }
        }
        System.out.println(lightNovels);
        System.out.println(titles);

    }
}
