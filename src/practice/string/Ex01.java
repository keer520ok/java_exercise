package practice.string;

import java.util.Scanner;

/**
 * キーボードから文字列を入力し、
 * 文字列の中の大文字アルファベット、
 * 小文字アルファベット、
 * 数字文字の出現回数を集計する
 * （その他文字は考慮しない）。
 */
public class Ex01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("文字列を入力してください：");
        String input = sc.next();

        // 各種カウンタ
        int upperCount = 0;
        int lowerCount = 0;
        int digitCount = 0;

        // 文字列の各文字を1文字ずつ走査
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            // 大文字判定
            if (Character.isUpperCase(c)) upperCount++;
                // 小文字判定
            else if (Character.isLowerCase(c)) lowerCount++;
                // 数字判定
            else if (Character.isDigit(c)) digitCount++;
            // その他文字は条件により無視
        }

        System.out.println("大文字の数：" + upperCount);
        System.out.println("小文字の数：" + lowerCount);
        System.out.println("数字の数：" + digitCount);
        sc.close();
    }
}

