package Kiosk;

import java.util.Scanner;

public class CommandForSelectBurgers {

    Scanner scanner = new Scanner(System.in);

    MenuItem menuItem;

    public CommandForSelectBurgers(MenuItem menuItem) {
        this.menuItem = menuItem;
    }

    public void commandForSelectBurgers(){
        while (true) {
            int inputForSelectBurgers = scanner.nextInt();
            scanner.nextLine();

            if (inputForSelectBurgers > 0 && inputForSelectBurgers <= 4) {
                System.out.print("선택된 메뉴 : ");
                for (int i = 0; i < inputForSelectBurgers; i++) {
                    for (int j = 0; j < menuItem.getTypeOfBurgers().get(i).length; j++) {
                        System.out.print(menuItem.getTypeOfBurgers().get(i)[j] + " | ");
                    }
                    System.out.println();
                }
            } else if (inputForSelectBurgers == 0) {
                return;
            } else {
                throw new IllegalArgumentException("올바른 번호를 입력해주세요.");
            }

            break;
        }
    }
}
