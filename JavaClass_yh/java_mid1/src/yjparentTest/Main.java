package yjparentTest;

public class Main {
    public static void main(String[] args) {
        Parent p = new Child();
        Child c = new Child();

        System.out.println("p instanceof child = " + (p instanceof Child));
    }
}
