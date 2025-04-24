package Kiosk;

import java.util.Scanner;

public class Kiosk {
    Scanner scanner = new Scanner(System.in);

    MenuItem menuItem;
    Menu menu;

    public Kiosk(MenuItem menuItem, Menu menu) {
        this.menuItem = menuItem;
        this.menu = menu;

    }

    public void runKiosk() {
        menu.addMenuItems();
        menuItem.addMenuItems();

        typeOfFoodLoop :
        while (true) {

            System.out.println("[ MAIN MENU ]");
            for (int i = 0; i < menu.getTypeOfFood().size(); i++) {
                System.out.println((i + 1) + ". " + menu.getTypeOfFood().get(i));
            }
            System.out.println("0. 종료");
            System.out.println();

            while (true) {
                int selectTypeOfFood = scanner.nextInt();
                scanner.nextLine();

                switch (selectTypeOfFood) {
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
                        System.out.println("올바른 번호를 입력해주세요.");
                        continue;
                }
                break;
            }

            while (true) {
                System.out.println("[ SHAKESHACK MENU ]");
                for (int i = 0; i < menuItem.getDifferentTypeOfBurgurs().size(); i++) {
                    System.out.print((i + 1) + ". ");
                    for (int j = 0; j < menuItem.getDifferentTypeOfBurgurs().get(i).length; j++) {
                        System.out.print(menuItem.getDifferentTypeOfBurgurs().get(i)[j] + " | ");
                    }
                    System.out.println();
                }

                System.out.println("0. 뒤로가기");
                System.out.println();

                while (true) {
                    int selectNumber = scanner.nextInt();
                    scanner.nextLine();

                    if (selectNumber > 0 && selectNumber <= 4) {
                        for (int i = 0; i < selectNumber; i++) {
                            for (int j = 0; j < menuItem.getDifferentTypeOfBurgurs().get(i).length; j++) {
                                System.out.print(menuItem.getDifferentTypeOfBurgurs().get(i)[j] + " | ");
                            }
                            System.out.println();
                        }
                    } else if (selectNumber == 0) {
                        continue typeOfFoodLoop;
                    } else {
                        System.out.println("올바른 번호를 입력해주세요.");
                        continue;
                    }

                    break;
                }

                break;
            }
        }
    }
}
