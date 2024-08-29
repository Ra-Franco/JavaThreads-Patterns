package ZZEStreams.test;

import java.util.Arrays;
import java.util.List;

public class FlatMapTest02 {
    public static void main(String[] args) {
        List<String> words = List.of("Gomu", "Gomu","No","Mi");
        String[] letters = words.get(0).split("");
        System.out.println(Arrays.toString(letters));

        List<String> streamLetters = words.stream()
                .map(w -> w.split("")) //Strea<String[]>
                .flatMap(Arrays::stream)//Stream<String>
                .toList();

        System.out.println(streamLetters);
    }
}
