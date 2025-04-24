package Kiosk;

public class Main {
    public static void main(String[] args) {
        MenuItem menuItem = new MenuItem();
        Menu menu = new Menu();
        CommandForSelectBurgers commandForSelectBurgers = new CommandForSelectBurgers(menuItem);
        CommandForSelectMenu commandForSelectMenu = new CommandForSelectMenu(menu);
        AddBurgersToCart addBurgersToCart = new AddBurgersToCart(commandForSelectBurgers, menuItem);
        SelectMenu selectMenu = new SelectMenu(menu, commandForSelectMenu);
        SelectBurger selectBurger = new SelectBurger(menuItem, commandForSelectBurgers, addBurgersToCart);


        Kiosk kiosk = new Kiosk(menuItem, menu, selectMenu, selectBurger);

        mainLoop :
        while (true) {
            kiosk.runKiosk();
        }
    }
}