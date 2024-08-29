package ZZEStreams.test;

import com.sun.jdi.request.StepRequest;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;

public class StreamTest05 {
    public static void main(String[] args) {
        Stream.iterate(0, i -> 1+i)
                .limit(10)
                .forEach(System.out::println);
        // 0,1,1,2,3,5

        Stream.iterate(new int[]{0,1}, n -> new int[]{n[1], n[0] + n[1]})
                .limit(10)
                .map(a -> a[0])
                .forEach(System.out::println);

        ThreadLocalRandom random = ThreadLocalRandom.current();

        Stream.generate(() -> random.nextInt(1, 500))
                .limit(99)
                .forEach(System.out::println);


    }
}
