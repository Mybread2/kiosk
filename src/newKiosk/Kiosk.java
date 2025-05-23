package newKiosk;

import java.util.Scanner;
import java.util.stream.IntStream;


// 모든 기능들을 모아준 클래스
public class Kiosk {
    private final Scanner scanner = new Scanner(System.in);
    private final MainMenu mainMenu;
    private final BurgerMenu burgerMenu;
    private final ShoppingCart shoppingCartList;
    private final Order order;

    public Kiosk() {
        this.mainMenu = new MainMenu();
        this.burgerMenu = new BurgerMenu();
        this.shoppingCartList = new ShoppingCart();
        this.order = new Order(shoppingCartList, burgerMenu, scanner);

    }

    public void runKiosk() {
        while (true) {
            showMainMenu();
        }
    }

    private int getChoice() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("숫자만 입력해주세요.");
            }
        }
    }

    private void showMainMenu() {
        // 메인 메뉴 출력
        System.out.println("[ MAIN MENU ]");
        IntStream.range(0, mainMenu.getMainMenu().size()) // 시작값 0부터 종료값 3까지의 정수 스트림을 생성
                .forEach(i -> System.out.println((i + 1) + ". " + mainMenu.getMainMenu().get(i))); // 스트림의 각 요소에 대해 작업을 실행, i는 현재 처리 중인 스트림의 인덱스
        System.out.println("0. 종료");

        // 장바구니가 있는 경우 추가 메뉴 표시
        if (!shoppingCartList.getShoppingCart().isEmpty()) {
            System.out.println("[ ORDER MENU ]");
            System.out.println("4. Orders");
            System.out.println("5. Cancel");
        }

        // 메인 메뉴 입력 처리
        while (true) {
            int choice = getChoice();

            if (shoppingCartList.getShoppingCart().isEmpty() && (choice == 4 || choice == 5)) {
                System.out.println("올바른 번호를 입력해주세요.");
                continue;
            }

            switch (choice) {
                case 1 -> {
                    showBurgerMenu();
                    return;
                }
                case 2, 3 -> System.out.println("준비 중인 메뉴입니다.");
                case 4 -> {
                    order.order();
                    return;
                }
                case 5 -> {
                    shoppingCartList.clearShoppingCart();
                    return;
                }
                case 0 -> {
                    scanner.close();
                    System.exit(0);
                }
                default -> System.out.println("올바른 번호를 입력해주세요.");
            }
        }
    }

    private void showBurgerMenu() {
        // 버거 메뉴 출력
        System.out.println("[ BURGER MENU ]");
        burgerMenu.getBurgers().forEach(System.out::println); // 리스트를 가져와서 .forEach(컬렉션의 각 요소에 대해 작업을 수행) 해준다.
        System.out.println("0. 뒤로가기");                      // System.out::println 는 객체::메소드 형태로 사용, Burger 클래스의 toString()을 정의해서 사용할 수 있다.

        // 버거 메뉴 입력 처리
        while (true) {
            int choice = getChoice();

            if (choice > 0 && choice <= burgerMenu.getBurgers().size()) {
                Burger selectedBurger = burgerMenu.getBurgers().get(choice - 1);
                System.out.println(selectedBurger);
                System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
                System.out.println("1. 확인       2. 취소");
                processAddToCart(selectedBurger);
                return;
            } else if (choice == 0) {
                return;
            } else {
                System.out.println("올바른 번호를 입력해주세요.");
            }
        }
    }

    // 장바구니에 추가해주는 클래스
    private void processAddToCart(Burger burger) {
        while (true) {
            switch (getChoice()) {
                case 1 -> {
                    shoppingCartList.addBurger(burger.getBurgerName());
                    System.out.println(burger.getBurgerName() + " 이 장바구니에 추가되었습니다.");
                    return;
                }
                case 2 -> {
                    return;
                }
                default -> System.out.println("올바른 번호를 입력해주세요.");
            }
        }
    }
}