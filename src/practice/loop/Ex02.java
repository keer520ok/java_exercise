package practice.loop;

import java.util.Scanner;

/**
 * 入力した範囲の中で、6と8両方で割り切れる数字の個数を集計するクラス
 */
public class Ex02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("num1 を入力：");
        int num1 = sc.nextInt();
        System.out.print("num2 を入力：");
        int num2 = sc.nextInt();
        sc.close();

        int max = Math.max(num1, num2);
        int min = Math.min(num1, num2);
        int count = 0;
        // 6 と 8 の最小公倍数を取得
        int lcm = lcmVal(6, 8);
        while (min <= max) {
            //公倍数ごとに数値を飛ばすので、全部ループするより処理速度が速い
            if (min % lcm == 0) {
                count++;
                min += lcm;
            } else min++;
        }
        System.out.println("条件に合う数字の個数：" + count);
    }

    /**
     * 最大公約数(GCD)を計算するメソッド
     * ユークリッド互除法を使用
     *
     * @param a 整数1
     * @param b 整数2
     * @return aとbの最大公約数
     */
    public static int gcd(int a, int b) {
        while (b != 0) {
            int n = a % b;
            a = b;
            b = n;
        }
        return a;
    }

    /**
     * 最小公倍数(LCM)を計算するメソッド
     * 最大公約数を利用して算出
     * a / gcd(a,b) * b の順で計算し、intのオーバーフローを軽減
     *
     * @param a 整数1
     * @param b 整数2
     * @return aとbの最小公倍数
     */
    public static int lcmVal(int a, int b) {
        return a / gcd(a, b) * b;
    }
}
