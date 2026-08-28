package practice.string;

import java.util.Scanner;

/**
 * 2 つの文字列に非負整数を記録し、それらの和を求める。
 */
public class Ex02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("数字1を入力");
        String n1 = sc.next();
        System.out.println("数字2を入力");
        String n2 = sc.next();
        String result = addStrings(n1, n2);
        System.out.println("計算結果：" + result);

    }

    /**
     * 2つの非負整数文字列の和を文字列で返す
     */
    public static String addStrings(String num1, String num2) {
        // 末尾から走査するためのインデックス
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        // 繰り上がり
        int carry = 0;
        // 結果を蓄える文字列ビルダー
        StringBuilder sb = new StringBuilder();

        // 両方の桁を走査し終わり、繰り上がりもなくなるまでループ
        while (i >= 0 || j >= 0 || carry > 0) {
            // 各桁の数値を取得。桁がない場合は0とする
            int digit1 = i >= 0 ? num1.charAt(i) - '0' : 0;
            int digit2 = j >= 0 ? num2.charAt(j) - '0' : 0;

            int sum = digit1 + digit2 + carry;
            // 今の桁の値
            sb.append(sum % 10);
            // 次の桁への繰り上がり
            carry = sum / 10;

            i--;
            j--;
        }

        // 下位から組み立てたので反転して返す
        return sb.reverse().toString();
    }

}
