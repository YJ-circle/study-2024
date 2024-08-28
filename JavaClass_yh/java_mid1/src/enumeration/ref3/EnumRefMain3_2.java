package enumeration.ref3;

//DiscountService를 삭제해보자!
public class EnumRefMain3_2 {
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
        System.out.println("basic = " + Grade.BASIC.discount(price));
        System.out.println("gold = " + Grade.GOLD.discount(price));
        System.out.println("diamond = " + Grade.DIAMOND.discount(price));
    }
}
