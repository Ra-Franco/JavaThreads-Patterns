package ZZEStreams.test;

import ZZEStreams.domain.Category;
import ZZEStreams.domain.LightNovel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CollectorsTest02 {
    private static List<LightNovel> lightNovels = new ArrayList<>( List.of(
            new LightNovel("Boku No Hero", 34.33, Category.FANTASY),
            new LightNovel("Overlord", 3.33, Category.FANTASY),
            new LightNovel("Horimiya", 4.33, Category.ROMANCE),
            new LightNovel("Tower of God", 1.33, Category.FANTASY),
            new LightNovel("No Game no Life", 9.31, Category.ROMANCE),
            new LightNovel("No Game no Life", 1.31, Category.DRAMA),
            new LightNovel("Fullmetal Alchemist", 12.21, Category.DRAMA)
    ));

    public static void main(String[] args) {
//        Map<Category, List<LightNovel>> categoryLightNovelMap = new HashMap<>();
//        List<LightNovel> fantasy = new ArrayList<>();
//        List<LightNovel> romance = new ArrayList<>();
//        List<LightNovel> drama = new ArrayList<>();
//
//        for (LightNovel lightNovel : lightNovels) {
//            switch (lightNovel.getCategory()){
//                case DRAMA: drama.add(lightNovel); break;
//                case FANTASY: fantasy.add(lightNovel); break;
//                case ROMANCE: romance.add(lightNovel); break;
//            }
//        }
//
//        categoryLightNovelMap.put(Category.DRAMA, drama);
//        categoryLightNovelMap.put(Category.FANTASY, fantasy);
//        categoryLightNovelMap.put(Category.ROMANCE, romance);
//        System.out.println(categoryLightNovelMap);

        System.out.println("----------------");

        Map<Category, List<LightNovel>> map = lightNovels.stream()
                .collect(Collectors.groupingBy(LightNovel::getCategory));

        System.out.println(map);

    }
}
