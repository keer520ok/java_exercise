package practice.loop;

/**
 * フィボナッチ数列の第10項目を求めるクラス
 * ある数列がある。第 3 項目から、各項目は前の 2 つの項目の和となる。
 * 数列：0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89……
 * 第 10 項目の値を求めよ。
 */
public class Ex03 {
    public static void main(String[] args) {
        int res = getFib(10);
        System.out.println("第10項目：" + res);
    }

    /**
     * フィボナッチ数列の第n項目を返すメソッド
     *
     * @param n 取得したい項番号
     * @return 第n項目の値
     */
    public static int getFib(int n) {
        if (n == 1) return 0;
        if (n == 2) return 1;
        int prev1 = 0;
        int prev2 = 1;
        int res = 0;
        for (int i = 3; i <= n; i++) {
            res = prev1 + prev2;
            prev1 = prev2;
            prev2 = res;
        }
        return res;
    }
}
