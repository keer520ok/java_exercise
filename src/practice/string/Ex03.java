package practice.string;
/**
 * 文字列数値の加算、複数の大数加算アルゴリズム
 */

public class Ex03 {
    public static void main(String[] args) {
        System.out.println(addAll("999", "2"));          // 1001
        System.out.println(addAll("123", "456", "789")); // 1368
        System.out.println(addAll("000123", "00456"));   // 579
    }

    public static String addAll(String... nums) {
        StringBuilder sb = new StringBuilder();
        // 各数の現在の桁位置
        int[] index = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            index[i] = nums[i].length() - 1;
        }

        int carry = 0;
        while (true) {
            boolean hasMoreDigit = false;
            int sum = carry;

            // 全ての数の現在の桁を加算
            for (int i = 0; i < nums.length; i++) {
                if (index[i] >= 0) {
                    sum += nums[i].charAt(index[i]) - '0';
                    hasMoreDigit = true;
                    index[i]--;
                }
            }

            // 桁も繰り上がりも残っていなければ終了
            if (!hasMoreDigit && carry == 0) {
                break;
            }

            sb.append(sum % 10);
            carry = sum / 10;
        }

        // 反転
        sb.reverse();
        // 先頭の余分な0を除去
        while (sb.length() > 1 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }

        return sb.toString();
    }
}