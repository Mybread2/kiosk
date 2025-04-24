package Kiosk;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddBurgersToCart {

    Scanner scanner = new Scanner(System.in);

    CommandForSelectBurgers commandForSelectBurgers;
    MenuItem menuItem;

    private final List<String> burgersInCart = new ArrayList<>();

    public AddBurgersToCart(CommandForSelectBurgers commandForSelectBurgers, MenuItem menuItem){
        this.commandForSelectBurgers = commandForSelectBurgers;
        this.menuItem = menuItem;
    }

    public void addBurgersToCart(int inputForSelectBurgers){
        for(int i = inputForSelectBurgers;;){
            for(int j = 0; j < menuItem.getTypeOfBurgers().get(i).length; j++){
                System.out.println("'" + menuItem.getTypeOfBurgers().get(i)[j] + "'");

            }
            break;
        }

        System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
        System.out.println("1. 확인         2. 취소");

        int inputForConfirmOrCancel = scanner.nextInt();
        scanner.nextLine();

        switch (inputForConfirmOrCancel){
            case 1 :
                burgersInCart.add(menuItem.getTypeOfBurgers().get(inputForSelectBurgers)[0]);
                break;
            case 2 :
                return;
            default:
                throw new IllegalStateException("올바른 번호를 입력해주세요 ");
        }
    }
}
