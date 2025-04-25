package Kiosk;

public class Main {
    public static void main(String[] args) {
        MenuItem menuItem = new MenuItem();
        Menu menu = new Menu();
        DiscountOperation discountOperation = new DiscountOperation();
        ShoppingCart shoppingCart = new ShoppingCart(menuItem, discountOperation);
        CommandForSelectBurgers commandForSelectBurgers = new CommandForSelectBurgers(menuItem, shoppingCart);
        CommandForSelectMenu commandForSelectMenu = new CommandForSelectMenu(menu, shoppingCart);
        SelectMenu selectMenu = new SelectMenu(menu, commandForSelectMenu, shoppingCart);
        SelectBurger selectBurger = new SelectBurger(menuItem, commandForSelectBurgers);
        Kiosk kiosk = new Kiosk(menuItem, menu, selectMenu, selectBurger);

        kiosk.runKiosk();

    }
}