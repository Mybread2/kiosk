package Kiosk;

public class SelectMenu {

    Menu menu;
    CommandForSelectMenu commandForSelectMenu;
    ShoppingCart shoppingCart;

    public SelectMenu(Menu menu, CommandForSelectMenu commandForSelectMenu, ShoppingCart shoppingCart) {
        this.menu = menu;
        this.commandForSelectMenu = commandForSelectMenu;
        this.shoppingCart = shoppingCart;
    }

    public void selectMenu() {
        System.out.println("[ MAIN MENU ]");
        for (int i = 0; i < menu.getTypeOfFood().size(); i++) {
            System.out.println((i + 1) + ". " + menu.getTypeOfFood().get(i));
        }
        System.out.println("0. 종료");
        System.out.println();

        if (!shoppingCart.getBurgerHashMap().isEmpty()) {
            System.out.println("[ ORDER MENU ]");
            System.out.println("4. Orders");
            System.out.println("5. CanCle");
            System.out.println();
        }

        commandForSelectMenu.commandForSelectMenu();
    }
}
