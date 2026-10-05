package practice.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * 重複なし点呼システム
 * クラス全員を点呼し終わったら、自動的に次のラウンドを開始する
 */
public class Ex05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("クラスの学生数Nを入力：");
        int n = sc.nextInt();
        sc.close();

        // 1～nの学生番号リストを作成
        List<Integer> studentList = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            studentList.add(i);
        }

        final int TOTAL_ROUND = 2; // 合計2ラウンド実施

        for (int round = 1; round <= TOTAL_ROUND; round++) {
            // ラウンド開始時にリスト全体をランダムにシャッフル
            Collections.shuffle(studentList);

            System.out.printf("%n=== 第%dラウンド 点呼開始 ===%n", round);
            // シャッフル済みの順番で全員を順次点呼
            for (int i = 0; i < studentList.size(); i++) {
                System.out.printf("%d人目：%d番%n", i + 1, studentList.get(i));
            }
            System.out.printf("=== 第%dラウンド 全員点呼完了 ===%n", round);
        }
    }
}
