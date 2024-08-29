package ZZEStreams.test;

import java.util.Arrays;
import java.util.List;

public class RudeceTest01 {
    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1,2,3,4,5,6);
        integers.stream().reduce(Integer::sum)
                .ifPresent(System.out::println);

        int sum = integers.stream().reduce(0,Integer::sum);
        System.out.println(sum);

        integers.stream().reduce((x,y) -> x*y).ifPresent(System.out::println);
        int multiplication = integers.stream().reduce(1,(x,y) -> x*y);
        System.out.println(multiplication);

        integers.stream().reduce(Integer::max).ifPresent(System.out::println);
        int max = integers.stream().reduce(0, Integer::max);
        System.out.println(max);

    }
}
