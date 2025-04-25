package Kiosk;

public class Kiosk {

    MenuItem menuItem;
    Menu menu;
    SelectMenu selectMenu;
    SelectBurger selectBurger;

    public Kiosk(MenuItem menuItem, Menu menu, SelectMenu selectMenu, SelectBurger selectBurger) {
        this.menuItem = menuItem;
        this.menu = menu;
        this.selectMenu = selectMenu;
        this.selectBurger = selectBurger;

    }

    public void runKiosk() {

        while (true) {
            selectMenu.selectMenu();
            selectBurger.selectBurger();
        }

    }
}
