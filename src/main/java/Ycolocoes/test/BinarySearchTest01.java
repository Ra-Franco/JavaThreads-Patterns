package Ycolocoes.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinarySearchTest01 {
    public static void main(String[] args) {

        List<Integer> numeros = new ArrayList<Integer>();
        numeros.add(2);
        numeros.add(0);
        numeros.add(4);
        numeros.add(3);
        // (-(pontode de inserção) -1)
        Collections.sort(numeros);
        var result = Collections.binarySearch(numeros,-1);
        System.out.println(result);
    }
}
