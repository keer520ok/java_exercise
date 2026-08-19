package practice.basic;

import java.util.Scanner;

/**
 * 座標(x,y)から点の位置を判定するクラス
 */
public class Ex10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("x を入力：");
        double x = sc.nextDouble();
        System.out.print("y を入力：");
        double y = sc.nextDouble();
        sc.close();

        String result = judgePoint(x, y);
        System.out.println("判定結果：" + result);
    }

    /**
     * 座標点の位置判定メソッド
     */
    public static String judgePoint(double x, double y) {
        if (x == 0 && y == 0) return "原点";
        if (x == 0) return "y軸";
        if (y == 0) return "x軸";

        if (x > 0 && y > 0) return "第1象限";
        else if (x < 0 && y > 0) return "第2象限";
        else if (x < 0 && y < 0) return "第3象限";
        else return "第4象限";
    }
}
