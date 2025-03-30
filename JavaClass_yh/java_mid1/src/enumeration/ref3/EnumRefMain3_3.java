package enumeration.ref3;

//출력 부분 중복을 제거해보자!
public class EnumRefMain3_3 {
    public static void main(String[] args) {
        int price = 10000;
        DiscountService discountService = new DiscountService();

//        int basic = Grade.BASIC.discount(price);
//        int gold = Grade.GOLD.discount(price);
//        int diamond = Grade.DIAMOND.discount(price);
//        System.out.println("basic = " + basic);
//        System.out.println("gold = " + gold);
//        System.out.println("diamond = " + diamond);

        // 인라인!

        //중복제거
//        System.out.println("BASIC 등급의 할인 금액: " + Grade.BASIC.discount(price));
//        System.out.println("GOLD 등급의 할인 금액: " + Grade.GOLD.discount(price));
//        System.out.println("DIAMOND 등급의 할인 금액: " + Grade.DIAMOND.discount(price));
        printDiscount(Grade.BASIC, price);
        printDiscount(Grade.GOLD, price);
        printDiscount(Grade.DIAMOND, price);
    }

    private static void printDiscount(Grade grade, int price) {
        System.out.println(grade.name() + " 등급의 할인 금액: " + grade.discount(price));
    }
}
