package ZZEStreams.test;

import ZZEStreams.domain.Category;
import ZZEStreams.domain.LightNovel;
import ZZEStreams.domain.Promotion;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class CollectorsTest05 {
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
        Map<Category, DoubleSummaryStatistics> summaryStatisticsMap = lightNovels.stream()
                .collect(groupingBy(LightNovel::getCategory, summarizingDouble(LightNovel::getPrice)));
        System.out.println(summaryStatisticsMap);

        Map<Category, Set<Promotion>> collect = lightNovels.stream()
                .collect(groupingBy(LightNovel::getCategory, mapping(CollectorsTest05::getPromotion, toSet())));

        System.out.println(collect);


        Map<Category, LinkedHashSet<Promotion>> collect1 = lightNovels.stream()
                .collect(groupingBy(LightNovel::getCategory, mapping(CollectorsTest05::getPromotion,
                        Collectors.toCollection(LinkedHashSet::new)
                )));
        System.out.println(collect1);
    }
    private static Promotion getPromotion(LightNovel ln) {
        return ln.getPrice() < 6 ? Promotion.UNDER_PROMOTION : Promotion.NORMAL_PRICE;
    }
}
