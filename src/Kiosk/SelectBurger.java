package Kiosk;

public class SelectBurger {

    MenuItem menuItem;
    CommandForSelectBurgers commandForSelectBurgers;
    AddBurgersToCart addBurgersToCart;

    public SelectBurger(MenuItem menuItem, CommandForSelectBurgers commandForSelectBurgers, AddBurgersToCart addBurgersToCart) {
        this.menuItem = menuItem;
        this.commandForSelectBurgers = commandForSelectBurgers;
        this.addBurgersToCart = addBurgersToCart;
    }

    public void selectBurger() {
            System.out.println("[ SHAKESHACK MENU ]");
            for (int i = 0; i < menuItem.getTypeOfBurgers().size(); i++) {
                System.out.print((i + 1) + ". ");
                for (int j = 0; j < menuItem.getTypeOfBurgers().get(i).length; j++) {
                    System.out.print(menuItem.getTypeOfBurgers().get(i)[j] + " | ");
                }
                System.out.println();
            }

            System.out.println("0. 뒤로가기");
            System.out.println();

            while(true) {
                try {
                    commandForSelectBurgers.commandForSelectBurgers();
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                    continue;
                }
                break;
            }
    }
}
