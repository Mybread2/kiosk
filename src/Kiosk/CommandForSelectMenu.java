package Kiosk;

import java.util.Scanner;

public class CommandForSelectMenu {

    Scanner scanner = new Scanner(System.in);

    Menu menu;

    public CommandForSelectMenu(Menu menu) {
        this.menu = menu;
    }

    public void commandForSelectMenu() {
        while (true) {
            int inputForSelectTypeOfFood = scanner.nextInt();
            scanner.nextLine();

            switch (inputForSelectTypeOfFood) {
                case 1:
                    break;
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
                    throw new IllegalArgumentException("올바른 번호를 입력해주세요.");
            }
            break;
        }
    }
}
