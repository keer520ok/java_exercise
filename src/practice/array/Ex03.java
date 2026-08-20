package practice.array;

import java.util.Random;

/**
 * 0～100の重複しない乱数を10個生成し配列に格納する練習
 */
public class Ex03 {
    public static void main(String[] args) {
        Random r = new Random();
        int[] arr = new int[10];
        int i = 0;

        // 配列が10個埋まるまで繰り返し
        while (i < arr.length) {
            int n = r.nextInt(101);
            // 重複チェック
            boolean flag = checkDuplicate(arr, i, n);
            // 重複していなければ配列へ保存
            if (flag) {
                arr[i] = n;
                i++;
            }
        }
        for (int i1 : arr) {
            System.out.println(i1);
        }

    }

    /**
     * 配列内に対象の数字が存在するか確認
     *
     * @param arr          対象配列
     * @param filledLength 現在埋まっている要素の長さ
     * @param num          確認する数値
     * @return 重複:false  重複なし:true
     */
    public static boolean checkDuplicate(int[] arr, int filledLength, int num) {
        for (int j = 0; j < filledLength; j++) {
            if (num == arr[j]) return false;
        }
        return true;
    }
}
