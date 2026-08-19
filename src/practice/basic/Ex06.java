package practice.basic;

import java.util.Scanner;

/**
 * コラッツ関数の1ステップ計算を行うクラス
 * 奇数：3n + 1、偶数：n / 2
 */
public class Ex06 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("正整数 n を入力してください：");
        int n = sc.nextInt();
        int result;

        if (n % 2 == 1) {
            // 奇数
            result = 3 * n + 1;
        } else {
            // 偶数
            result = n / 2;
        }

        System.out.println(result);
        sc.close();
    }
}
