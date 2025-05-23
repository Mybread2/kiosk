package newKiosk;

// 할인율을 관리하는 클래스
public class DiscountOperation {

    public enum DiscountType {
        NationalMerit(1, "국가유공자", 10),
        Soldier(2, "군인", 5),
        Student(3, "학생", 3),
        General(4, "일반", 0);

        private final int number;
        private final String category;
        private final int discountRate;

        DiscountType(int number, String category, int discountRate) {
            this.category = category;
            this.discountRate = discountRate;
            this.number = number;
        }

        // 열거형 타입에서 번호로 할인 타입을 찾는 메서드
        public static DiscountType findByNumber(int number) {
            for (DiscountType type : values()) {
                if (type.getNumber() == number) {
                    return type;
                }
            }
            throw new IllegalArgumentException("유효하지 않은 할인 번호입니다.");
        }

        public int getNumber() {
            return number;
        }

        public String getCategory() {
            return category;
        }

        public int getDiscountRate() {
            return discountRate;
        }

        public double applyDiscount(double price) {
            return price * (100 - discountRate) / 100;
        }
    }
}
