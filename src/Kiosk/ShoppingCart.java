package Kiosk;

import java.util.HashMap;
import java.util.Optional;
import java.util.Scanner;

public class ShoppingCart {

    Scanner scanner = new Scanner(System.in);

    private final HashMap<String, Integer> shoppingCart = new HashMap<>();

    MenuItem menuItem;
    DiscountOperation discountOperation;

    public ShoppingCart(MenuItem menuItem, DiscountOperation discountOperation) {
        this.menuItem = menuItem;
        this.discountOperation = discountOperation;
    }

    public HashMap<String, Integer> getBurgerHashMap() {
        return shoppingCart;
    }

    public void addBurger(String burgerName) {
        shoppingCart.put(burgerName, shoppingCart.getOrDefault(burgerName, 0) + 1);
    }

    public boolean printCart() {
        System.out.println("아래와 같이 주문하시겠습니까? ");
        System.out.println();
        System.out.println("[ Orders ]");

        final double[] totalPrice = {0.0};

        for (String name : shoppingCart.keySet()) {
            int count = shoppingCart.get(name);
            Optional<Burger> burgerOptional = menuItem.findBurgerByName(name);

            burgerOptional.ifPresent(burger -> {
                double price = burger.getMenuPrice();
                totalPrice[0] += price * count;
                System.out.println(name + " | " + price + "원 | " + count + "개 | ");
            });
        }
        System.out.println();
        System.out.println("[ TOTAL PRICE ]");
        System.out.println(totalPrice[0] + "원");
        System.out.println();
        System.out.println("1. 주문     2. 메뉴판");

        int inputForOrderMenu = scanner.nextInt();

        if (inputForOrderMenu == 1) {
            System.out.println("총 금액은 " + totalPrice[0] + "원 입니다.");
            System.out.println("1. 국가유공자 : 10%");
            System.out.println("2. 군인      : 5%");
            System.out.println("3. 학생      : 3%");
            System.out.println("4. 일반      : 0%");

            int inputForDiscount = scanner.nextInt();

            if (inputForDiscount > 0 && inputForDiscount <= 4) {
                int discountRate = DiscountOperation.DiscountType.getDiscountType(inputForDiscount);
                totalPrice[0] = totalPrice[0] * (100 - discountRate) / 100;
                System.out.println("주문이 완료되었습니다. 금액은 " + totalPrice[0] + "원 입니다.");
            } else {
                throw new IllegalArgumentException("올바른 번호를 입력해주세요.");
            }

            System.exit(0);
        } else if (inputForOrderMenu == 2) {
            return false;
        } else {
            throw new IllegalArgumentException("올바른 번호를 입력해주세요.");
        }
        return true;
    }
}
