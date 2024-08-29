package ZZEStreams.test;

import ZZEStreams.domain.Category;
import ZZEStreams.domain.LightNovel;
import ZZEStreams.domain.Promotion;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class CollectorsTest03 {
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
        Map<Promotion, List<LightNovel>> collect = lightNovels.stream()
                .collect(groupingBy(CollectorsTest03::getPromotion));
        System.out.println(collect);
        //Map<Category, Map<Promotion, List<LightNovel>>>
        Map<Category, Map<Promotion, List<LightNovel>>> collect1 = lightNovels
                .stream()
                .collect(groupingBy(LightNovel::getCategory,
                        groupingBy(CollectorsTest03::getPromotion)
                ));
        System.out.println(collect1);
    }

    private static Promotion getPromotion(LightNovel ln) {
        return ln.getPrice() < 6 ? Promotion.UNDER_PROMOTION : Promotion.NORMAL_PRICE;
    }
}
