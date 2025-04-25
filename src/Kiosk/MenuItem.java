package Kiosk;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class MenuItem {
    private final List<Burger> typeOfBurgurs = new ArrayList<>();

    {
        typeOfBurgurs.add(new Burger(1,"ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        typeOfBurgurs.add(new Burger(2,"SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        typeOfBurgurs.add(new Burger(3,"Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        typeOfBurgurs.add(new Burger(4,"Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거"));
    }

    public List<Burger> getTypeOfBurgers() {
        return typeOfBurgurs;
    }

    public Optional<Burger> findBurgerByName(String burgerName){
        return typeOfBurgurs.stream()
                .filter(burger -> burger.getMenuName().equals(burgerName))
                .findFirst();

    }
}

