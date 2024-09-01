package enumeration.ref3;

public enum Grade {
    // 열거형 상수 선언 + 생성자로 만듬
    BASIC(10), GOLD(20), DIAMOND(30), VIP(40);; // 3_4용, VIP(40);
    private final int discountPercent;


    //생성자 접근제어자는 적지 않아도 private이다.
    Grade(int discountPercent) {
        this.discountPercent = discountPercent;
    }

    // 가져올 수 있는 getter
    public int getDiscountPercent() {
        return discountPercent;
    }

    // 금액 계산 메서드 추가
    public int discount(int price) {
        return price * discountPercent / 100;
    }
}
