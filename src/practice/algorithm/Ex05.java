package practice.algorithm;

import java.util.Scanner;

/**
 * 対象の数値がナルシシスティック数かどうかを判定する
 * 自冪数：n桁のナルシシスティック数が、自身の各桁の数字をn乗した総和と等しい数
 */
public class Ex05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("整数を入力してください：");
        int num = sc.nextInt();
        sc.close();

        if (isNarcissistic(num)) {
            System.out.println(num + " はナルシシスティック数です");
        } else {
            System.out.println(num + " はナルシシスティック数ではありません");
        }
    }

    /**
     * 対象の数値がナルシシスティック数かどうかを判定する
     * 自冪数：n桁のナルシシスティック数が、自身の各桁の数字をn乗した総和と等しい数
     *
     * @param number 判定対象の自然数
     * @return ナルシシスティック数の場合true、そうでない場合false
     */
    public static boolean isNarcissistic(int number) {
        // 0以下は自然数の定義に含まれないため、ナルシシスティック数ではない
        if (number <= 0) {
            return false;
        }

        // 1. 数値の桁数nを算出
        int digitCount = 0;
        int temp = number;
        while (temp > 0) {
            temp /= 10;
            digitCount++;
        }

        // 2. 各桁の数字のn乗を計算し、総和を求める
        double sum = 0;
        temp = number; // 一時変数を元の値で再初期化
        while (temp > 0) {
            int digit = temp % 10;       // 最下位の桁を1桁分取り出す
            sum += Math.pow(digit, digitCount); // 桁のn乗を総和に加算
            temp /= 10;                  // 最下位の桁を削除して次の桁へ
        }

        // 3. 総和が元の数値と近似的に一致するか判定（浮動小数点誤差を許容）
        double eps = 1E-6;
        return Math.abs(sum - number) < eps;
    }
}
