package Kiosk;

import java.util.ArrayList;
import java.util.List;

public class Menu {

    private final List<String> typeOfFood = new ArrayList<>();{
        typeOfFood.add("Burgers");
        typeOfFood.add("Drinks");
        typeOfFood.add("Desserts");
    }
    public List<String> getTypeOfFood() {
        return typeOfFood;
    }

}
