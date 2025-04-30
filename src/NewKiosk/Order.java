package NewKiosk;

import java.util.Optional;
import java.util.Scanner;

public class Order {

    private final Scanner scanner = new Scanner(System.in);
    private final ShoppingCartList shoppingCartList;
    private final BurgerMenu burgerMenu;
    private final DiscountOperation discountOperation;

    public Order(ShoppingCartList shoppingCartList, BurgerMenu burgerMenu, DiscountOperation discountOperation) {
        this.shoppingCartList = shoppingCartList;
        this.burgerMenu = burgerMenu;
        this.discountOperation = discountOperation;
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
            try {
                int inputForOrder = Integer.parseInt(scanner.nextLine().trim());

                if (inputForOrder == 1) {
                    System.out.println();
                    for (DiscountOperation.DiscountType discountType : DiscountOperation.DiscountType.values()){
                        System.out.println(discountType.getNumber() + ". " + discountType.getCategory() + " : " + discountType.getDiscountRate() + "%");
                    }

                    try {
                        int inputForDiscount = Integer.parseInt(scanner.nextLine().trim());

                        switch (inputForDiscount) {
                            case 1 -> totalPrice *= (double) (100 - DiscountOperation.DiscountType.NationalMerit.getDiscountRate()) / 100;
                            case 2 -> totalPrice *= (double) (100 - DiscountOperation.DiscountType.Soldier.getDiscountRate()) / 100;
                            case 3 -> totalPrice *= (double) (100 - DiscountOperation.DiscountType.Student.getDiscountRate()) / 100;
                            case 4 -> totalPrice *= (double) (100 - DiscountOperation.DiscountType.General.getDiscountRate()) / 100;
                            default ->
                                System.out.println("올바른 번호를 입력해주세요.");
                        }
                        System.out.println();
                        System.out.println("주문이 완료되었습니다. 금액은 W " + totalPrice + " 입니다.");
                        System.out.println();
                        shoppingCartList.clearShoppingCart();
                        break;

                    } catch (NumberFormatException e) {
                        System.out.println("숫자만 입력해주세요.");
                    }
                }
                if (inputForOrder == 2) {
                    break;
                } else {
                    System.out.println("1 또는 2만 입력 가능합니다.");
                }
            } catch (NumberFormatException e) {
                System.out.println("숫자만 입력해주세요.");
            }
        }
        }
    }

