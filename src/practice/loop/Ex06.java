package practice.loop;

import java.util.Scanner;

/**
 * 整数の各桁の数字の合計を計算するクラス
 * 引数が負数の場合、自動的に絶対値に変換して計算を実施
 */
public class Ex06 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("数字を入力：");
        int num = sc.nextInt();
        sc.close();

        System.out.println(calcDigitSum(num));

    }

    /**
     * 整数の各桁の値を合計して返す
     *
     * @param num 計算対象の整数（負数可）
     * @return 各桁の合計値
     */
    public static int calcDigitSum(int num) {
        int number = Math.abs(num);
        int sum = 0;
        while (number > 0) {
            int digit = number % 10;
            sum += digit;
            number = number / 10;
        }
        return sum;
    }
}
