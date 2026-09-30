package practice.algorithm;

import java.util.Arrays;

/**
 * 二分探索挿入ソート実装 挿入位置探索最適化
 */
public class Ex09 {
    public static void main(String[] args) {

        int[] arr = {1, 7, 18, 88, 2, 51, 40, 13, 66, 41, 100};
        binaryInsertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    // 二分挿入ソート
    public static void binaryInsertionSort(int[] arr) {
        // 配列がnull、または要素数が2未満の場合は何もしない
        if (arr == null || arr.length < 2) {
            return;
        }
        // 2番目の要素から順に、正しい位置へ挿入していく
        for (int i = 1; i < arr.length; i++) {

            int current = arr[i];

            int j = i - 1;
            if (current < arr[j]) {
                // 挿入位置を二分探索で求める
                int left = 0;
                int right = i;

                while (left <= right) {
                    // 中央のインデックスを計算する（オーバーフロー対策）
                    int mid = left + (right - left) / 2;
                    // 同じ値の場合は後ろに挿入して安定性を保つ
                    if (current >= arr[mid]) left = mid + 1;
                    else right = mid - 1;
                }
                // left が挿入位置となる
                // 挿入位置から現在位置までの要素を右へ1つずらす
                while (j >= left) {
                    arr[j + 1] = arr[j];
                    j--;
                }
                // 現在の要素を正しい位置に挿入する
                arr[left] = current;
            }
        }
    }

}