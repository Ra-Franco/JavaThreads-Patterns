package ZZH.padroesdeprojetos.test;

import ZZH.padroesdeprojetos.dominio.AircraftSingletonEnum;
import ZZH.padroesdeprojetos.dominio.AircraftSingletonLazy;

public class AircraftSingletonEnumTest01 {
    public static void main(String[] args) {
        bookSeat("1A");
        bookSeat("1A");

    }
    private static void bookSeat(String seat){
        System.out.println(AircraftSingletonEnum.INSTANCE);
        AircraftSingletonEnum instance = AircraftSingletonEnum.INSTANCE;
        System.out.println(instance.bookSeat(seat));
    }
}
