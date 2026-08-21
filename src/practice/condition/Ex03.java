package practice.condition;

/**
 * 2つの長方形の面積を比較する練習
 */
public class Ex03 {
    public static void main(String[] args) {
        double s1 = getArea(1, 2);
        double s2 = getArea(3, 4);

        compareRectangle(s1, s2);

    }

    /**
     * ２つの長方形の面積を比較し結果を出力するメソッド
     *
     * @param s1 長方形の面積
     * @param s2 長方形の面積
     */
    private static void compareRectangle(double s1, double s2) {
        if (s1 > s2) System.out.println("1番目の長方形の面積が大きい");
        if (s1 < s2) System.out.println("2番目の長方形の面積が大きい");
        else System.out.println("二つの長方形の面積は等しい");
    }

    /**
     * 長方形の面積を計算して返す
     *
     * @param width  長方形の幅
     * @param height 長方形の高さ
     * @return 計算した長方形の面積
     */
    private static double getArea(double width, double height) {
        return width * height;
    }

}
