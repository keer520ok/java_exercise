package practice.array;

/**
 * 二数之和問題：合計がtargetとなる要素のインデックスを探す練習
 */
public class Ex05 {
    public static void main(String[] args) {
        int[] arr = {1, 3, 3, 4, 5};
        findAllTwoSum(arr, 4);

    }

    /**
     * 要件2：条件に合致するすべてのインデックス組をコンソールに出力
     *
     * @param nums   対象配列
     * @param target 目標合計値
     */
    public static void findAllTwoSum(int[] nums, int target) {
        boolean hasResult = false;
        for (int i = 0; i < nums.length - 1; i++) {
            int num1 = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                int num2 = nums[j];
                if (num1 + num2 == target) {
                    System.out.println("index:" + i + "," + j);
                    hasResult = true;
                }
            }
        }
        if (!hasResult) System.out.println("条件に合致する組が存在しません");
    }
}
