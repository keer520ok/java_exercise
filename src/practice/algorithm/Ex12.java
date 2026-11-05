package practice.algorithm;

import java.util.Arrays;

/**
 * 演算子不使用の除算
 */
public class Ex12 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(divideBasic(0, 1)));
        System.out.println(Arrays.toString(divideFastPro(10, -3))); // -3 1
        System.out.println(Arrays.toString(divideFastPro(10, 3)));  //3 1
        System.out.println(Arrays.toString(divideFastPro(-10, -3))); // 3 -1
        System.out.println(Arrays.toString(divideFastPro(-10, 3))); // -3 -1

    }

    /**
     * 累減法による除算を実行し、商と剰余を配列で返す
     *
     * @param dividend 被除数（正の整数）
     * @param divisor  除数（正の整数）
     * @return int配列 [0]=商, [1]=剰余
     */
    private static int[] divideBasic(int dividend, int divisor) {
        if (dividend < 0 || divisor <= 0) {
            throw new IllegalArgumentException("引数は0未満にできません");
        }
        int quotient = 0;         // 商のカウンタ
        int remainder = dividend; // 剰余（初期値は被除数）

        // 剰余が除数以上の間、除数を減算し続ける
        while (remainder >= divisor) {
            remainder -= divisor;
            quotient++;
        }

        return new int[]{quotient, remainder};
    }

    /**
     * ビットシフトを利用した高速除算
     *
     * @param dividend 被除数
     * @param divisor  除数
     * @return int配列 [0]=商, [1]=剰余
     */
    private static int[] divideFastPro(int dividend, int divisor) {
        // オーバーフロー例外ケース：Integer.MIN_VALUE / -1
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return new int[]{Integer.MAX_VALUE, 0};
        }

        // 商の符号判定
        boolean isNegative = (dividend ^ divisor) < 0;

        // 絶対値計算時のオーバーフロー回避のため、負数に統一して処理
        int absDividend = dividend > 0 ? -dividend : dividend;
        int absDivisor = divisor > 0 ? -divisor : divisor;

        int quotient = 0;

        // ビットシフトによる高速減算
        while (absDividend <= absDivisor) {
            int shiftCount = 0;
            int currentDivisor = absDivisor;

            while (currentDivisor >= (Integer.MIN_VALUE >> 1) && absDividend <= (currentDivisor << 1)) {
                currentDivisor <<= 1;
                shiftCount++;
            }

            absDividend -= currentDivisor;
            quotient += 1 << shiftCount;
        }

        // 商の符号を復元
        int finalQuotient = isNegative ? -quotient : quotient;
        // 剰余の符号は被除数に従う
        int remainder = dividend > 0 ? -absDividend : absDividend;

        return new int[]{finalQuotient, remainder};
    }
}
