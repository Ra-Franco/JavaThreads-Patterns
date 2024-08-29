package ZZDOptional.test;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

public class OptionalTest01 {
    public static void main(String[] args) {
        Optional<String> o1 = Optional.of("Aha");
        Optional<String> o2 = Optional.ofNullable(null);

        System.out.println(o1);
        System.out.println(o2);

        Optional<String> nameOptional = findName("William");
        String empty = nameOptional.orElse("Empty");
        System.out.println(nameOptional);
        nameOptional.ifPresent(s -> System.out.println(s.toUpperCase()));
    }

    private static Optional<String> findName(String name){
        List<String> list = List.of("William", "Roberto", "Algo");
        int i = list.indexOf(name);
        if (i != -1) {
            return Optional.of(list.get(i));
        }
        return Optional.empty();
    }

}
