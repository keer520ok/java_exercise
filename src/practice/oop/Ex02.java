package practice.oop;

/**
 * 2つの長方形の面積を比較する練習
 */
public class Ex02 {
    public static void main(String[] args) {
        Rectangle r1 = new Rectangle(1, 2);
        Rectangle r2 = new Rectangle(3, 4);
        compareRectangle(r1, r2);
    }

    /**
     * 長方形クラス
     */
    static class Rectangle {
        private double width;
        private double height;

        public Rectangle(double width, double height) {
            this.width = width;
            this.height = height;
        }

        /**
         * 面積を計算して返す
         *
         * @return 長方形の面積
         */
        public double getArea() {
            return this.width * this.height;
        }
    }

    /**
     * ２つの長方形の面積を比較し結果を出力するメソッド
     *
     * @param r1 長方形1
     * @param r2 長方形2
     */
    private static void compareRectangle(Rectangle r1, Rectangle r2) {
        double s1 = r1.getArea();
        double s2 = r2.getArea();
        if (s1 > s2) System.out.println("1番目の長方形の面積が大きい");
        if (s2 < s1) System.out.println("2番目の長方形の面積が大きい");
        else System.out.println("二つの長方形の面積は等しい");
    }
}
