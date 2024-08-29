package ZGenerics.ZZAClassesInternas.test;

public class OuterClassTest01 {

    private String name = "Monkey D. Luffy";

    class Inner {
        public void printOuterClassAttribute(){
            System.out.println(name);
            System.out.println(this);
            System.out.println(OuterClassTest01.this);
        }
    }

    public static void main(String[] args) {
        OuterClassTest01 outerClassTest= new OuterClassTest01();
        Inner inner = outerClassTest.new Inner();
        inner.printOuterClassAttribute();
    }
}
