package ZGenerics.domain;

import java.util.ArrayList;
import java.util.List;

public class MetodoGenericoTest01 {
    public static void main(String[] args) {

        List<Barco> barcos = criarArrayComObjeto(new Barco("Canoa XD"));
        System.out.println(barcos);
    }
        
    private static <T> List<T> criarArrayComObjeto(T t){
        return List.of(t);
    }

}