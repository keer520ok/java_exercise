package practice.oop.ex07;

public class ArrayUtil {
    /**
     * 配列を[10, 20, 30]の形式で出力
     *
     * @param arr 整数配列
     */
    static void printArr(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1) {
                System.out.print(arr[i]);
            } else {
                System.out.print(arr[i] + ", ");
            }
        }
        System.out.println("]");
    }

    /**
     * 配列の平均値を計算し返却
     *
     * @param arr 整数配列
     * @return 平均値
     */
    static double getAverage(int[] arr) {
        int len = arr.length;
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }
        return sum / (double) len;
    }
}
