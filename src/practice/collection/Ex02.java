package practice.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 * 1～100の整数を入力して集合に追加し、合計が200を超えた時点で処理を終了する
 */
public class Ex02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> numberList = new ArrayList<>();
        int total = 0; // 集合内の数値の合計値を保持

        System.out.println("1～100の整数を入力してください。合計が200を超えると自動終了します。");

        // 合計が200以下の間、入力を繰り返す
        while (total <= 200) {
            System.out.print("整数を入力：");

            // 整数として読み込めるか事前チェック
            if (!sc.hasNextInt()) {
                System.out.println("整数以外が入力されました。再度入力してください。");
                sc.next(); // 不正な入力を読み捨て
                continue;
            }

            int num = sc.nextInt();

            // 1～100の範囲外の場合は再入力を促す
            if (num < 1 || num > 100) {
                System.out.println("1～100の範囲で入力してください。");
                continue;
            }

            // 集合に追加し、合計値を更新
            numberList.add(num);
            total += num;
            System.out.printf("追加完了 現在の合計：%d%n", total);
        }

        // 最終結果を出力
        System.out.println("\n===== 処理終了 =====");
        System.out.println("集合の全要素：" + numberList);
        System.out.println("最終合計値：" + total);
        sc.close();
    }
}
