package Kiosk;

import java.util.Scanner;

public class CommandForSelectBurgers {

    Scanner scanner = new Scanner(System.in);

    ShoppingCart shoppingCart;
    MenuItem menuItem;
    Burger burger;

    public CommandForSelectBurgers(MenuItem menuItem, ShoppingCart shoppingCart) {
        this.menuItem = menuItem;
        this.shoppingCart = shoppingCart;
    }

    public boolean commandForSelectBurgers() {

        int inputForSelectBurgers = scanner.nextInt();
        scanner.nextLine();

        while (true) {
            if (inputForSelectBurgers > 0 && inputForSelectBurgers <= menuItem.getTypeOfBurgers().size()) {
                this.burger = menuItem.getTypeOfBurgers().get(inputForSelectBurgers - 1);
                System.out.println("'" + burger.getMenuName() + " | " + burger.getMenuPrice() + "원 | " + burger.getMenuDescription() + "'");
                break;
            } else if (inputForSelectBurgers == 0) {
                return false;
            } else {
                throw new IllegalArgumentException("올바른 번호를 입력해주세요.");
            }
        }

        System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
        System.out.println("1. 확인     2. 취소");

        while (true) {
            int inputForBurgerAddToCart = scanner.nextInt();

            if (inputForBurgerAddToCart == 1) {
                shoppingCart.addBurger(burger.getMenuName());
                System.out.println(burger.getMenuName() + "이 장바구니에 추가되었습니다.");
                return true;
            } else if (inputForBurgerAddToCart == 2) {
                return false;
            } else {
                throw new IllegalArgumentException("올바른 번호를 입력해주세요.");
            }
        }

    }
}

