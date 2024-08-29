package ZGenerics.ZZAClassesInternas.test;

public class OuterClassTest03 {
    private String name = "TETES";
    static class Nested    {
        private String lastName = "TETE";
        void print(){
            System.out.println(new OuterClassTest03().name + " " + lastName);
        }
    }

    public static void main(String[] args) {
        Nested  obj = new Nested();
        obj.print();
    }
}
