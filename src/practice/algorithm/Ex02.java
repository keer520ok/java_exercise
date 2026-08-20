package practice.algorithm;

import java.util.Scanner;

/**
 * 1～nの中から、数字5を含まず5の倍数でもない数を列挙するクラス
 */
public class Ex02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("整数を入力：");
        int num = sc.nextInt();
        sc.close();

        for (int i = 1; i <= num; i++) {
            if (isValid(i)) System.out.println(i);
        }

    }

    /**
     * 対象の数が条件を満たすか判定
     *
     * @param num 判定する整数
     * @return 5を含まず、5の倍数でなければtrue
     */
    public static boolean isValid(int num) {
        // 5の倍数は除外
        if (num % 5 == 0) {
            return false;
        }
        // 数字の中に「5」が含まれるか確認
        while (num > 0) {
            if (num % 10 == 5) return false;
            num = num / 10;
        }
        return true;
    }
}
