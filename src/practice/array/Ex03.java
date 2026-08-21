package practice.array;

import java.util.Random;

/**
 * 0～100の重複しない乱数を10個生成し配列に格納する練習
 */
public class Ex03 {
    public static void main(String[] args) {

        int[] arr = is(10, 0, 100);
        for (int i1 : arr) {
            System.out.println(i1);
        }

    }

    /**
     * 指定個数、指定範囲の重複なし乱数配列を返す
     *
     * @param count 要素数
     * @param min   最小値
     * @param max   最大値
     * @return 重複なしのint配列
     */
    private static int[] is(int count, int min, int max) {
        Random r = new Random();
        int[] arr = new int[count];

        int i = 0;
        // 配列が10個埋まるまで繰り返し
        while (i < arr.length) {
            int n = r.nextInt(min, max + 1);
            // 重複チェック
            boolean flag = checkDuplicate(arr, i, n);
            // 重複していなければ配列へ保存
            if (flag) {
                arr[i] = n;
                i++;
            }
        }
        return arr;
    }

    /**
     * 配列内に対象の数字が存在するか確認
     *
     * @param arr          対象配列
     * @param filledLength 現在埋まっている要素の長さ
     * @param num          確認する数値
     * @return 重複:false  重複なし:true
     */
    private static boolean checkDuplicate(int[] arr, int filledLength, int num) {
        for (int j = 0; j < filledLength; j++) {
            if (num == arr[j]) return false;
        }
        return true;
    }
}
