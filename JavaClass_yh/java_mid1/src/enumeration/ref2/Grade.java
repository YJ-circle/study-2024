package enumeration.ref2;

public enum Grade {
    BASIC(10), GOLD(20), DIAMOND(30); // 열거형 상수 선언 + 생성자로 만듬
    private final int discountPercent;


    //생성자 접근제어자는 적지 않아도 private이다.
    Grade(int discountPercent) {
        this.discountPercent = discountPercent;
    }

    // 가져올 수 있는 getter
    public int getDiscountPercent() {
        return discountPercent;
    }
}
