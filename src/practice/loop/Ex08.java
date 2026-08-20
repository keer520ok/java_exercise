package practice.loop;

public class Ex08 {
    public static void main(String[] args) {
        // 平行四辺形を描画
        printParallelogram(3, 6);
        System.out.println("-".repeat(20));
        // 台形を描画
        printTrapezoid(3, 3, 7);
        System.out.println("-".repeat(20));
        // ひし形を描画
        printDiamond(4);
        System.out.println("-".repeat(20));
        // 中空ひし形を描画
        printHollowDiamond(4);

    }

    /**
     * 平行四辺形を描画
     *
     * @param row 行数
     * @param col 1行あたりの*の数
     */
    public static void printParallelogram(int row, int col) {
        for (int i = 0; i < row; i++) {
            // 先頭空白
            for (int k = 0; k < i; k++) {
                System.out.print(" ");
            }
            // *出力
            for (int j = 0; j < col; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    /**
     * 台形を描画
     *
     * @param row   行数
     * @param start 最初の　*　の個数
     * @param end   最後の　*　の個数
     */
    public static void printTrapezoid(int row, int start, int end) {
        int spaceCount = (end - start) / 2;
        for (int i = 0; i < row; i++) {
            // 先頭空白
            for (int k = i; k < spaceCount; k++) {
                System.out.print(" ");
            }
            // *出力
            for (int j = 0; j < start + 2 * i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

    }

    /**
     * ひし形を描画
     *
     * @param midRow 中央の長い行の位置
     */
    public static void printDiamond(int midRow) {
        // 上半分
        for (int i = 1; i <= midRow; i++) {
            for (int k = i; k < midRow; k++) {
                System.out.print(" ");
            }
            for (int j = 0; j < 2 * i - 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        // 下半分
        for (int i = midRow - 1; i >= 1; i--) {
            for (int k = i; k < midRow; k++) {
                System.out.print(" ");
            }
            for (int j = 0; j < 2 * i - 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    /**
     * 中空ひし形を描画
     *
     * @param midRow 中央の長い行の位置
     */
    public static void printHollowDiamond(int midRow) {
        // 上半分
        for (int i = 1; i <= midRow; i++) {
            for (int k = i; k < midRow; k++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= 2 * i - 1; j++) {
                // 先頭、末尾だけ*
                if (j == 1 || j == 2 * i - 1) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        // 下半分
        for (int i = midRow - 1; i >= 1; i--) {
            for (int k = i; k < midRow; k++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= 2 * i - 1; j++) {
                if (j == 1 || j == 2 * i - 1) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}