package Kiosk;

public class SelectBurger {

    MenuItem menuItem;
    CommandForSelectBurgers commandForSelectBurgers;

    public SelectBurger(MenuItem menuItem, CommandForSelectBurgers commandForSelectBurgers) {
        this.menuItem = menuItem;
        this.commandForSelectBurgers = commandForSelectBurgers;
    }

    public void selectBurger() {
        System.out.println("[ BURGERS MENU ]");
        menuItem.getTypeOfBurgers().stream()
                .forEach(burger ->{
                    System.out.println(burger.getBurgerId() + ". " + burger.getMenuName() + " | " + burger.getMenuPrice() + "원 | " + burger.getMenuDescription());
                });

        System.out.println("0. 뒤로가기");
        System.out.println();

        while (true) {
            try {
                boolean result = commandForSelectBurgers.commandForSelectBurgers();
                if (!result) {
                    return;
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                continue;
            }
            break;
        }

    }
}
