package newKiosk;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

// 햄버거 키오스크의 장바구니를 관리하는 클래스 (메뉴 추가, 삭제, 조회 기능)
public class ShoppingCart {

    private final Map<String,Integer> shoppingCart = new HashMap<>();

    // 외부에서 Map을 직접 수정하지 못하도록 불변 Map 으로 반환
    public Map<String, Integer> getShoppingCart() {
        return Collections.unmodifiableMap(shoppingCart);
    }

    // 장바구니에 버거를 추가하는 메서드 (merge 메서드를 사용하여 동일 메뉴의 수량을 자동으로 증가)
    public void addBurger(String burgerName) {
        shoppingCart.merge(burgerName, 1, Integer::sum);
    }

    public void clearShoppingCart(){
        shoppingCart.clear();
    }
}
