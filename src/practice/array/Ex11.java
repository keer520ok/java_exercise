package practice.array;

/**
 * ソート済配列をマージし中央値を求める
 * 二つの昇順配列をマージし、合成後配列の中央値を計算する。
 * 配列長が偶数の場合、中央2つの値の平均、奇数の場合は真ん中の値。
 */
public class Ex11 {
    public static void main(String[] args) {
        int[] arr1 = {1, 3, 5};
        int[] arr2 = {2, 4, 6, 7};
        double median = findMedian(arr1, arr2);
        System.out.println("中央値 = " + median);

        int[] arr3 = {1, 3, 5};
        int[] arr4 = {2, 4, 6};
        double median1 = findMedian(arr3, arr4);
        System.out.println("中央値 = " + median1);

    }

    /**
     * 二つの昇順配列をマージ
     *
     * @param arr1 昇順配列1
     * @param arr2 昇順配列2
     * @return マージ後の昇順配列
     */
    private static int[] mergeSortedArray(int[] arr1, int[] arr2) {
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

    /**
     * マージ後配列から中央値を求める
     *
     * @param arr1 昇順配列1
     * @param arr2 昇順配列2
     * @return 中央値
     */
    private static double findMedian(int[] arr1, int[] arr2) {
        int[] arr = mergeSortedArray(arr1, arr2);
        int len = arr.length;
        if (len % 2 != 0) {
            return arr[len / 2] * 1.0;
        } else {
            int index = len / 2;
            return (arr[index] + arr[index - 1]) / 2.0;
        }
    }
}
