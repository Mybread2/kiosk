package NewKiosk;

import java.util.Optional;
import java.util.Scanner;

public class Order {

    Scanner scanner = new Scanner(System.in);

    ShoppingCartList shoppingCartList;
    BurgerMenu burgerMenu;

    public Order(ShoppingCartList shoppingCartList, BurgerMenu burgerMenu) {
        this.shoppingCartList = shoppingCartList;
        this.burgerMenu = burgerMenu;
    }

    public void order(){
        System.out.println("아래와 같이 주문하시겠습니까?");
        System.out.println(" [ ORDER ]");

        final double[] totalPrice = {0.0};

        for (String burgerName : shoppingCartList.getBurgerHashMap().keySet()) {
            int count = shoppingCartList.getBurgerHashMap().get(burgerName);
            Optional<Burger> burger = burgerMenu.findBurgerByName(burgerName);

            burger.ifPresent(burger1 -> {
                double price = burger1.getBurgerPrice();
                totalPrice[0] += price * count;
                System.out.println(burgerName + " | " + price + "원 | " + count + "개 | ");
            });
        }

        System.out.println();
        System.out.println("[ TOTAL ]");
        System.out.println("W " + totalPrice[0]);
        System.out.println();

        System.out.println("1. 주문         2. 메뉴판");

        while(true) {
            int inputForOrder = scanner.nextInt();

            if (inputForOrder == 1){
                System.out.println("주문이 완료되었습니다. 금액은 W " + totalPrice[0] + "입니다.");
                shoppingCartList.getBurgerHashMap().clear();
                break;
            } if (inputForOrder == 2){
                break;
            } else {
                System.out.println("올바른 번호를 입력해주세요.");
            }
        }
    }
}
