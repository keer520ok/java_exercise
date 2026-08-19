package practice.basic;

import java.util.Scanner;

/**
 * 階段式電気料金を計算するクラス
 */
public class Ex08 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("使用電力量を入力してください：");
        int usage = sc.nextInt();
        sc.close();

        double cost = calcCost(usage);
        System.out.println("総電気料金 cost：" + cost);
    }

    /**
     * 電気料金計算メソッド
     *
     * @param usage 使用電力量
     * @return 総料金
     */
    public static double calcCost(int usage) {
        if (usage <= 100) {
            return usage * 0.5;
        } else if (usage <= 200) {
            // 100度まで + 100を超えた分
            return 100 * 0.5 + (usage - 100) * 0.8;
        } else {
            // 100度まで + 100～200度 + 200を超えた分
            return 100 * 0.5 + 100 * 0.8 + (usage - 200) * 1.2;
        }
    }
}
