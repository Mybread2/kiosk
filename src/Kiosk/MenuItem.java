package Kiosk;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuItem {

    public static void main(String[] args) {

        List<String[]> menuItems = new ArrayList<>();
        menuItems.add(new String[]{"ShackBurger  ", "W 6.9", "토마토, 양상추, 쉑소스가 토핑된 치즈버거"});
        menuItems.add(new String[]{"SmokeShack   ", "W 8.9", "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"});
        menuItems.add(new String[]{"Cheeseburger ", "W 6.9", "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"});
        menuItems.add(new String[]{"Hamburger    ", "W 5.4", "비프패티를 기반으로 야채가 들어간 기본버거"});

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("[ SHAKESHACK MENU ]");
            for (int i = 0; i < menuItems.size(); i++) {
                System.out.print((i + 1) + ". ");
                for (int j = 0; j < menuItems.get(i).length; j++) {
                    System.out.print(menuItems.get(i)[j] + " | ");
                }
                System.out.println();
            }
            System.out.println("0. 종료");
            System.out.println();

            int selectNumber = scanner.nextInt();

            if (selectNumber > 0) {
                for (int i = 0; i < selectNumber; i++) {
                    for (int j = 0; j < menuItems.get(i).length; j++) {
                        System.out.print(menuItems.get(i)[j] + " | ");
                    }
                    System.out.println();
                }
            } else if (selectNumber == 0) {
                System.out.println("프로그램을 종료합니다.");
                System.exit(0);
            }


            break;
        }


    }
}
