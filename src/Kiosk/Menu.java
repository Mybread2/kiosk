package Kiosk;

import java.util.ArrayList;
import java.util.List;

public class Menu {

    private final List<String> TypeOfFood = new ArrayList<>();

    public List<String> getTypeOfFood() {
        return TypeOfFood;
    }

    public void addMenuItems() {
        TypeOfFood.add("Burgers");
        TypeOfFood.add("Drinks");
        TypeOfFood.add("Desserts");
    }


}
