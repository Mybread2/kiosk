package kiosk;

public class DiscountOperation {

    public enum DiscountType {
        NationalMerit(10),
        Soldier(5),
        Student(3),
        General(0);

        private final int discountRate;

        DiscountType(int discountRate) {
            this.discountRate = discountRate;
        }

        public int getDiscountRate() {
            return discountRate;
        }

        public static int getDiscountType(int discountRate) {

            switch (discountRate) {
                case 1:
                    return NationalMerit.getDiscountRate();
                case 2:
                    return Soldier.getDiscountRate();
                case 3:
                    return Student.getDiscountRate();
                case 4:
                    return General.getDiscountRate();
                default:
                    throw new IllegalArgumentException("올바른 번호를 입력해주세요.");
            }
        }
    }
}
