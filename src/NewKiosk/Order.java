package NewKiosk;

import java.util.Optional;
import java.util.Scanner;

public class Order {
    private final Scanner scanner;
    private final ShoppingCartList shoppingCartList;
    private final BurgerMenu burgerMenu;

    public Order(ShoppingCartList shoppingCartList, BurgerMenu burgerMenu, Scanner scanner) {
        this.shoppingCartList = shoppingCartList;
        this.burgerMenu = burgerMenu;
        this.scanner = scanner;
    }

    private int getValidIntegerInput(String errorMessage) {
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

        for (String burgerName : shoppingCartList.getShoppingCart().keySet()) {
            int count = shoppingCartList.getShoppingCart().get(burgerName);
            Optional<Burger> burger = burgerMenu.findBurgerByName(burgerName);

            if (burger.isPresent()) {
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
            int inputForOrder = getValidIntegerInput("숫자만 입력해주세요.");

            if (inputForOrder == 1) {
                System.out.println();
                for (DiscountOperation.DiscountType discountType : DiscountOperation.DiscountType.values()) {
                    System.out.println(discountType.getNumber() + ". " + discountType.getCategory() + " : " + discountType.getDiscountRate() + "%");
                }

                while (true) {
                    int inputForDiscount = getValidIntegerInput("숫자만 입력해주세요.");
                    try {
                        DiscountOperation.DiscountType selectedDiscount = DiscountOperation.DiscountType.findByNumber(inputForDiscount);
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