package Kiosk;

import java.util.Scanner;

public class SelectMenu {

    Scanner scanner = new Scanner(System.in);

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

            int inputForOrder = scanner.nextInt();
            scanner.nextLine();

            if (inputForOrder == 4) {
                while (true) {
                    try {
                        boolean order = shoppingCart.printCart();
                        if (!order) {
                            return;
                        }
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                }
            }
        }

        while (true) {
            try {
                commandForSelectMenu.commandForSelectMenu();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                continue;
            }
            break;
        }

    }
}
