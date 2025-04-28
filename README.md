# Java Burger Kiosk

> Java로 개발한 햄버거 키오스크 시뮬레이션 프로그램입니다.

---

## 프로젝트 소개

- Java의 객체 지향 프로그래밍개념을 활용하여 키오스크 주문 시스템을 구현했습니다.
- 메뉴 선택, 장바구니 기능, 할인 기능 등을 구현했습니다.
- `Enum`, `Optional`, `HashMap`, 예외 처리 등 Java의 주요 기능을 활용했습니다.
- 기능별로 클래스를 나누는 것에 초점을 두어 진행했습니다.

---

## 프로젝트 구조

```plaintext
Kiosk/
├── Burger.java                // 버거 메뉴 데이터 클래스
├── Menu.java                  // 메인 메뉴 (버거/음료/디저트) 리스트
├── MenuItem.java              // 버거 리스트 및 검색 기능
├── DiscountOperation.java     // 할인 정책 관리 (Enum 사용)
├── ShoppingCart.java          // 장바구니 관리 및 주문 처리
├── SelectMenu.java            // 메인 메뉴 선택 및 출력
├── SelectBurger.java          // 버거 메뉴 선택 및 출력
├── CommandForSelectMenu.java  // 메인 메뉴 선택 관련 로직
├── CommandForSelectBurgers.java // 버거 선택 후 장바구니 추가 로직
├── Kiosk.java                 // 전체 키오스크 흐름 제어
└── Main.java                  // 프로그램 실행 진입점
