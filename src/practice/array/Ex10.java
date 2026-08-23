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
        System.out.print("総金額Mを入力: ");
        int totalMoney = sc.nextInt();
        System.out.print("個数Nを入力: ");
        int count = sc.nextInt();
        sc.close();

        //入力値チェック
        if (count < 1) {
            System.out.println("お年玉の数は 0 より大きい値を指定してください");
            return;
        }
        // 人数分最低1円が必要
        if (totalMoney < count) {
            System.out.println("総金額は個数以上にしてください（一人最低1円）");
            return;
        }

        int[] result = splitRedPacket(totalMoney, count);
        for (int i = 0; i < result.length; i++) {
            System.out.println(i + 1 + "人目の金額: " + result[i]);
        }
    }

    /**
     * 自作バブルソート
     *
     * @param arr ソート対象のint配列
     */
    private static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    /**
     * お年玉をランダムに分割する
     * 補足：このアルゴリズムは統計的に公平（大量実行時の平均値が均等）
     * 一方、1回の実行で極端な金額格差が発生する場合がある。
     * 現実のサービスでは二倍平均法を使い、一度に大金が取られることを抑制する。
     *
     * @param total 総金額
     * @param num   分割個数
     * @return 分割後の金額配列
     */
    private static int[] splitRedPacket(int total, int num) {
        int[] arr = new int[num];
        //1 人の場合、分配処理は不要
        if (num == 1) {
            arr[0] = total;
            return arr;
        }
        Random r = new Random();
        // 全員に最低1円を保証
        int remain = total - num;

        // 分割点を num‑1 個生成
        int[] splitPoint = new int[num - 1];
        for (int i = 0; i < num - 1; i++) {
            /*  nextInt(remain+1)：0～remain（両端含む）の範囲から乱数を取得
             各受取人の追加金額の数学的期待値が均等になる
             注意：分割点が右端に重なる場合、追加金額が0となり最低保証金額のみとなるケースが発生する*/
            splitPoint[i] = r.nextInt(remain + 1);
        }
        // 自作ソートで分割点を昇順に並べる
        bubbleSort(splitPoint);

        // 1人目の金額
        arr[0] = 1 + splitPoint[0];

        // 中間の人の金額
        for (int i = 1; i < num - 1; i++) {
            arr[i] = 1 + (splitPoint[i] - splitPoint[i - 1]);
        }
        // 最後の人の金額、残り全部割り当て
        arr[num - 1] = 1 + (remain - splitPoint[num - 2]);

        return arr;
    }
}
