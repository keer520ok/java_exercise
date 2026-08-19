package practice.basic;

import java.util.Scanner;

/**
 * 3桁の数字を各桁に分解するクラス
 */
public class Ex03 {
    public static void main(String[] args) {
        // Scannerインスタンス生成
        Scanner sc = new Scanner(System.in);

        int num;
        while (true) {
            System.out.print("3桁の整数を入力してください：");
            num = sc.nextInt();
            if (isThreeDigit(num)) {
                break;
            } else {
                System.out.println("入力された数字は3桁ではありません。再度入力してください。");
            }
        }


        // 各桁を計算
        int units = num % 10;//一の位
        int tens = num / 10 % 10;//十の位
        int hundreds = num / 100;//百の位

        // 結果出力
        System.out.println("百の位：" + hundreds);
        System.out.println("十の位：" + tens);
        System.out.println("一の位：" + units);

        sc.close();
    }

    /**
     * 数字が3桁の数 [100,999] か判定する
     *
     * @param number 検証対象の数字
     * @return 3桁の場合はtrue、それ以外はfalse
     */
    public static boolean isThreeDigit(int number) {
        return number >= 100 && number <= 999;
    }
}
