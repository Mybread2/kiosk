package Kiosk;

public class Main {
    public static void main(String[] args) {
        MenuItem menuItem = new MenuItem();
        Menu menu = new Menu();
        SelectMenu selectMenu = new SelectMenu(menu);
        SelectBurger selectBurger = new SelectBurger(menuItem);
        Kiosk kiosk = new Kiosk(menuItem, menu, selectMenu, selectBurger);

        while (true) {
            kiosk.runKiosk();
        }
    }
}