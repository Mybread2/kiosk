package NewKiosk;

import java.util.Scanner;

public class RunBurgerMenu {

    Scanner scanner = new Scanner(System.in);

    BurgerMenu burgerMenu;
    ShoppingCartList shoppingCartList;

    public RunBurgerMenu(BurgerMenu burgerMenu, ShoppingCartList shoppingCartList) {
        this.burgerMenu = burgerMenu;
        this.shoppingCartList = shoppingCartList;
    }

    public void runBurgerMenu() {
        System.out.println("[ BURGER MENU ]");
        for (int i = 0; i < burgerMenu.getBurgers().size(); i++) {
            Burger burger = burgerMenu.getBurgers().get(i);
            System.out.println((i + 1) + ". " + burger.burgerName + " | " + burger.burgerPrice + " | " + burger.burgerDescription);
        }
        System.out.println("0. 뒤로가기");

        while (true) {
            int inputForBurgerMenu = scanner.nextInt();

            if (inputForBurgerMenu > 0 && inputForBurgerMenu <= burgerMenu.getBurgers().size()) {
                Burger selectedBurger = burgerMenu.getBurgers().get(inputForBurgerMenu - 1);
                System.out.println(selectedBurger.burgerName + " | W " + selectedBurger.burgerPrice + " | " + selectedBurger.burgerDescription);
                System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");

                System.out.println("1. 확인       2. 취소");

                while (true) {
                    int inputForBurgerAddToCart = scanner.nextInt();

                    if (inputForBurgerAddToCart == 1) {
                        shoppingCartList.addBurger(selectedBurger.burgerName);
                        System.out.println(selectedBurger.burgerName+ " 이 장바구니에 추가되었습니다.");
                        return;
                    } else if (inputForBurgerAddToCart == 2) {
                        return;
                    } else {
                        System.out.println("올바른 번호를 입력해주세요.");
                    }
                }

            } else if (inputForBurgerMenu == 0){
                return;
            } else {
                System.out.println("올바른 번호를 입력해주세요.");
            }
        }
    }
}
