package NewKiosk;

import java.util.HashMap;

public class ShoppingCartList {

    private final HashMap<String,Integer> shoppingCart = new HashMap<>();

    BurgerMenu burgerMenu;

    public ShoppingCartList(BurgerMenu burgerMenu) {
        this.burgerMenu = burgerMenu;
    }

    public HashMap<String, Integer> getBurgerHashMap() {
        return shoppingCart;
    }

    public void addBurger(String burgerName) {
        shoppingCart.put(burgerName, shoppingCart.getOrDefault(burgerName, 0) + 1);
    }
}
