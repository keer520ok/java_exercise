package practice.string;

import java.util.Scanner;

/**
 * 指定文字の出現回数を集計（大文字小文字非区別）
 */

public class Ex06 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1行目：空白を含む文字列を読み込み
        String input = sc.nextLine();
        // 2行目：比較対象の文字を読み込み
        char target = sc.nextLine().charAt(0);

        // 大文字小文字を区別しないため、両方を小文字に統一
        input = input.toLowerCase();
        target = Character.toLowerCase(target);

        int count = 0;
        // 文字列の各文字を走査して一致したらカウント
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == target) {
                count++;
            }
        }

        System.out.println(count);
        sc.close();
    }
}
