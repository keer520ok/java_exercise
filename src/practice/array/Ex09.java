package practice.array;

/**
 * 指定値の要素を配列から削除
 * 二重ポインタを使用、元配列を直接上書き
 * 整数配列 nums と値 val が与えられる。配列内の val と等しい要素をすべて削除せよ。
 * 元の配列を直接書き換え、削除後の要素個数を戻り値として返す。
 */
public class Ex09 {
    public static void main(String[] args) {
        int[] nums1 = {3, 2, 2, 3};
        int val1 = 3;
        int len1 = removeElement(nums1, val1);
        System.out.print("例1 残り要素数：" + len1 + "、要素：");
        for (int i = 0; i < len1; i++) {
            System.out.print(nums1[i] + " ");
        }
        System.out.println();

        int[] nums2 = {0, 1, 2, 2, 3, 0, 4, 2};
        int val2 = 2;
        int len2 = removeElement(nums2, val2);
        System.out.print("例2 残り要素数：" + len2 + "、要素：");
        for (int i = 0; i < len2; i++) {
            System.out.print(nums2[i] + " ");
        }
    }

    /**
     * 配列からvalに一致する要素を削除（上書き方式）
     *
     * @param nums 元の整数配列
     * @param val  削除対象の値
     * @return 削除後の有効な要素の個数
     */
    private static int removeElement(int[] nums, int val) {
        // slow：有効要素の書き込み位置
        int slow = 0;
        // fast：配列を走査するポインタ
        for (int fast = 0; fast < nums.length; fast++) {
            // 削除対象以外の値の場合、slow位置へ書き込む
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }
        }
        return slow;
    }
}

