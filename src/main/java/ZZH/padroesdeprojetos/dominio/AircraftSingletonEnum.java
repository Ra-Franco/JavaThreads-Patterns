package ZZH.padroesdeprojetos.dominio;

import java.util.HashSet;
import java.util.Set;

public enum AircraftSingletonEnum {
    INSTANCE;
    private final Set<String> availableSets;

    AircraftSingletonEnum() {
        this.availableSets = new HashSet<>();
        this.availableSets.add("A1");
        this.availableSets.add("B1");
    }

    public boolean bookSeat(String seat) {
        return availableSets.remove(seat);
    }
}
