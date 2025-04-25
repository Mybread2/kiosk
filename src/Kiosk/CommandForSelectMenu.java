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
                    System.out.println("취소할 메뉴의 이름을 입력해주세요.");
                    while (true) {
                        String inputForCanCle = scanner.next();
                        if (!shoppingCart.getBurgerHashMap().containsKey(inputForCanCle)) {
                            System.out.println("올바른 메뉴명을 입력해주세요.");
                            continue;
                        } else if (shoppingCart.getBurgerHashMap().containsKey(inputForCanCle)) {
                            System.out.println(inputForCanCle + "가 삭제되었습니다.");
                            shoppingCart.getBurgerHashMap().remove(inputForCanCle);
                            break;
                        }
                        break;
                    }
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