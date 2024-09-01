package ZZH.padroesdeprojetos.test;


import ZZH.padroesdeprojetos.dominio.AircraftSingletonEager;

public class AircraftSingletonEagerTest01 {
    public static void main(String[] args) {
        bookSeat("1A");
        bookSeat("1A");
    }

    private static void bookSeat(String seat){
        System.out.println(AircraftSingletonEager.getINSTANCE());
        AircraftSingletonEager aircraft = AircraftSingletonEager.getINSTANCE();
        System.out.println(aircraft.bookSeat(seat));
    }

}
