package Kiosk;

public class Main {
    public static void main(String[] args) {
        MenuItem menuItem = new MenuItem();
        Menu menu = new Menu();
        Kiosk kiosk = new Kiosk(menuItem, menu);

        kiosk.runKiosk();

    }
}