package ZZEStreams.test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest04 {
    public static void main(String[] args) {
        IntStream.rangeClosed(1,50)
                .filter(n -> n % 2 == 0)
                .forEach(System.out::print);

        Stream.of("Bs", "SX", "ASX", "ASEDE")
                .map(String::toUpperCase)
                .forEach(s -> System.out.print(s + " "));

        int num[] = {1,2,3,4,5};
        Arrays.stream(num)
                .average()
                .ifPresent(System.out::println);

        try(Stream<String> lines = Files.lines(Paths.get("file.txt"))) {
            lines.filter(s -> s.contains("Java"))
                    .forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
