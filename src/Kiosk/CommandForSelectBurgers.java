package Kiosk;

import java.util.Scanner;

public class CommandForSelectBurgers {

    Scanner scanner = new Scanner(System.in);

    MenuItem menuItem;
    Burger burger;

    public CommandForSelectBurgers(MenuItem menuItem) {
        this.menuItem = menuItem;
    }

    public boolean commandForSelectBurgers() {

        int inputForSelectBurgers = scanner.nextInt();
        scanner.nextLine();



        while (true) {
            if (inputForSelectBurgers > 0 && inputForSelectBurgers <= menuItem.getTypeOfBurgers().size()) {
                System.out.println("'" + burger.getMenuName() + " | " + burger.getMenuPrice() + "원 | " + burger.getMenuDescription() + "'");
                return true;
            } else if (inputForSelectBurgers == 0) {
                return false;
            } else {
                throw new IllegalArgumentException("올바른 번호를 입력해주세요.");
            }
        }
    }

}

