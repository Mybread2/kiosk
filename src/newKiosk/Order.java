package newKiosk;

import java.util.Optional;
import java.util.Scanner;

// 장바구니에 저장된 메뉴들을 주문하고 총합을 계산하는 클래스
public class Order {
    private final Scanner scanner;
    private final ShoppingCart shoppingCartList;
    private final BurgerMenu burgerMenu;

    public Order(ShoppingCart shoppingCartList, BurgerMenu burgerMenu, Scanner scanner) {
        this.shoppingCartList = shoppingCartList;
        this.burgerMenu = burgerMenu;
        this.scanner = scanner;
    }

    // 문자열을 입력받았을 때 예외처리를 해주는 메서드
    private int getIntegerInput(String errorMessage) {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println(errorMessage);
            }
        }
    }

    public void order() {
        System.out.println("아래와 같이 주문하시겠습니까?");
        System.out.println(" [ ORDER ]");

        double totalPrice = 0.0;

        // Map의 Key(버거 이름들)을 순회하는 향상된 for문
        for (String burgerName : shoppingCartList.getShoppingCart().keySet()) {
            // 현재 버거의 주문 수량을 가져오고
            int count = shoppingCartList.getShoppingCart().get(burgerName);
            // 버거 이름으로 실제 버거 객체를 찾아서 Optional로 반환 (null이 반환될 수도 있기에 사용)
            Optional<Burger> burger = burgerMenu.findBurgerByName(burgerName);

            // Optional애서 버거 객체가 존재하는지 확인
            if (burger.isPresent()) {
                // 찾은 버거 객체에서 가격 정보를 가져온다.
                double price = burger.get().getBurgerPrice();
                totalPrice += price * count;
                System.out.println(burgerName + " | W " + price + " | " + count + "개");
            }
        }

        System.out.println();
        System.out.println("[ TOTAL ]");
        System.out.println("W " + totalPrice);
        System.out.println();

        System.out.println("1. 주문         2. 메뉴판");

        while (true) {
            int inputForOrder = getIntegerInput("숫자만 입력해주세요.");

            if (inputForOrder == 1) {
                System.out.println();
                // 모든 할인 타입을 순회하면서 정보 출력
                for (DiscountOperation.DiscountType discountType : DiscountOperation.DiscountType.values()) {
                    System.out.println(discountType.getNumber() + ". " + discountType.getCategory() + " : " + discountType.getDiscountRate() + "%");
                }

                while (true) {
                    int inputForDiscount = getIntegerInput("숫자만 입력해주세요.");
                    try {
                        // 입력된 번호로 해당하는 할인 타입을 찾아준다.
                        DiscountOperation.DiscountType selectedDiscount = DiscountOperation.DiscountType.findByNumber(inputForDiscount);
                        // 선택된 할인률을 총 금액에 적용
                        totalPrice = selectedDiscount.applyDiscount(totalPrice);

                        System.out.println();
                        System.out.println("주문이 완료되었습니다. 금액은 W " + totalPrice + " 입니다.");
                        System.out.println();
                        shoppingCartList.clearShoppingCart();
                        return;
                    } catch (IllegalArgumentException e) {
                        System.out.println("올바른 번호를 입력해주세요.");
                    }
                }
            } else if (inputForOrder == 2) {
                return;
            } else {
                System.out.println("1 또는 2만 입력 가능합니다.");
            }
        }
    }
}