# 키오스크 햄버거 주문 시스템

**자바 콘솔 기반 햄버거 키오스크 프로그램**  
버거 메뉴 확인 → 장바구니 추가 → 할인 적용 주문까지 전 과정 구현  

---

## 기능 요약

- **햄버거 메뉴 시스템**
  - ShackBurger, SmokeShack, Cheeseburger, Hamburger
  - 메뉴 설명과 가격 포함 출력

- **장바구니 기능**
  - 메뉴 선택 후 장바구니에 추가
  - 장바구니 확인 및 초기화 가능

- **할인 기능 지원**
  - 국가유공자 (10%), 군인 (5%), 학생 (3%), 일반 (0%)
  - 할인률 선택에 따라 총 금액 계산

- **안전한 데이터 처리**
  - 메뉴 및 장바구니는 `unmodifiable`, `Optional` 사용으로 안정성 강화

- **객체지향적 설계**
  - `Burger`, `BurgerMenu`, `ShoppingCartList`, `Order`, `Kiosk` 등 역할 분리 명확

---

## 📁 파일 구성
NewKiosk/ 
├── Burger.java // 버거 정보 (ID, 이름, 가격, 설명)
├── BurgerMenu.java // 버거 메뉴 리스트 및 조회 기능 
├── DiscountOperation.java// 할인 유형 및 로직 
├── ShoppingCartList.java // 장바구니 추가/조회/초기화 기능 
├── Order.java // 주문 전체 흐름 처리 (할인 적용 포함) 
├── MainMenu.java // 메인 메뉴 텍스트 출력 
├── Kiosk.java // 프로그램 실행 및 전체 플로우 제어 
└── Main.java // 진입점: main 메소드

---

## 실행 예시

[ MAIN MENU ]
1. Burgers
2. Drinks
3. Desserts
0. 종료

> 1

[ BURGER MENU ]
1. ShackBurger | W 6.9 | 토마토, 양상추, 쉑소스가 토핑된 치즈버거
2. SmokeShack  | W 6.9 | 베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거
3. Cheeseburger| W 6.9 | 포테이토 번과 비프패티, 치즈가 토핑된 치즈버거
4. Hamburger   | W 6.9 | 비프패티를 기반으로 야채가 들어간 기본버거
0. 뒤로가기

> 2

SmokeShack | W 6.9 | 베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거  
위 메뉴를 장바구니에 추가하시겠습니까?  
1. 확인       2. 취소

> 1  
SmokeShack 이 장바구니에 추가되었습니다.

[ MAIN MENU ]
1. Burgers
2. Drinks
3. Desserts
0. 종료
[ ORDER MENU ]
4. Orders
5. Cancel

> 4

아래와 같이 주문하시겠습니까?
[ ORDER ]
SmokeShack | W 6.9 | 1개

[ TOTAL ]
W 6.9

1. 주문         2. 메뉴판

> 1

1. 국가유공자 : 10%  
2. 군인       : 5%  
3. 학생       : 3%  
4. 일반       : 0%

> 2

주문이 완료되었습니다. 금액은 W 6.555 입니다.

