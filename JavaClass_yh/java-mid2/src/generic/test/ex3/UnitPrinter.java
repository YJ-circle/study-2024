package generic.test.ex3;

import generic.test.ex3.unit.BioUnit;

public class UnitPrinter {

    public static <T extends BioUnit> void printV1(Shuttle<T> shuttle){
        T t = shuttle.getUnit();
        System.out.println("이름: " + t.getName() + " HP: " + t.getHp());
    }

    public static void printV2(Shuttle<? extends BioUnit> shuttle){
//        String name = shuttle.getUnit().getName();
//        int hp = shuttle.getUnit().getHp();
        BioUnit unit = shuttle.getUnit();
        System.out.println("이름: " + unit.getName() + " HP: " + unit.getHp());
    }
}
