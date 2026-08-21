package practice.array;

/**
 * 2つの昇順有序配列をマージし、新しい昇順配列を返す練習
 */
public class Ex06 {
    public static void main(String[] args) {
        int[] arr1 = {1, 3, 5, 7, 9};
        int[] arr2 = {2, 4, 6, 8, 10};
        int[] arr3 = mergeSortedArray(arr1, arr2);

        for (int i : arr3) {
            System.out.println(i);
        }

    }

    /**
     * 二つの昇順配列をマージ、新しい昇順配列を返す（2ポインタ方式）
     *
     * @param arr1 昇順配列1
     * @param arr2 昇順配列2
     * @return マージ後の昇順配列
     */
    public static int[] mergeSortedArray(int[] arr1, int[] arr2) {
        // マージ後配列の長さ = 二つの配列長の合計
        int[] newArr = new int[arr1.length + arr2.length];

        int i = 0; // newArr用ポインタ
        int j = 0; // arr1用ポインタ
        int k = 0; // arr2用ポインタ

        // 両方の配列の要素が残っている間比較
        while (j < arr1.length && k < arr2.length) {
            if (arr1[j] >= arr2[k]) {
                newArr[i] = arr2[k];
                k++;
            } else {
                newArr[i] = arr1[j];
                j++;
            }
            i++;
        }

        // arr1に残った要素を全部代入
        while (j < arr1.length) {
            newArr[i++] = arr1[j++];
        }
        // arr2に残った要素を全部代入
        while (k < arr2.length) {
            newArr[i++] = arr2[k++];
        }

        return newArr;
    }
}