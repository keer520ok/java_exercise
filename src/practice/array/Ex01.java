package practice.array;

/**
 * 配列の最大値を求める練習
 */
public class Ex01 {
    public static void main(String[] args) {
        int[] arr = {33, 5, 22, 44, 55};
        // 最初の要素を仮の最大値とする
        int max = arr[0];

        // 配列をループで比較
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        System.out.println("最大値：" + max);
    }
}
