package Kiosk;

public class SelectMenu {

    Menu menu;
    CommandForSelectMenu commandForSelectMenu;

    public SelectMenu(Menu menu, CommandForSelectMenu commandForSelectMenu) {
        this.menu = menu;
        this.commandForSelectMenu = commandForSelectMenu;
    }

    public void selectMenu() {

        System.out.println("[ MAIN MENU ]");
        for (int i = 0; i < menu.getTypeOfFood().size(); i++) {
            System.out.println((i + 1) + ". " + menu.getTypeOfFood().get(i));
        }
        System.out.println("0. 종료");
        System.out.println();

        while (true) {
            try {
                commandForSelectMenu.commandForSelectMenu();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                continue;
            }
            break;
        }

    }
}
