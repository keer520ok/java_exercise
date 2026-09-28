package practice.algorithm;

import java.util.Arrays;

/**
 * クイックソート実装
 */
public class Ex07 {
    public static void main(String[] args) {
        int[] arr = {1, 7, 18, 88, 2, 51, 40, 13, 66, 41, 100};

        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void selectionSort(int[] arr) {
        // 配列がnull、または要素数が2未満の場合は何もしない
        if (arr == null || arr.length < 2) {
            return;
        }

        for (int i = 0; i < arr.length - 1; i++) {
            // 最小値のインデックスを保存する
            int minIndex = i;

            for (int j = i + 1; j < arr.length; j++) {
                // より小さい値が見つかったら更新する
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            // 最小値が現在位置と異なる場合のみ交換する
            if (minIndex != i) {
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
    }
}
