package ZZLambas.tst;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;

public class MethodReferenceTest03 {
    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>(List.of("Rimuru", "Veldora", "Hikimaru"));
        stringList.sort(String::compareTo);
        System.out.println(stringList);
        Function<String, Integer> numStringToInteger = Integer::parseInt;
        System.out.println(numStringToInteger.apply("10"));

        BiPredicate<List<String>, String> checkName = List::contains;
        System.out.println(checkName.test(stringList, "Rimuru"));
    }
}
