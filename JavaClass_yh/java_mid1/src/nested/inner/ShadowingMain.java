package nested.inner;

public class ShadowingMain {
    public int value = 1;
    class Inner {
        public int value = 2;
        void go() {
            int value = 3;
            System.out.println("value = " + value);
            System.out.println("this.value = " + this.value);
            System.out.println("ShadowingMain.this.value = " + ShadowingMain.this.value);
        }
    }


    // 외부 클래스와 내부 클래스 이름이 같으면?
    // 내부클래스 변수가 우선 출력된다.
    // 내부 클래스 안에 같은 이름의 지역 변수가 있으면?
    // 지역 변수가 우선이다.
    // 내부 클래스 인스턴스의 값을 출력하려면 this.value를 사용하면 된다.
    // 외부 클래스 인스턴스 값을 출력하려면 바깥클래스명.this.value
    public static void main(String[] args) {
        ShadowingMain main = new ShadowingMain();
        Inner inner = main.new Inner();
        inner.go();
    }
}

