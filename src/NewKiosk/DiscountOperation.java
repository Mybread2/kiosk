package NewKiosk;

public class DiscountOperation {

    public enum DiscountType {
        NationalMerit(1,"국가유공자", 10),
        Soldier(2,"군인", 5),
        Student(3,"학생", 3),
        General(4,"일반", 0);

        private final int number;
        private final String category;
        private final int discountRate;

        DiscountType(int number,String category, int discountRate) {
            this.category = category;
            this.discountRate = discountRate;
            this.number = number;
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

    }
}
