package NewKiosk;

import java.util.*;

public class BurgerMenu {
    private final List<Burger> burgers = new ArrayList<>();{
        burgers.add(new Burger(1, "ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        burgers.add(new Burger(2, "SmokeShack", 6.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        burgers.add(new Burger(3, "Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        burgers.add(new Burger(4, "Hamburger", 6.9, "비프패티를 기반으로 야채가 들어간 기본버거"));
    }

    public List<Burger> getBurgers() {
        return Collections.unmodifiableList(burgers);
    }

    public Optional<Burger> findBurgerByName(String burgerName){
        return burgers.stream()
                .filter(burger -> burger.getBurgerName().equals(burgerName))
                .findFirst();
    }
}
