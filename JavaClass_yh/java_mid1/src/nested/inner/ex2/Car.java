package nested.inner.ex2;

public class Car {
    private String model;
    private int chargeLevel;
    private Engine engine;

    public Car(String model, int chargeLevel) {
        this.model = model;
        this.chargeLevel = chargeLevel;
        this.engine = new Engine(); // 생성자 제거
    }
    // engine에서만 사용하는 메서드 : 필요가 없어진다. 그냥 접근 하면 된다.

//    public String getModel() {
//        return model;
//    }
//
//    public int getChargeLevel() {
//        return chargeLevel;
//    }
//
    public void start(){
        engine.start();
        System.out.println(model + "시작 완료");
    }

    private class Engine {
        // 내부 클래스는 바깥 클래스의 인스턴스에 접근 할 수 있다.
        // 따라서 car에 대해 따로 정의할 필요가 없다.
//        private Car car;
//
//        public Engine(Car car) {
//            this.car = car;
//        }

        public void start(){
            System.out.println("충전 레벨 확인: " + chargeLevel);
            System.out.println(model + "의 엔진을 구동합니다.");
        }
    }

}
