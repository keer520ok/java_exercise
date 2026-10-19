package practice.algorithm;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 問題：輪になった子供が5番ごとに列を離れ、最後に残る1人を求める
 * 先頭からSTEP-1個を末尾に回し、STEP番目の要素を離脱させる方式
 * 全て両端操作のため配列コピーが発生せず、ArrayList版より高性能
 */
public class Ex10 {
    public static void main(String[] args) {
        final int CHILD_COUNT = 7;    // 子供の総数
        final int STEP = 5;          // 離脱する報数の間隔

        // 1～7の番号をキューに格納
        Queue<Integer> childQueue = new ArrayDeque<>();
        for (int i = 1; i <= CHILD_COUNT; i++) {
            childQueue.offer(i);
        }

        System.out.println("===== ゲーム開始 =====");
        // 最後の1人になるまで繰り返す
        while (childQueue.size() > 1) {
            // 先頭からSTEP-1個を末尾に移動＝数え飛ばし処理
            for (int i = 0; i < STEP - 1; i++) {
                childQueue.offer(childQueue.poll());
            }
            // STEP番目の子供が離脱
            int removedNum = childQueue.poll();
            System.out.printf("離脱した子供：%d番  残り人数：%d人%n", removedNum, childQueue.size());
        }

        System.out.println("\n===== 結果 =====");
        System.out.println("最後に残った子供の番号：" + childQueue.peek() + "番");
    }
}
