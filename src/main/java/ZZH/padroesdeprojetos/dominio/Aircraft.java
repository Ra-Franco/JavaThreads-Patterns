package ZZH.padroesdeprojetos.dominio;

import java.util.HashSet;
import java.util.Set;

public final class Aircraft {
    private String name;

    public Aircraft(String name){
        this.name = name;
    }

    private final Set<String> availableSets = new HashSet<>();
    {
        availableSets.add("1A");
        availableSets.add("1B");
    }
    public boolean bookSeat(String seat) {
        return availableSets.remove(seat);
    }

    public String getName() {
        return name;
    }
}
