package practice.algorithm;

import java.util.Arrays;
/**
 * // バブルソート（降順）
 */
public class Ex06 {
    public static void main(String[] args) {
        int[] arr = {16, 5, 9, 12, 21, 18,
                32, 23, 37, 26, 45, 34,
                50, 48, 61, 52, 73, 66};

        // バブルソート（降順）：交換無し検知による早期終了最適化
        for (int i = 0; i < arr.length - 1; i++) {
            // 今回の走査で交換処理が発生したかを記録するフラグ
            boolean swapped = false;

            // 末尾からi個分は既にソート済みのため、比較範囲を狭める
            for (int j = 0; j < arr.length - 1 - i; j++) {
                // 隣接2要素を比較：左が小さければ入れ替え（大きい順に並べる）
                if (arr[j] < arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                    swapped = true;
                }
            }

            // 一度も交換が発生しなければ整列済みと判断し、ループを抜ける
            if (!swapped) {
                break;
            }
        }

        String result = Arrays.toString(arr);
        System.out.println(result);
    }
}
