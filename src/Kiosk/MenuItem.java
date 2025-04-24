package Kiosk;

import java.util.ArrayList;
import java.util.List;

public class MenuItem {
    private final List<String[]> typeOfBurgurs = new ArrayList<>();{
        typeOfBurgurs.add(new String[]{"ShackBurger  ", "W 6.9", "토마토, 양상추, 쉑소스가 토핑된 치즈버거"});
        typeOfBurgurs.add(new String[]{"SmokeShack   ", "W 8.9", "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"});
        typeOfBurgurs.add(new String[]{"Cheeseburger ", "W 6.9", "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"});
        typeOfBurgurs.add(new String[]{"Hamburger    ", "W 5.4", "비프패티를 기반으로 야채가 들어간 기본버거"});
    }

    public List<String[]> getTypeOfBurgurs() {
        return typeOfBurgurs;
    }
}

