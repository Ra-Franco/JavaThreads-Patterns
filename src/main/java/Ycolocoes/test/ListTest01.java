package Ycolocoes.test;

import java.util.ArrayList;
import java.util.List;

public class ListTest01 {
    public static void main(String[] args) {
        List<String> nomes = new ArrayList<>();
        List<String> nomes2 = new ArrayList<>();
        nomes.add("William");
        nomes.add("DevDojo Academy");
        nomes2.add("S");
        nomes2.add("S Academy");

//        nomes.remove("William");

        nomes.addAll(nomes2);

        for (String nome : nomes){
            System.out.println(nome);
        }
        for (int i = 0; i < nomes.size(); i++){
            System.out.println(nomes.get(i));
        }
        List<Integer> numeros = new ArrayList<>();
        numeros.add(1);

        System.out.println(numeros);
    }
}
