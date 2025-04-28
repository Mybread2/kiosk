package NewKiosk;

public class Kiosk {
    RunMainMenu runMainMenu;

    public Kiosk(RunMainMenu runMainMenu) {
        this.runMainMenu = runMainMenu;
    }

    public void runKiosk() {
        while (true) {
            runMainMenu.runMainMenu();
        }
    }
}
