package NewKiosk;

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

    @Override
    public String toString() {
        return burgerId + ". " + burgerName + " | W " + burgerPrice + " | " + burgerDescription;
    }
}
