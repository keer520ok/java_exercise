package practice.loop;

/**
 * 正三角形と逆三角形を*で出力するクラス
 */
public class Ex07 {
    public static void main(String[] args) {
        // 総行数
        int line = 5;
        // 正三角形を出力
        for (int i = 0; i < line; i++) {
            for (int j = i; j >= 0; j--) {
                System.out.print("*");
            }
            System.out.println();
        }

        System.out.println();
        // 逆三角形を出力
        for (int i = 0; i < line; i++) {
            for (int j = i; j < line; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}