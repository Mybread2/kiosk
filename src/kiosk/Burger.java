package kiosk;

public class Burger {

    private final int burgerId;
    private final String menuName;
    private final double menuPrice;
    private final String menuDescription;


    public Burger(int burgerId, String menuName, double menuPrice, String menuDescription) {
        this.burgerId = burgerId;
        this.menuName = menuName;
        this.menuPrice = menuPrice;
        this.menuDescription = menuDescription;
    }

    public String getMenuName() {
        return menuName;
    }

    public double getMenuPrice() {
        return menuPrice;
    }

    public String getMenuDescription() {
        return menuDescription;
    }

    public int getBurgerId() {
        return burgerId;
    }
}
