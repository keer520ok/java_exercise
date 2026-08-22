package practice.array;

import java.util.Random;
import java.util.Scanner;

/**
 * ランダムお年玉分配
 * ※総額 MをN個に分割、各人最低 1 円は受け取れる、合計は M に一致する。
 */
public class Ex10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("総金額Mを入力：");
        int totalMoney = sc.nextInt();
        System.out.print("個数Nを入力：");
        int count = sc.nextInt();
        sc.close();

        // 入力値チェック
        if (totalMoney < count) {
            System.out.println("総金額は個数以上にしてください（一人最低1円）");
            return;
        }

        int[] result = splitRedPacket(totalMoney, count);
        for (int i = 0; i < result.length; i++) {
            System.out.println(i + 1 + "人目の金額：" + result[i]);
        }
    }

    /**
     * お年玉をランダムに分割する
     *
     * @param total 総金額
     * @param num   分割個数
     * @return 分割後の金額配列
     */
    public static int[] splitRedPacket(int total, int num) {
        Random rand = new Random();
        int[] arr = new int[num];
        // まず全員に1円を配布（最低保証）
        int remain = total - num;
        int i = 0;
        while (i < num - 1) {
            // 残り金額の範囲内でランダムに取得
            int add = rand.nextInt(remain + 1);
            arr[i] = 1 + add;
            remain = remain - add;
            i++;
        }
        // 最後の要素に残りを全部入れる
        arr[i] = 1 + remain;
        return arr;
    }
}
