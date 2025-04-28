package NewKiosk;

import java.util.Scanner;

public class RunMainMenu {

    Scanner scanner = new Scanner(System.in);

    MainMenu mainmenu;
    RunBurgerMenu runBurgerMenu;
    ShoppingCartList shoppingCartList;
    Order order;

    public RunMainMenu(MainMenu mainmenu, RunBurgerMenu printBurgerMenu, ShoppingCartList shoppingCartList, Order order) {
        this.mainmenu = mainmenu;
        this.runBurgerMenu = printBurgerMenu;
        this.shoppingCartList = shoppingCartList;
        this.order = order;
    }

    public void runMainMenu() {
        System.out.println("[ MAIN MENU ]");
        for (int i = 0; i < mainmenu.mainMenu.size(); i++) {
            System.out.println((i + 1) + ". " + mainmenu.mainMenu.get(i));
        }
        System.out.println("0. 종료");

        if (!shoppingCartList.getBurgerHashMap().isEmpty()) {
            System.out.println();
            System.out.println("[ ORDER MENU ] ");
            System.out.println("4. Orders");
            System.out.println("5. Cancel");
        }

        while (true) {
            int inputForMainMenu = scanner.nextInt();
            if (shoppingCartList.getBurgerHashMap().isEmpty() && (inputForMainMenu == 4 || inputForMainMenu == 5)){
                System.out.println("올바른 번호를 입력해주세요.");
                continue;
            }

            switch (inputForMainMenu) {
                case 1:
                    runBurgerMenu.runBurgerMenu();
                    break;
                case 2, 3:
                    System.out.println("준비 중인 메뉴입니다.");
                    continue;
                case 4:
                    order.order();
                    break;
                case 5:
                    shoppingCartList.getBurgerHashMap().clear();
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("올바른 번호를 입력해주세요.");
                    continue;
            }
            break;
        }
    }
}
