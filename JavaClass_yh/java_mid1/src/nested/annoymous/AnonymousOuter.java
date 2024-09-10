package nested.annoymous;

public class AnonymousOuter {
    private int outerValue = 3;

    public void process(int paramVar){
        int localVar = 1;
        class LocalPrinter {
            int value = 0;


            public void print() {
                System.out.println("value = " + value);
                System.out.println("localVar = " + localVar);
                System.out.println("paramVar = " + paramVar);
                System.out.println("outerValue = " + outerValue);

            }
        }
    }

    public static void main(String[] args) {

    }




}
