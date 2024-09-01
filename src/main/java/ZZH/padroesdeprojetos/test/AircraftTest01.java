package ZZH.padroesdeprojetos.test;

import ZZH.padroesdeprojetos.dominio.Aircraft;

public class AircraftTest01 {
    public static void main(String[] args) {
        bookSeat("1A");
        bookSeat("1A");
    }

    static void bookSeat(String seat){
        Aircraft aircraft = new Aircraft("teste");
        System.out.println(aircraft.bookSeat(seat));
    }

}
