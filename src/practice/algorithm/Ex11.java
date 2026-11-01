package practice.algorithm;

/**
 * 回文数判定プログラム
 */
public class Ex11 {
    public static void main(String[] args) {
        System.out.println(isPalindrome(121));   // true
        System.out.println(isPalindrome(-121));  // false
        System.out.println(isPalindrome(122));   // false
        System.out.println(isPalindrome(10));    // false
    }

    /**
     * 整数が回文数かどうかを判定する
     *
     * @param num 判定対象の整数
     * @return 回文数の場合true、そうでない場合false
     */
    private static boolean isPalindrome(int num) {
        // 負数、または0以外で末尾が0の数は回文数になりえない
        if (num < 0 || (num % 10 == 0 && num != 0)) return false;
        if (num <= 9) return true;

        int tmep = num;
        int reversedHalf = 0;
        while (tmep > 0) {
            reversedHalf = reversedHalf * 10 + tmep % 10;
            tmep /= 10;
        }
        return reversedHalf == num;

    }
}
