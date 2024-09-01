package ZZH.padroesdeprojetos.dominio;

import java.util.HashSet;
import java.util.Set;

public final class AircraftSingletonEager {
    private static AircraftSingletonEager INSTANCE = new AircraftSingletonEager("Boeing-1239");
    private final Set<String> availableSets = new HashSet<>();
    private final String name;

    private AircraftSingletonEager(String name) {
        this.name = name;
    }

    {
        availableSets.add("1A");
        availableSets.add("1B");
    }
    public boolean bookSeat(String seat) {
        return availableSets.remove(seat);
    }

    public static AircraftSingletonEager getINSTANCE() {
        return INSTANCE;
    }
}
