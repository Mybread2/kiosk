package Kiosk;

import java.util.Scanner;

public class CommandForSelectBurgers {

    Scanner scanner = new Scanner(System.in);

    MenuItem menuItem;
    Burger burger;

    public CommandForSelectBurgers(MenuItem menuItem) {
        this.menuItem = menuItem;
    }

    public void commandForSelectBurgers() {
        while (true) {
            int inputForSelectBurgers = scanner.nextInt();
            scanner.nextLine();

            while (true) {
                if (inputForSelectBurgers > 0 && inputForSelectBurgers <= menuItem.getTypeOfBurgers().size()) {
                    System.out.println("'" + burger.getMenuName() + " | " + burger.getMenuPrice() + "원 | " + burger.getMenuDescription() + "'");
                } else if (inputForSelectBurgers == 0) {
                    continue;
                } else {
                    throw new IllegalArgumentException("올바른 번호를 입력해주세요.");
                }
                break;
            }
            break;
        }
    }
}

