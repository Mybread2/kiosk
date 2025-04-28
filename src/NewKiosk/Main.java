package NewKiosk;

public class Main {
    public static void main(String[] args) {
        BurgerMenu burgerMenu = new BurgerMenu();
        MainMenu mainMenu = new MainMenu();
        ShoppingCartList shoppingCart = new ShoppingCartList(burgerMenu);
        Order order = new Order(shoppingCart, burgerMenu);
        RunBurgerMenu printBurgerMenu = new RunBurgerMenu(burgerMenu, shoppingCart);
        RunMainMenu runMainMenu = new RunMainMenu(mainMenu, printBurgerMenu, shoppingCart, order);
        Kiosk kiosk = new Kiosk(runMainMenu);


        kiosk.runKiosk();
    }
}
