package practice.basic;

import java.util.Scanner;

/**
 * 3辺の長さから三角形の種類を判定するクラス
 * 判定種別：正三角形・二等辺三角形・直角三角形・普通の三角形・無効（三角形を作れない）
 * 三角形成立条件：任意の二辺の和 ＞ 残りの一辺
 */
public class Ex09 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("辺aを入力：");
        double a = sc.nextDouble();
        System.out.print("辺bを入力：");
        double b = sc.nextDouble();
        System.out.print("辺cを入力：");
        double c = sc.nextDouble();
        sc.close();

        String result = judgeTriangle(a, b, c);
        System.out.println("判定結果：" + result);
    }

    /**
     * 三角形判定メソッド
     */
    public static String judgeTriangle(double a, double b, double c) {
        // 値が0以下の場合無効
        if (a <= 0 || b <= 0 || c <= 0) {
            return "無効";
        }
        // 三角形成立条件：任意の二辺の和 ＞ 残りの一辺
        if (!((a + b > c) && (a + c > b) && (b + c > a))) {
            return "無効";
        }

        // 許容誤差（doubleの誤差回避用）
        double eps = 1e-6;
        boolean isEquilateral = Math.abs(a - b) < eps && Math.abs(b - c) < eps;
        if (isEquilateral) return "正三角形";

        boolean isIsosceles = Math.abs(a - b) < eps
                || Math.abs(a - c) < eps
                || Math.abs(b - c) < eps;
        if (isIsosceles) return "二等辺三角形";

        // ピタゴラスの定理
        boolean isRight = Math.abs(a * a + b * b - c * c) < eps
                || Math.abs(a * a + c * c - b * b) < eps
                || Math.abs(b * b + c * c - a * a) < eps;
        if (isRight) return "直角三角形";

        return "普通の三角形";

    }
}
