package enumeration.ref3;

//반복문으로 코드 수정없이 모든 등급이 출력되게
// ENUM 클래스에 vip 40을 넣어도 잘 작동한다.
public class EnumRefMain3_4 {
    public static void main(String[] args) {
        int price = 10000;
        DiscountService discountService = new DiscountService();
        Grade[] grades = Grade.values();
        for (Grade grade : grades) {
            printDiscount(grade, price);
        }
    }

    private static void printDiscount(Grade grade, int price) {
        System.out.println(grade.name() + " 등급의 할인 금액: " + grade.discount(price));
    }
}
