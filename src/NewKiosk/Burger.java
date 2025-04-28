package NewKiosk;

public class Burger {
    int burgerId;
    String burgerName;
    double burgerPrice;
    String burgerDescription;

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
}
