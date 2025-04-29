package NewKiosk;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ShoppingCartList {

    private final Map<String,Integer> shoppingCart = new HashMap<>();

    public Map<String, Integer> getShoppingCart() {
        return Collections.unmodifiableMap(shoppingCart);
    }

    public void addBurger(String burgerName) {
        shoppingCart.merge(burgerName, 1, Integer::sum);
    }

    public void ClearShoppingCart(){
        shoppingCart.clear();
    }
}
