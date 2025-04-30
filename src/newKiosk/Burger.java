package newKiosk;

// 버거의 속성을 관리해주는 클래스
public class Burger {
    private final int burgerId;
    private final String burgerName;
    private final double burgerPrice;
    private final String burgerDescription;

    public Burger(int burgerId, String burgerName, double burgerPrice, String burgerDescription) {
        this.burgerId = burgerId;
        this.burgerName = burgerName;
        this.burgerPrice = burgerPrice;
        this.burgerDescription = burgerDescription;
    }

    public String getBurgerName() {
        return burgerName;
    }

    public double getBurgerPrice() {
        return burgerPrice;
    }

    @Override // Object 클래스의 toString() 메서드를 재정의
    public String toString() { // 객체를 문자열로 표현하는 방법을 정의해주어서 버거 종류 출력시 코드 간결화
        return burgerId + ". " + burgerName + " | W " + burgerPrice + " | " + burgerDescription;
    }
}
