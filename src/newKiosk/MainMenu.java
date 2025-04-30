package newKiosk;

import java.util.List;

// 메인 메뉴를 관리하는 클래스
public class MainMenu {

    private final List<String> mainMenu = List.of("Burgers", "Drinks", "Desserts");

    public List<String> getMainMenu() {
        return mainMenu;
    }
}
