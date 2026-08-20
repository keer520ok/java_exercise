package practice.loop;

/**
 * 九九の掛け算表を出力するクラス
 */
public class Ex09 {
    public static void main(String[] args) {
        // i：縦の段（1～9段目）
        for (int i = 1; i <= 9; i++) {
            // j：横の列（1～i列目）
            for (int j = 1; j <= i; j++) {
                System.out.print(j + "*" + i + "=" + j * i + "\t");
            }
            // 1行出力完了後、改行
            System.out.println();
        }
    }
}
