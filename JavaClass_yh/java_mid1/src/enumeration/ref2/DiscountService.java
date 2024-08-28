package enumeration.ref2;

public class DiscountService {
    public int discount(Grade grade, int price) {
//        int discountPercent = grade.getDiscountPercent();
//        return price * discountPercent / 100;
//        inline variable 단축키 윈도우: Ctrl+Alt N
        return price * grade.getDiscountPercent() / 100;
    }
}
