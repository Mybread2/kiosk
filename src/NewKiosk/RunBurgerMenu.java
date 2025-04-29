package NewKiosk;

import java.util.Scanner;

public class RunBurgerMenu {

    Scanner scanner = new Scanner(System.in);

    BurgerMenu burgerMenu;
    ShoppingCartList shoppingCartList;
    Burger burger;

    public RunBurgerMenu(BurgerMenu burgerMenu, ShoppingCartList shoppingCartList) {
        this.burgerMenu = burgerMenu;
        this.shoppingCartList = shoppingCartList;
    }

    public void runBurgerMenu() {
        System.out.println("[ BURGER MENU ]");
        for (Burger burger : burgerMenu.getBurgers()) {
            System.out.println(burger.toString());
        }
        System.out.println("0. 뒤로가기");

        while (true) {
            int inputForBurgerMenu = scanner.nextInt();

            if (inputForBurgerMenu > 0 && inputForBurgerMenu <= burgerMenu.getBurgers().size()) {
                Burger selectedBurger = burgerMenu.getBurgers().get(inputForBurgerMenu - 1); // 선택한 버거 객체 가져오기
                System.out.println(selectedBurger); // toString() 호출로 버거 정보 출력
                System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");

                System.out.println("1. 확인       2. 취소");

                while (true) {
                    int inputForBurgerAddToCart = scanner.nextInt();

                    if (inputForBurgerAddToCart == 1) {
                        shoppingCartList.addBurger(selectedBurger.getBurgerName());
                        System.out.println(selectedBurger.getBurgerName()+ " 이 장바구니에 추가되었습니다.");
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
