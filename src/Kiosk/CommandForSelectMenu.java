package Kiosk;

import java.util.Scanner;

public class CommandForSelectMenu {

    Scanner scanner = new Scanner(System.in);

    Menu menu;
    ShoppingCart shoppingCart;

    public CommandForSelectMenu(Menu menu, ShoppingCart shoppingCart) {
        this.menu = menu;
        this.shoppingCart = shoppingCart;
    }

    public void commandForSelectMenu() {
        while (true) {

            int inputForSelectTypeOfFood = scanner.nextInt();

            if (!shoppingCart.getBurgerHashMap().isEmpty()) {
                if (inputForSelectTypeOfFood == 4) {
                    try {
                        boolean order = shoppingCart.printCart();
                        if (!order) {
                            return;
                        }
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                } else if (inputForSelectTypeOfFood == 5) {
                    shoppingCart.getBurgerHashMap().clear();
                }
            } else {
                switch (inputForSelectTypeOfFood) {
                    case 1:
                        return;
                    case 2:
                        System.out.println("아직 개발 중인 메뉴입니다.");
                        break;
                    case 3:
                        System.out.println("아직 개발중인 메뉴입니다.");
                        break;
                    case 0:
                        System.out.println("프로그램을 종료합니다.");
                        System.exit(0);
                    default:
                        System.out.println("올바른 번호를 입력해주세요.");
                        continue;
                }
            }
            break;
        }
    }
}