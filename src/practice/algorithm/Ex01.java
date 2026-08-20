package practice.algorithm;

import java.util.Scanner;

/**
 * 入力された2以上の整数が素数か判定するクラス
 * 素数：1と自分自身以外に約数を持たない自然数
 */
public class Ex01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("2以上の整数を入力：");
        int num = sc.nextInt();

        boolean result = isPrime(num);
        if (result) {
            System.out.println(num + " は素数です");
        } else {
            System.out.println(num + " は素数ではありません");
        }
        sc.close();
    }

    /**
     * 引数の整数が素数か判定するメソッド
     *
     * @param number 判定対象（2以上）
     * @return 素数ならtrue、そうでなければfalse
     */
    public static boolean isPrime(int number) {
        int i = 2;
        while (i <= Math.sqrt(number)) {
            if (number % i == 0) return false;
            i++;
        }
        return true;
    }
}