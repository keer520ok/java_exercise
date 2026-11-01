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
        if (num < 0 || (num % 10 == 0 && num != 0)) {
            return false;
        }
        if (num <= 9) return true;

        int reversedHalf = 0;
        // 元の数が反転後の数以下になったら、半分の桁まで処理したと判定
        while (num > reversedHalf) {
            // 末尾桁を取り出し、反転数の末尾に追加
            reversedHalf = reversedHalf * 10 + num % 10;

            // 元の数から末尾桁を削除
            num = num / 10;
        }

        // 偶数桁の場合：xと反転数が完全一致
        // 奇数桁の場合：反転数を10で割って中央の桁を除外して比較
        return num == reversedHalf || num == reversedHalf / 10;
    }
}
