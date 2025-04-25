package Kiosk;

import java.util.HashMap;
import java.util.Optional;
import java.util.Scanner;

public class ShoppingCart {

    Scanner scanner = new Scanner(System.in);

    private final HashMap<String, Integer> shoppingCart = new HashMap<>();
    MenuItem menuItem;

    public ShoppingCart(MenuItem menuItem) {
        this.menuItem = menuItem;
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
                System.out.println(name + price + "원 | " + count + "개 | ");
            });

            System.out.println();
            System.out.println("[ TOTAL PRICE ]");
            System.out.println(totalPrice[0] + "원");
            break;
        }

        System.out.println();
        System.out.println("1. 주문     2. 메뉴판");
        int inputForOrderMenu = scanner.nextInt();
        scanner.nextLine();

        if (inputForOrderMenu == 1) {
            System.out.println("주문이 완료되었습니다. 금액은 " + totalPrice[0] + "원 입니다.");
            System.exit(0);
        } else if (inputForOrderMenu == 2) {
            return false;
        } else {
            throw new IllegalArgumentException("올바른 번호를 입력해주세요.");
        }
        return true;
    }
}
