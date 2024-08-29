package ZZEStreams.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class FlatMapTest01 {
    public static void main(String[] args) {
        List<List<String>> devDojo = new ArrayList<>();
        List<String> graphicDesigners = List.of("Teste de", "sfv cxs", "Catarima");
        List<String> developers = List.of("David", "William", "Harrisson");
        List<String> students = List.of("Édipo", "Gustavo Lima", "Gustavo Mendes", "Guilherme");

        devDojo.add(graphicDesigners);
        devDojo.add(developers);
        devDojo.add(students);

        for (List<String> people : devDojo) {
            for (String person : people){
                System.out.println(person);
            }
        }
        System.out.println("--------------------------");
        devDojo.stream()
                .flatMap(Collection::stream)
                .forEach(System.out::println);

    }
}
