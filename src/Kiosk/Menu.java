package Kiosk;

import java.util.ArrayList;
import java.util.List;

public class Menu {

    private final List<String> typeOfFood = new ArrayList<>();

    public List<String> getTypeOfFood() {
        return typeOfFood;
    }

    public void addTypeOfFood() {
        typeOfFood.add("Burgers");
        typeOfFood.add("Drinks");
        typeOfFood.add("Desserts");
    }


}
