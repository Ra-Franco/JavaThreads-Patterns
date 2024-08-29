package ZZLambas.tst;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class LambdaTest02 {
    public static void main(String[] args) {

        List<String> list = List.of("Ramon", "Franco", "Chrollo");
        List<Integer> integers = map(list, String::length);
        List<String> upperCase = map(list, String::toUpperCase);
        System.out.println(integers);
        System.out.println(upperCase);

    }

    private static <T, R> List<R> map(List<T> list, Function<T, R> function){
        List<R> result = new ArrayList<>();
        for (T t : list) {
            R r  = function.apply(t);
            result.add(r);
        }
        return result;
    }

}
