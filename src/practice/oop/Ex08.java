package practice.oop;

public class Ex08 {
    public static void main(String[] args) {
        Circle c = new Circle(1);
        System.out.println("面積：" + c.getArea());
        System.out.println("円周：" + c.getCircumference());

        c.setRadius(2);
        System.out.println("---半径変更後---");
        System.out.println("面積：" + c.getArea());
        System.out.println("円周：" + c.getCircumference());

    }

    static class Circle {
        // 円周率：全インスタンス共通、変更禁止
        private static final double PI = 3.1415926;
        private double radius;

        public Circle() {
        }

        public Circle(double radius) {
            this.radius = radius;
        }

        /**
         * 円の面積を計算し返却
         *
         * @return 面積
         */
        public double getArea() {
            return PI * radius * radius;
        }

        /**
         * 円周の長さを計算し返却
         *
         * @return 円周
         */
        public double getCircumference() {
            return PI * radius * 2;
        }

        public double getRadius() {
            return radius;
        }

        public void setRadius(double radius) {
            this.radius = radius;
        }
    }
}