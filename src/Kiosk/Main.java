package Kiosk;

public class Main {
    public static void main(String[] args) {
        MenuItem menuItem = new MenuItem();
        Menu menu = new Menu();
        CommandForSelectBurgers commandForSelectBurgers = new CommandForSelectBurgers(menuItem);
        CommandForSelectMenu commandForSelectMenu = new CommandForSelectMenu(menu);
        SelectMenu selectMenu = new SelectMenu(menu, commandForSelectMenu);
        SelectBurger selectBurger = new SelectBurger(menuItem, commandForSelectBurgers);


        Kiosk kiosk = new Kiosk(menuItem, menu, selectMenu, selectBurger);

        mainLoop:
        while (true) {
            kiosk.runKiosk();
        }
    }
}