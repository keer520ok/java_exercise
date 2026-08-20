package practice.array;

import java.util.Random;

/**
 * 配列の要素をランダムに並び替える練習（Fisher-Yatesシャッフル）
 */
public class Ex02 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Random r = new Random();

        // 後ろから順に、ランダムな位置と入れ替え
        for (int i = arr.length - 1; i > 0; i--) {
            int index = r.nextInt(i + 1);
            // 要素の交換
            int temp = arr[i];
            arr[i] = arr[index];
            arr[index] = temp;
        }

        // 結果出力
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
